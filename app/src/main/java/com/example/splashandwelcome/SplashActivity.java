package com.example.splashandwelcome;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    private final int DURACION_SPLASH = 2000;
    private ImageView splashImage;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
       // splashImage=(ImageView) findViewById(R.id.ivSplash);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable(){
            public void run(){
                splashImage=(ImageView) findViewById(R.id.ivSplash);
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String> (splashImage, "imageTransition");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this,pairs);
                startActivity(intent, options.toBundle());
                finish();


            };
        }, DURACION_SPLASH);
    }
}
