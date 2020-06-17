package com.example.galaw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class actStressHeal1 extends AppCompatActivity {

    private ImageView bgquotes;
    private TextView mSemangat;
    private Button mNextSmengat;
    private int mSemangatNumber = 0;
    private ProgressBar proBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_stress_heal1);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        bgquotes =  (ImageView)findViewById(R.id.bgquotes);
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

    public void rndmText(){
        bgquotes.setImageResource(StressTextArray[mSemangatNumber].getmImage());
        mSemangat.setText(StressTextArray[mSemangatNumber].getmSemangat());
        mSemangatNumber++;

        if (mSemangatNumber >= 31){
            Intent intent =new Intent(actStressHeal1.this , actStressHeal2.class);
            startActivity(intent);
        }

    }

    StressText S01 = new StressText(R.drawable.b1, "Selamat datang di Ruang Sandar, tempat yang bebas dari hiruk pikuk dan sibukmu setiap hari" );
    StressText S02 = new StressText(R.drawable.b2, "Bebas dari notifikasi gawaimu, tugas-tugasmu, serta dunia yang terus bergerak maju dan menuntutmu ini-itu");
    StressText S03 = new StressText(R.drawable.b3,"Di sini, di tempat ini, kamu dapat bersandar");
    StressText S04 = new StressText(R.drawable.b4,"Sebentar saja");
    StressText S05 = new StressText(R.drawable.b5,"Ini, tidak akan membuatmu tertinggal dari dunia");
    StressText S06 = new StressText(R.drawable.b6,"Hanya untuk sebentar, bersandarlah di sini");
    StressText S07 = new StressText(R.drawable.b7,"Semua yang kamu cemaskan, aku ikut merasakan kok");
    StressText S08 = new StressText(R.drawable.b1,"Mungkin, ada tugas banyak");
    StressText S09 = new StressText(R.drawable.b2,"Teman yang kata-katain kamu");
    StressText S10 = new StressText(R.drawable.b3,"Bilang sesuatu yang kurang enak");
    StressText S11 = new StressText(R.drawable.b4,"Dijauhi orang yang kita sayang");
    StressText S12 = new StressText(R.drawable.b5,"Atau ekspektasi dari orang tuamu atau orang-orang lain yang mulai terasa terlalu berat bagimu");
    StressText S13 = new StressText(R.drawable.b6,"Kamu telah mencoba sebisamu untuk mengikuti kemauan yang ada di sekitarmu");
    StressText S14 = new StressText(R.drawable.b7,"Kemauan dunia, yang dapat membuat hari menjadi sendu");
    StressText S15 = new StressText(R.drawable.b1,"Kamu patut diapresiasi dan bangga hati");
    StressText S16 = new StressText(R.drawable.b2,"Kenapa? Kamu kan udah berusaha sebisamu, kan?");
    StressText S17 = new StressText(R.drawable.b3,"Saking gede usahamu, kamu sepertinya lupa untuk istirahat ya?");
    StressText S18 = new StressText(R.drawable.b4,"Yaudah, gapapa");
    StressText S19 = new StressText(R.drawable.b5,"Sekarang kamu disini, sekarang kamu bisa istirahatkan diri");
    StressText S20 = new StressText(R.drawable.b6,"Pikirin dirimu dan semua tentangmu");
    StressText S21 = new StressText(R.drawable.b7,"Untuk satu menit kedepan, rasakan setiap hembus nafasmu, debar jantungmu, suara hatimu, apapun tentangmu");
    StressText S22 = new StressText(R.drawable.b1,"Bagaimana, sudah merasa lebih tenang kan?");
    StressText S23 = new StressText(R.drawable.b2, "Oh ya, kayanya waktu kita udah selesai");
    StressText S24 = new StressText(R.drawable.b3,"Dunia terus bergerak maju dan kita harus kembali");
    StressText S25 = new StressText(R.drawable.b4,"Sepertinya aku juga yang harus balik ke duniaku sendiri");
    StressText S26 = new StressText(R.drawable.b5,"Tapi ini bukan terakhir kali kita bakalan bertemu");
    StressText S27 = new StressText(R.drawable.b6,"Jika kamu merasa dunia kembali tak terkendali dan membuatmu tertekan, balik aja kesini ya");
    StressText S28 = new StressText(R.drawable.b7, "Saya selalu disini kok kalau kamu butuh. baik kalau boleh aku kasih saran coba untuk mencari tahu keadaanmu, apa yang dapat menimbulkannya, dan lain-lain");
    StressText S29 = new StressText(R.drawable.b1,"oke, Nanti kalau butuh aku lagi, balik lagi aja ya");
    StressText S30 = new StressText(R.drawable.b2,"Sip, yaudah aku pamit dulu ya makasih ya sudah ada di ruang ini");
    StressText S31 = new StressText(R.drawable.b3,"Senang bisa bertemu-mu ya, sampai jumpa!");

    StressText [] StressTextArray = new StressText[]{
      S01,S02,S03,S04,S05,S06,S07,S08,S09,S10,S11,S12,S13,S14,S15,S16,S17,S18,S19,S20,S21,S22,S23,S24,S25,S26,S27,S28,S29,S30,S31

    };

}
