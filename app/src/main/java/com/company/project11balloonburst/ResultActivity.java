package com.company.project11balloonburst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView youscore,highscore,textView;
    Button exitgame,playagain;

    int scoreresult;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        youscore = findViewById(R.id.yourscore);
        highscore = findViewById(R.id.highscore);
        exitgame = findViewById(R.id.exitgame);
        playagain = findViewById(R.id.playagain);
        textView = findViewById(R.id.textView);


         scoreresult =getIntent().getIntExtra("score",0);

         youscore.setText("Your Score" + scoreresult);


         exitgame.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 finish();
                 System.exit(0);
             }
         });

         playagain.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(new Intent(ResultActivity.this,MainActivity.class));
                 finish();
             }
         });

         sharedPreferences = this.getSharedPreferences("Score", Context.MODE_PRIVATE);
         int highestscore = sharedPreferences.getInt("highestscore",0);

         if(scoreresult>=highestscore){
             sharedPreferences.edit().putInt("highestscore",scoreresult).apply();
             highscore.setText("High Score :" + scoreresult);
             textView.setText("CONGRATULATIONS YOU CROSSED THE HIGH SCORE, SEtted NEW SCORE");

         }else{
             highscore.setText("High Score :" + highestscore);
         }






    }
}