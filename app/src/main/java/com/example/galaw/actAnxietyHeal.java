package com.example.galaw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URI;

public class actAnxietyHeal extends AppCompatActivity {

    Button callKlinik, backTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_anxiety_heal);

        callKlinik = findViewById(R.id.callKlinik);
        backTest = findViewById(R.id.backTest);

        callKlinik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData((Uri.parse("tel: 0214223138")));
                startActivity(intent);
            }
        });

        backTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(actAnxietyHeal.this, actQuizAnxiety.class);
                startActivity(intent);
            }
        });

    }
}