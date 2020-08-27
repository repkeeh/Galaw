package com.example.galaw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class klinikYarsi extends AppCompatActivity {

    Button noKlinikYarsi, chatKlinik;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klinik_yarsi);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        noKlinikYarsi = findViewById(R.id.noKlinikYarsi);
        chatKlinik = findViewById(R.id.chatKlinik);
        noKlinikYarsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData((Uri.parse("tel: 0214223138")));
                startActivity(intent);
            }
        });

        chatKlinik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(klinikYarsi.this, actAsk.class);
                startActivity(intent);
            }
        });
    }
}