package com.example.galaw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class actHome extends AppCompatActivity  {


    ImageButton setting;
    Button[] navigationButton = new Button[4];
    int indexNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_home);

        indexNav = 0;
        navigationButton[0] = findViewById(R.id.homeButton);
        navigationButton[1] = findViewById(R.id.publicButton);
        navigationButton[2] = findViewById(R.id.healButton);
        navigationButton[3] = findViewById(R.id.profileButton);
        setting = findViewById(R.id.setting);

        setting.setVisibility(View.GONE);

        navigationButton[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout, new fragHome());
                ft.commit();

                navigationButton[indexNav].setTextColor((Color.parseColor("#000000")));
                navigationButton[indexNav].setBackgroundColor((Color.parseColor("#FFFFFF")));

                setting.setVisibility(View.GONE);

                indexNav = 0;

                navigationButton[indexNav].setTextColor((Color.parseColor("#ffffff")));
                navigationButton[indexNav].setBackgroundColor((Color.parseColor("#7B5CFF")));
            }
        });

        navigationButton[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout, new fragPublic());
                ft.commit();

                navigationButton[indexNav].setTextColor((Color.parseColor("#000000")));
                navigationButton[indexNav].setBackgroundColor((Color.parseColor("#FFFFFF")));

                setting.setVisibility(View.GONE);
                indexNav = 1;

                navigationButton[indexNav].setTextColor((Color.parseColor("#ffffff")));
                navigationButton[indexNav].setBackgroundColor((Color.parseColor("#7B5CFF")));
            }
        });

        navigationButton[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout, new fragHeal());
                ft.commit();

                navigationButton[indexNav].setTextColor((Color.parseColor("#000000")));
                navigationButton[indexNav].setBackgroundColor((Color.parseColor("#FFFFFF")));

                setting.setVisibility(View.GONE);
                indexNav = 2;

                navigationButton[indexNav].setTextColor((Color.parseColor("#ffffff")));
                navigationButton[indexNav].setBackgroundColor((Color.parseColor("#7B5CFF")));
            }
        });

        navigationButton[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout, new fragProfile());
                ft.commit();

                navigationButton[indexNav].setTextColor((Color.parseColor("#000000")));
                navigationButton[indexNav].setBackgroundColor((Color.parseColor("#FFFFFF")));

                setting.setVisibility(View.VISIBLE);
                indexNav = 3;

                navigationButton[indexNav].setTextColor((Color.parseColor("#ffffff")));
                navigationButton[indexNav].setBackgroundColor((Color.parseColor("#7B5CFF")));
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(actHome.this, actEditProfile.class);
            startActivity(intent);
            }
        });


        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, new fragHome());
        ft.commit();
    }
}
