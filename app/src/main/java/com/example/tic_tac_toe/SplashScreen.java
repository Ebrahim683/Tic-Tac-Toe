package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {


    //Import Variables
    TextView tv;
    ImageView img;
    ProgressBar prg;
    Animation animation;
    int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        //Find ID
        tv = findViewById(R.id.textS);
        img = findViewById(R.id.imageS);
        prg = findViewById(R.id.ProgressID);

        //Set Animation
        animation = AnimationUtils.loadAnimation(this,R.anim.img_anim);
        img.setAnimation(animation);

        //Using Thread For ProgressBar And Intent
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                DoWork();
                StartActivity();
            }
        });thread.start();

    }


    //ProgressBar Work
    private void DoWork(){

        for (progress = 20; progress<100; progress=progress+20);{
            try {
                Thread.sleep(2000);
                prg.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //App Start
    private void StartActivity(){

        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
        finish();

    }





}