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
        if (mSemangatNumber >= 31){
            Intent intent =new Intent(actStressHeal1.this , actStressHeal2.class);
            startActivity(intent);
        }

        //if()

    }

    public void onBackPressed(){
       Intent intent = new Intent(actStressHeal1.this, actHome.class);
       startActivity(intent);
    }

    StressText S01 = new StressText(R.drawable.b1, "Selamat datang di Ruang Sandar.  Tempat yang terbebas dari hiruk pikuk dunia" );
    StressText S02 = new StressText(R.drawable.b2, "Bebas dari notifikasi gawaimu, pekerjaanmu serta dunia yang terus bergerak maju");
    StressText S03 = new StressText(R.drawable.b3,"Disini, kamu dapat bersandar sejenak");
    StressText S04 = new StressText(R.drawable.b4,"Sebentar saja");
    StressText S05 = new StressText(R.drawable.b5,"Ini, tidak akan membuatmu tertinggal dari dunia");
    StressText S06 = new StressText(R.drawable.b6,"Hanya untuk sebentar, bersandar di sini");
    StressText S07 = new StressText(R.drawable.b7,"Aku merasakan kecemasan yang kamu alami");
    StressText S08 = new StressText(R.drawable.b8,"Tugas demi tugas yang datang silih berganti");
    StressText S09 = new StressText(R.drawable.b9,"Teman yang membuatmu gelisah");
    StressText S10 = new StressText(R.drawable.b10,"Perkatakaan yang tidak mengenakan dihati");
    StressText S11 = new StressText(R.drawable.b11,"Dijauhi orang tersayang");
    StressText S12 = new StressText(R.drawable.b12,"Tuntutan yang diberikan orang tuamu yang terlalu berat bagimu");
    StressText S13 = new StressText(R.drawable.b13,"Kamu telah melakukan yang terbaik untuk melakukan itu semua");
    StressText S14 = new StressText(R.drawable.b14,"Kemauan dunia, yang dapat membuat hari menjadi sendu");
    StressText S15 = new StressText(R.drawable.b15,"Kamu patut mengapresiasi dan berbangga hati");
    StressText S16 = new StressText(R.drawable.b1,"Kenapa? Kamu sudah melakukan yang terbaik hingga detik ini");
    StressText S17 = new StressText(R.drawable.b2,"Terlalu besar usahamu hingga lupa dirimu perlu istirahat");
    StressText S18 = new StressText(R.drawable.b3,"Tenanglah, tidak apa");
    StressText S19 = new StressText(R.drawable.b4,"Sekarang kamu disini, sekarang kamu bisa istirahatkan diri");
    StressText S20 = new StressText(R.drawable.b5,"Pikirin dirimu dan semua tentangmu");
    StressText S21 = new StressText(R.drawable.b6,"Untuk satu menit kedepan, rasakan setiap hembus nafasmu, debar jantungmu, suara hatimu, apapun tentangmu");
    StressText S22 = new StressText(R.drawable.b7,"Bagaimana, sudah merasa lebih tenang kan?");
    StressText S23 = new StressText(R.drawable.b8, "Waktu ku disini sudah hampir habis");
    StressText S24 = new StressText(R.drawable.b9,"Dunia terus bergerak maju dan kita harus kembali");
    StressText S25 = new StressText(R.drawable.b10,"Sepertinya aku juga harus balik ke duniaku sendiri");
    StressText S26 = new StressText(R.drawable.b11,"Tapi ini bukan terakhir kali kita akan bertemu");
    StressText S27 = new StressText(R.drawable.b12,"Jika kamu merasa dunia kembali tidak terkendali dan membuatmu tertekan, tolong kembali kesini");
    StressText S28 = new StressText(R.drawable.b13, "Aku selalu disini jika kalau kamu butuh. aku ingin memberi saran. Coba untuk mencari tahu keadaanmu, apa yang dapat menimbulkannya, dan lain-lain");
    StressText S29 = new StressText(R.drawable.b14,"Nanti kalau butuh aku lagi, tolong kesini ya");
    StressText S30 = new StressText(R.drawable.b15,"Baik aku pamit dulu. terima kasih sudah ada di ruang ini");
    StressText S31 = new StressText(R.drawable.b1,"Senang bisa bertemu, sampai jumpa!");

    StressText [] StressTextArray = new StressText[]{
      S01,S02,S03,S04,S05,S06,S07,S08,S09,S10,S11,S12,S13,S14,S15,S16,S17,S18,S19,S20,S21,S22,S23,S24,S25,S26,S27,S28,S29,S30,S31

    };

}
