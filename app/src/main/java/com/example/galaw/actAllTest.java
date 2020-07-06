package com.example.galaw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class actAllTest extends AppCompatActivity {

    Button level1, level2, level3, lock1, lock2;
    int editklik;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_all_test);

        level1 = (Button) findViewById(R.id.level1);
        level2 = (Button) findViewById(R.id.level2);
        level3 = (Button) findViewById(R.id.level3);
        lock1 = (Button) findViewById(R.id.lock1);
        lock2 = (Button) findViewById(R.id.lock2);




        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Intent intent = new Intent(actAllTest.this, actStress.class);
                startActivity(intent);

                level1.setVisibility(View.VISIBLE);
                level2.setVisibility(View.VISIBLE);
                level3.setVisibility(View.INVISIBLE);
                lock1.setVisibility(View.VISIBLE);
                lock2.setVisibility(View.VISIBLE);

            }
        });


        level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(actAllTest.this, actAnxiety.class);
                startActivity(intent);

                level1.setVisibility(View.VISIBLE);
                level2.setVisibility(View.VISIBLE);
                level3.setVisibility(View.VISIBLE);
                lock1.setVisibility(View.INVISIBLE);
                lock2.setVisibility(View.INVISIBLE);

            }
        });

        level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(actAllTest.this, actDepression.class);
                startActivity(intent);

                level1.setVisibility(View.VISIBLE);
                level2.setVisibility(View.VISIBLE);
                level3.setVisibility(View.VISIBLE);
                lock1.setVisibility(View.INVISIBLE);
                lock2.setVisibility(View.INVISIBLE);

            }
        });
    }

}