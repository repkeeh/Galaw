package com.example.galaw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class actDiary extends AppCompatActivity {

    Button savediary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_diary);

        savediary = findViewById(R.id.savediary);

        savediary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(actDiary.this, actHome.class);
                startActivity(intent);
            }
        });
    }
}
