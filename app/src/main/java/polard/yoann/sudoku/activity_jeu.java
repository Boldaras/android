package polard.yoann.sudoku;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.Arrays;

public class activity_jeu extends AppCompatActivity {



     Grille grille;
     Intent intent;
     int x;
     int y;
     final String[] tab = {"0","1","2","3","4","5","6","7","8","9"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);
         grille = (Grille) findViewById(R.id.grille);
         intent =  new Intent(this, activity_choix.class);
    }

    
    public boolean onTouchEvent(MotionEvent event) {
        int eventAction = event.getAction();
        x = (int) event.getX();
        y = (int) event.getY();
        int ret;


        int ligne = grille.getHeight();
        int col = grille.getWidth();
        int temp = ligne - col;
        y = y - temp;

        final int numCol = (int) (x*9/col);
        final int numLigne = (int) (y*9/ligne);



        if(x > ligne){
            return true;
        }
        if(y > col){
            return true;
        }



        switch (eventAction) {
            case MotionEvent.ACTION_DOWN:

                    if ( grille.isNotFix(numLigne, numCol)) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setTitle("Choisissez un nombre").setItems(tab, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String ret = Arrays.asList(tab).get(which);
                                grille.set(numLigne,numCol,Integer.parseInt(ret));
                                grille.invalidate();
                            }
                        });
                        builder.create().show();
                }


                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
        }

        return true;
    }

    public void test(View v){
        grille.gagne();
        grille.invalidate();
    }


}