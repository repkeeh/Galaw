package com.example.galaw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class actAsk extends AppCompatActivity {

    EditText askJudul, askIsi;
    Button saveAsk;
    TextView mailTo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_ask);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);



        mailTo = findViewById(R.id.mailTo);
        askJudul = findViewById(R.id.askJudul);
        askIsi = findViewById(R.id.askIsi);
        saveAsk = findViewById(R.id.saveAsk);


        saveAsk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] TO_EMAILS = {"(galawproject@gmail.com"};

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                String judul = askJudul.getText().toString();
                String isi = askIsi.getText().toString();

                intent.putExtra(Intent.EXTRA_EMAIL, TO_EMAILS);
                intent.putExtra(Intent.EXTRA_SUBJECT, judul);
                intent.putExtra(Intent.EXTRA_TEXT, isi);

                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent, "Choose one aplication"));
            }
        });


    }
}