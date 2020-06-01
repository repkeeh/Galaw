package com.example.galaw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jgabrielfreitas.core.BlurImageView;

public class actDepresiHeal1 extends AppCompatActivity {

    BlurImageView blurImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_depresi_heal1);

        blurImage = findViewById(R.id.blurImage);
        blurImage.setBlur(2);
    }
}
