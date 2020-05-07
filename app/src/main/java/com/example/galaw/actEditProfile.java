package com.example.galaw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class actEditProfile extends AppCompatActivity {

    Button save;
    Button backProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_edit_profile);

        save = findViewById(R.id.save);
        backProfile =findViewById(R.id.backProfile);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( actEditProfile.this, fragProfile.class);
                startActivity(intent);


            }
        });

        backProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( actEditProfile.this, fragProfile.class);
                startActivity(intent);


            }
        });
    }
}
