package com.example.galaw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class actAllTest extends AppCompatActivity {

    Button level1, level2, level3, lock1, lock2;
    int editklik;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_all_test);
        int levelquiz = getIntent().getIntExtra("quiz",-1);
        level1 = (Button) findViewById(R.id.level1);
        level2 = (Button) findViewById(R.id.level2);
        level3 = (Button) findViewById(R.id.level3);
        lock1 = (Button) findViewById(R.id.lock1);
        lock2 = (Button) findViewById(R.id.lock2);

        preferences = this.getSharedPreferences("myPref", MODE_PRIVATE);
        if(preferences.getInt("editklik",-1) == -1){
            level1.setVisibility(View.VISIBLE);
            level2.setVisibility(View.INVISIBLE);
            level3.setVisibility(View.INVISIBLE);
        }
        else if(preferences.getInt("editklik",-1) == 1){
            level1.setVisibility(View.VISIBLE);
            level2.setVisibility(View.VISIBLE);
            level3.setVisibility(View.INVISIBLE);
        }
        else if(preferences.getInt("editklik",-1) == 2){
            level1.setVisibility(View.VISIBLE);
            level2.setVisibility(View.VISIBLE);
            level3.setVisibility(View.VISIBLE);
        }

        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor edit =preferences.edit();
                edit.putInt("editklik", 1);
                edit.commit();
                Intent intent = new Intent(actAllTest.this, actStress.class);
                intent.putExtra("quiz",1);
                startActivity(intent);

                //level1.setVisibility(View.VISIBLE);
                //level2.setVisibility(View.INVISIBLE);
                //level3.setVisibility(View.INVISIBLE);
                //lock1.setVisibility(View.VISIBLE);
                //lock2.setVisibility(View.VISIBLE);

            }
        });

        level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor edit = preferences.edit();
                edit.putInt("editklik", 2);
                edit.commit();

                Intent intent = new Intent(actAllTest.this, actAnxiety.class);
                intent.putExtra("quiz",2);
                startActivity(intent);

                //level1.setVisibility(View.VISIBLE);
                //level2.setVisibility(View.VISIBLE);
                //level3.setVisibility(View.VISIBLE);
                //lock1.setVisibility(View.INVISIBLE);
                //lock2.setVisibility(View.INVISIBLE);

            }
        });

        level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor edit = preferences.edit();
                edit.putInt("editklik", 3);
                edit.commit();

                Intent intent = new Intent(actAllTest.this, actStress.class);
                intent.putExtra("quiz",3);
                startActivity(intent);

                //level1.setVisibility(View.VISIBLE);
                //level2.setVisibility(View.VISIBLE);
                //level3.setVisibility(View.VISIBLE);
                //lock1.setVisibility(View.INVISIBLE);
                //lock2.setVisibility(View.INVISIBLE);

            }
        });

        lock1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(actAllTest.this, "Selesaikan level 1 dulu ya", Toast.LENGTH_LONG).show();
            }
        });

        lock2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(actAllTest.this, "Selesaikan level 2 dulu ya", Toast.LENGTH_LONG).show();
            }
        });

    }

}