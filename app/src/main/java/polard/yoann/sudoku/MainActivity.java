package polard.yoann.sudoku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotojeu(View v){
        Intent intent = new Intent(this, activity_jeu.class);
        startActivity(intent);
    }

    public void gotoapropos(View v){
        Intent intent = new Intent(this, activity_about.class);
        startActivity(intent);
    }
}