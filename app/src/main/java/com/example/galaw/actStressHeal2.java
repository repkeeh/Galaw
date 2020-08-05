package com.example.galaw;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class actStressHeal2 extends AppCompatActivity {

    Button playBtn, nextheal2, prevheal2, nextYoutube;
    SeekBar positionBar;
    TextView elapsedTimeLabel;
    TextView remainingTimeLabel;
    MediaPlayer mp;
    ImageView vinyl;
    int totalTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_stress_heal2);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        nextYoutube = findViewById(R.id.nextYoutube);
        playBtn = (Button) findViewById(R.id.playBtn);
        elapsedTimeLabel = (TextView) findViewById(R.id.elapsedTimeLabel);
        remainingTimeLabel = (TextView) findViewById(R.id.remainingTimeLabel);
        nextheal2 = findViewById(R.id.nextheal2);
        prevheal2 = findViewById(R.id.prevheal2);
        vinyl = findViewById(R.id.vinyl);

        nextYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (actStressHeal2.this, actWebView.class);
                mp.pause();
                playBtn.setBackgroundResource(R.drawable.play);
                startActivity(intent);
            }
        });

        nextheal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (actStressHeal2.this, actWebView.class);
                mp.pause();
                playBtn.setBackgroundResource(R.drawable.play);
                startActivity(intent);
            }
        });

        prevheal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (actStressHeal2.this, actStressHeal1.class);
                startActivity(intent);
            }
        });

        // Media Player
        mp = MediaPlayer.create(this, R.raw.relaksasi);
        mp.setLooping(true);
        mp.seekTo(0);
        mp.setVolume(0.5f, 0.5f);
        totalTime = mp.getDuration();

        // Position Bar
        positionBar = (SeekBar) findViewById(R.id.positionBar);
        positionBar.setMax(totalTime);
        positionBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if (fromUser) {
                            mp.seekTo(progress);
                            positionBar.setProgress(progress);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );


        // Thread (Update positionBar & timeLabel)
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mp != null) {
                    try {
                        Message msg = new Message();
                        msg.what = mp.getCurrentPosition();
                        handler.sendMessage(msg);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {}
                }
            }
        }).start();

    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int currentPosition = msg.what;
            // Update positionBar.
            positionBar.setProgress(currentPosition);

            // Update Labels.
            String elapsedTime = createTimeLabel(currentPosition);
            elapsedTimeLabel.setText(elapsedTime);

            String remainingTime = createTimeLabel(totalTime-currentPosition);
            remainingTimeLabel.setText("- " + remainingTime);
        }
    };

    public String createTimeLabel(int time) {
        String timeLabel = "";
        int min = time / 1000 / 60;
        int sec = time / 1000 % 60;

        timeLabel = min + ":";
        if (sec < 10) timeLabel += "0";
        timeLabel += sec;

        return timeLabel;
    }

    public void playBtnClick(View view) {

        Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        vinyl.startAnimation(rotate);


        if (!mp.isPlaying()) {
            // Stopping
            mp.start();
            playBtn.setBackgroundResource(R.drawable.stop);
            vinyl.setBackgroundResource(R.drawable.vinyl);


        } else {
            // Playing
            mp.pause();
            playBtn.setBackgroundResource(R.drawable.play);
        }

    }

    @Override
    public void onBackPressed() {

        if(mp.isPlaying()){
            mp.stop();
            mp = null;
        }
        super.onBackPressed();
    }
}
