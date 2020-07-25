package com.example.galaw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jgabrielfreitas.core.BlurImageView;

public class actDepresiHeal1 extends AppCompatActivity {

    Button callKlinikD, backTestD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_depresi_heal1);

        callKlinikD = findViewById(R.id.callKlinikD);
        backTestD = findViewById(R.id.backTestD);

        callKlinikD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData((Uri.parse("tel: 0214223138")));
                startActivity(intent);
            }
        });

        backTestD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(actDepresiHeal1.this, actDepression.class);
                startActivity(intent);
            }
        });
    }
}
