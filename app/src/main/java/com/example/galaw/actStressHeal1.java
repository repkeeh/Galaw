package com.example.galaw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class actStressHeal1 extends AppCompatActivity {

    private TextView mSemangat;
    private Button mNextSmengat;
    private int mSemangatNumber = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_stress_heal1);

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
        mSemangat.setText(StressTextArray[mSemangatNumber].getmSemangat());
        mSemangatNumber++;

        if (mSemangatNumber >= 31){
            Intent intent =new Intent(actStressHeal1.this , actStressHeal2.class);
            startActivity(intent);
        }

    }

    StressText S01 = new StressText("Selamat datang di Ruang Sandar, tempat yang bebas dari hiruk pikuk dan sibukmu setiap hari" );
    StressText S02 = new StressText("Bebas dari notifikasi gawaimu, tugas-tugasmu, serta dunia yang terus bergerak maju dan menuntutmu ini-itu");
    StressText S03 = new StressText("Di sini, di tempat ini, kamu dapat bersandar");
    StressText S04 = new StressText("Sebentar saja");
    StressText S05 = new StressText("Ini, tidak akan membuatmu tertinggal dari dunia");
    StressText S06 = new StressText("Hanya untuk sebentar, bersandarlah di sini");
    StressText S07 = new StressText("Semua yang kamu cemaskan, aku ikut merasakan kok");
    StressText S08 = new StressText("Mungkin, ada tugas banyak");
    StressText S09 = new StressText("Teman yang kata-katain kamu");
    StressText S10 = new StressText("Bilang sesuatu yang kurang enak");
    StressText S11 = new StressText("Dijauhi orang yang kita sayang");
    StressText S12 = new StressText("Atau ekspektasi dari orang tuamu atau orang-orang lain yang mulai terasa terlalu berat bagimu");
    StressText S13 = new StressText("Kamu telah mencoba sebisamu untuk mengikuti kemauan yang ada di sekitarmu");
    StressText S14 = new StressText("Kemauan dunia, yang dapat membuat hari menjadi sendu");
    StressText S15 = new StressText("Kamu patut diapresiasi dan bangga hati");
    StressText S16 = new StressText("Kenapa? Kamu kan udah berusaha sebisamu, kan?");
    StressText S17 = new StressText("Saking gede usahamu, kamu sepertinya lupa untuk istirahat ya?");
    StressText S18 = new StressText("Yaudah, gapapa");
    StressText S19 = new StressText("Sekarang kamu disini, sekarang kamu bisa istirahatkan diri");
    StressText S20 = new StressText("Pikirin dirimu dan semua tentangmu");
    StressText S21 = new StressText("Untuk satu menit kedepan, rasakan setiap hembus nafasmu, debar jantungmu, suara hatimu, apapun tentangmu");
    StressText S22 = new StressText("Bagaimana, sudah merasa lebih tenang kan?");
    StressText S23 = new StressText( "Oh ya, kayanya waktu kita udah selesai");
    StressText S24 = new StressText("Dunia terus bergerak maju dan kita harus kembali");
    StressText S25 = new StressText("Sepertinya aku juga yang harus balik ke duniaku sendiri");
    StressText S26 = new StressText("Tapi ini bukan terakhir kali kita bakalan bertemu");
    StressText S27 = new StressText("Jika kamu merasa dunia kembali tak terkendali dan membuatmu tertekan, balik aja kesini ya");
    StressText S28 = new StressText( "Saya selalu disini kok kalau kamu butuh. baik kalau boleh aku kasih saran coba untuk mencari tahu keadaanmu, apa yang dapat menimbulkannya, dan lain-lain");
    StressText S29 = new StressText("oke, Nanti kalau butuh aku lagi, balik lagi aja ya");
    StressText S30 = new StressText("Sip, yaudah aku pamit dulu ya makasih ya sudah ada di ruang ini");
    StressText S31 = new StressText("Senang bisa bertemu-mu ya, sampai jumpa!");

    StressText [] StressTextArray = new StressText[]{
      S01,S02,S03,S04,S05,S06,S07,S08,S09,S10,S11,S12,S13,S14,S15,S16,S17,S18,S19,S20,S21,S22,S23,S24,S25,S26,S27,S28,S29,S30,S31

    };

}
