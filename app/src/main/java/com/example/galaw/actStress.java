package com.example.galaw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class actStress extends AppCompatActivity {

    Button stressTest, cancelStress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_stress);

        stressTest = findViewById(R.id.stressTest);
        cancelStress = findViewById(R.id.cancelStress);

        stressTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(actStress.this, actQuizStress.class);
                intent.putExtra("type_Question" , 0);
                startActivity(intent);
            }
        });

        cancelStress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(actStress.this, actHome.class);

                startActivity(intent);
            }
        });

    }
}
