package com.example.galaw;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class actStressHeal3 extends AppCompatActivity {

    Button playvideo;
    VideoView videoGalaw;
    MediaController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_stress_heal3);

        playvideo = findViewById(R.id.playVideo);
        videoGalaw = findViewById(R.id.videoGalaw);
        controller = new MediaController(this);
    }

    public void videoplay (View v){

        String videopath = "android.resource://" + getPackageName() + "/" + R.raw.ruangsandar;

        Uri uri = Uri.parse(videopath);
        videoGalaw.setVideoURI(uri);
        videoGalaw.setMediaController(controller);
        controller.setAnchorView(videoGalaw);
        videoGalaw.start();

    }
}
