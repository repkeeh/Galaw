package com.example.galaw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class actAsk extends AppCompatActivity {

    EditText askJudul, askIsi;
    TextView mailTo;
    Button saveAsk;

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
                final String mailto = mailTo.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra(Intent.EXTRA_SUBJECT,askJudul.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT,askIsi.getText().toString());
                intent.setData(Uri.parse("mailto:" + mailto));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
}