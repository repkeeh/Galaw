package com.example.galaw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class actAsk extends AppCompatActivity {

    EditText askJudul, askIsi;
    Button saveAsk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_ask);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        TextView textViewDate = findViewById(R.id.tanggal);
        textViewDate.setText(currentDate);


        askJudul = findViewById(R.id.askJudul);
        askIsi = findViewById(R.id.askIsi);
        saveAsk = findViewById(R.id.saveAsk);



    }
}