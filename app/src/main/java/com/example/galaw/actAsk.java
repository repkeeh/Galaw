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
    Button saveAsk;
    TextView mailTo;
    FirebaseFirestore fStore;
    FirebaseAuth fAuth;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_ask);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss a");
        String date = df.format(Calendar.getInstance().getTime());

        final TextView textViewDate = findViewById(R.id.tanggal);
        textViewDate.setText(date);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();



        mailTo = findViewById(R.id.mailTo);
        askJudul = findViewById(R.id.askJudul);
        askIsi = findViewById(R.id.askIsi);
        saveAsk = findViewById(R.id.saveAsk);

        saveAsk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String askjudul = askJudul.getText().toString();
                final String askisi = askIsi.getText().toString();
                final String tanggal = textViewDate.getText().toString();

                userID = fAuth.getCurrentUser().getUid();

                final DocumentReference documentReference = fStore.collection("Ask").document(userID);
                Map<String, Object> user = new HashMap<>();
                user.put("Pertanyaan", FieldValue.arrayUnion(askjudul));
                user.put("Penjelasan", FieldValue.arrayUnion(askisi));
                user.put("Tanggal", FieldValue.arrayUnion(tanggal));
                documentReference.update(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(actAsk.this, "Ask question has been Updated", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(actAsk.this, "Update Failed", Toast.LENGTH_SHORT).show();
                    }
                });

                Intent intent = new Intent(actAsk.this, actHome.class);
                startActivity(intent);
            }
        });


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