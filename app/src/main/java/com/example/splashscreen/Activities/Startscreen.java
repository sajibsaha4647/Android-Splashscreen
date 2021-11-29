package com.example.splashscreen.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.example.splashscreen.R;

public class Startscreen extends AppCompatActivity {

    private ProgressBar progressBar;
    private Thread thread;
    int values;
      Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startactivity);




        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        progressBar = findViewById(R.id.progressss);

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Progressing();
                startApp();
            }
        });

        thread.start();
    }


    public  void Progressing(){
            for(values = 20; values <=100; values= values+20){
                try {
                    Thread.sleep(1000);
                    progressBar.setProgress(values);
                }catch (Exception e){
                    e.getStackTrace();
                }
            }
    }



    public void startApp (){
        intent = new Intent(Startscreen.this,MainActivity.class);
        this.startActivity(intent);
        finish();
    }
}