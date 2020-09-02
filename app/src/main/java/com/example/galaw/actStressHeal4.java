package com.example.galaw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class actStressHeal4 extends AppCompatActivity {

    private RelativeLayout bgquotes;
    private TextView mSemangat;
    private Button mNextSmengat;
    private int mSemangatNumber = 0;
    private ProgressBar proBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_stress_heal1);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        bgquotes =  (RelativeLayout)findViewById(R.id.bgquotes);
        mSemangat = (TextView)findViewById(R.id.semangat);
        mNextSmengat = (Button)findViewById(R.id.nextSemangat);


        rndmText();

        mNextSmengat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rndmText();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        mSemangatNumber = 0;
    }

    public void rndmText(){
        bgquotes.setBackground( getResources().getDrawable(StressTextArray[mSemangatNumber].getmImage()));
        mSemangat.setText(StressTextArray[mSemangatNumber].getmSemangat());
        mSemangatNumber++;
        //System.out.println(mSemangatNumber);
        if (mSemangatNumber >= 2){
            Intent intent =new Intent(actStressHeal4.this , actHome.class);
            startActivity(intent);
        }

        //if()

    }

    public void onBackPressed(){
        Intent intent = new Intent(actStressHeal4.this, actHome.class);
        startActivity(intent);
    }

    StressText S01 = new StressText(R.drawable.b22, "Terima kasih sudah ada di Ruang Sandar." );
    StressText S02 = new StressText(R.drawable.b23, "Senang bisa bertemu denganmu, sampai jumpa!");



    StressText [] StressTextArray = new StressText[]{
            S01,S02

    };

}
