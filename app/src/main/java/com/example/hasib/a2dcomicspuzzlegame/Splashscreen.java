package com.example.securesoftbd.avengersassemble;

import android.content.Intent;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.MenuItem;

import android.view.WindowManager;


import com.example.hasib.a2dcomicspuzzlegame.R;

import static com.example.securesoftbd.avengersassemble.Variable.*;

public class Splashscreen extends AppCompatActivity {



   // int r=0;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slash_activity);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

      //  final ImageView image=findViewById(R.id.slash_screen1);

        /* r=getIntent().getIntExtra("ok",0);
        if (r!=0 && r==1){
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }else {
            return;
        }*/
     //;

        mediaPlayer = MediaPlayer.create(getApplicationContext(), com.example.hasib.avengersassemble.R.raw.background_song);

        new Handler().postDelayed(new Runnable()
        {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void run() {

                Intent intent = new Intent(Splashscreen.this, MainActivity.class);
                startActivity(intent);
                finish();

            }

        },1500);

    }



    @Override
    protected void onStart(){

        super.onStart();

        sp = getSharedPreferences("Music",MODE_PRIVATE);

        if(sp.getBoolean("music",true))
        {
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
            Common.isPlaying=true;
        }
        else if(sp.getBoolean("music",false))
        {
            mediaPlayer.pause();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {



        return super.onOptionsItemSelected(item);
    }
}
