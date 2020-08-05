package com.example.galaw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.net.URI;

public class actAnxietyHeal extends AppCompatActivity {

    Button callKlinik, backTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_anxiety_heal);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        callKlinik = findViewById(R.id.callKlinik);
        backTest = findViewById(R.id.backTest);

        callKlinik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(actAnxietyHeal.this, klinikYarsi.class);
                startActivity(intent);
            }
        });

        backTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(actAnxietyHeal.this, actAnxiety.class);
                startActivity(intent);
            }
        });

    }

    public void onBackPressed() {
        Intent intent = new Intent(actAnxietyHeal.this, actHome.class);
        startActivity(intent);
    }
}