package com.example.galaw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class actEduAnxiety extends AppCompatActivity {

    Spinner spinner1, spinner2, spinner3;

    ViewPager viewPager;
    Adapter adapterr;
    List<Model> models;
    Integer [] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_edu_anxiety);

        Spinner spinner1  = findViewById(R.id.pikiran);
        Spinner spinner2  = findViewById(R.id.fisik);
        Spinner spinner3  = findViewById(R.id.perilaku);

        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.pikiran, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.fisik, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.perilaku, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);


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

        Integer[] colors_temp = {getResources().getColor(R.color.color1), getResources().getColor(R.color.color2), getResources().getColor(R.color.color3), getResources().getColor(R.color.color4)};

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
}