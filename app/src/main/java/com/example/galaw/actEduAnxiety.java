package com.example.galaw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class actEduAnxiety extends AppCompatActivity {


    ViewPager viewPager;
    Adapter adapterr;
    List<Model> models;
    Integer [] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    Button nextHealCemas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_edu_anxiety);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        nextHealCemas = findViewById(R.id.nextHealCemas);

        nextHealCemas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(actEduAnxiety.this, actAnxietyHeal.class);
                startActivity(intent);
            }
        });


        models = new ArrayList<>();
        models.add(new Model("Kecemasan umum", "Khawatir dengan segala hal"));
        models.add(new Model("Kecemasan bersosial", "Saya berharap merasa nyaman berbicara di depan umum."));
        models.add(new Model("Panik", "Saya tidak tahu mengapa kepanikan itu terjadi, tetapi saya khawatir saya akan mengalami serangan jantung, kehilangan kendali, atau mati"));
        models.add(new Model("OCD", "Saya memikirkan hal yang menjengkelkan dan merasa perlu melakukan hal-hal tertentu sehingga tidak ada hal buruk yang terjadi."));
        models.add(new Model("PTSD", "Saya benar-benar marah dan kesal setiap kali saya memikirkan apa yang terjadi pada saya."));

        adapterr = new Adapter(models, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapterr);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {getResources().getColor(R.color.color1), getResources().getColor(R.color.color2), getResources().getColor(R.color.color3), getResources().getColor(R.color.color4), getResources().getColor(R.color.color5)};

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (adapterr.getCount() -1) && position < (colors.length - 1 )){
                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset, colors[position], colors[position + 1]));
                }
                else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(actEduAnxiety.this, actHome.class);
        startActivity(intent);
    }
}