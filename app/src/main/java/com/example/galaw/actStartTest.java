package com.example.galaw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class actStartTest extends AppCompatActivity {

    Button startTest;
    int editklik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_start_test);

        startTest = findViewById(R.id.startTest);

        startTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences klik = getSharedPreferences("diklik", MODE_PRIVATE);
                SharedPreferences.Editor editor = klik.edit();
                editor.putInt("editklik", editklik);
                editor.commit();
            }
        });

    }
}