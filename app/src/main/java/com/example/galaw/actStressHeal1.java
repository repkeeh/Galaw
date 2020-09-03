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

public class actStressHeal1 extends AppCompatActivity {

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
        if (mSemangatNumber >= 21){
            Intent intent =new Intent(actStressHeal1.this , actStressHeal2.class);
            startActivity(intent);
        }

        //if()

    }

    public void onBackPressed(){
       Intent intent = new Intent(actStressHeal1.this, actHome.class);
       startActivity(intent);
    }

    StressText S01 = new StressText(R.drawable.b1, "Selamat datang di Ruang Sandar.  Tempat yang hening. Bebas dari hiruk pikuk dunia." );
    StressText S02 = new StressText(R.drawable.b2, "Bebas dari notifikasi gawaimu, tugas-tugas serta dari dunia yang bergegas dan bising.");
    StressText S03 = new StressText(R.drawable.b3,"Disini, kamu dapat bersandar sejenak.");
    StressText S04 = new StressText(R.drawable.b4,"Sebentar saja..");
    StressText S05 = new StressText(R.drawable.b5,"Bersandar di sini tidak akan membuatmu tertinggal dari ketergesaan dunia.");
    StressText S06 = new StressText(R.drawable.b6,"Bersandar saja sebentar di sini.");
    StressText S07 = new StressText(R.drawable.b7,"Aku merasakan kecemasan yang kamu alami");
    StressText S08 = new StressText(R.drawable.b8,"Tugas demi tugas yang tak kunjung berhenti.");
    StressText S09 = new StressText(R.drawable.b9,"Teman yang membuatmu gelisah.");
    StressText S10 = new StressText(R.drawable.b10,"Ucapan-ucapan yang menyakitkan hati.");
    StressText S11 = new StressText(R.drawable.b11,"Dijauhi orang tersayang.");
    StressText S12 = new StressText(R.drawable.b12,"Tuntutan orang tuamu yang terasa terlampau berat.");
    StressText S13 = new StressText(R.drawable.b13,"Kamu telah melakukan yang terbaik.");
    StressText S14 = new StressText(R.drawable.b14,"Kehendak dunia yang dapat membuat hari menjadi sendu.");
    StressText S15 = new StressText(R.drawable.b15,"Kamu patut menghargai diri dan berbangga hati.");
    StressText S16 = new StressText(R.drawable.b16,"Kamu sudah melakukan yang terbaik hingga detik ini.");
    StressText S17 = new StressText(R.drawable.b17,"Terlalu besar usahamu hingga lupa dirimu perlu istirahat.");
    StressText S18 = new StressText(R.drawable.b18,"Tenanglah, tidak mengapa..");
    StressText S19 = new StressText(R.drawable.b19,"Sekarang kamu disini, sekarang kamu bisa istirahatkan diri.");
    StressText S20 = new StressText(R.drawable.b20,"Pikirkan dirimu dan semua tentangmu.");
    StressText S21 = new StressText(R.drawable.b21,"Selanjutnya kami akan membantumu lebih rileks.");


    StressText [] StressTextArray = new StressText[]{
      S01,S02,S03,S04,S05,S06,S07,S08,S09,S10,S11,S12,S13,S14,S15,S16,S17,S18,S19,S20,S21

    };

}
