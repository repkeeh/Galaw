package com.example.galaw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class actDiary extends AppCompatActivity {

    EditText diaryJudul, diaryIsi;
    Button savediary;
    FirebaseFirestore fStore;
    FirebaseAuth fAuth;
    FirebaseUser user;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_diary);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss a");
        String date = df.format(Calendar.getInstance().getTime());

        final TextView textViewDate = findViewById(R.id.tanggal);
        textViewDate.setText(date);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        diaryJudul = findViewById(R.id.diaryJudul);
        diaryIsi = findViewById(R.id.diaryIsi);

        savediary = findViewById(R.id.savediary);

        user = FirebaseAuth.getInstance().getCurrentUser();

        savediary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String diaryjudul = diaryJudul.getText().toString();
                final String diaryisi = diaryIsi.getText().toString();
                final String tanggal = textViewDate.getText().toString();

                userID = fAuth.getCurrentUser().getUid();

                final DocumentReference documentReference = fStore.collection("Diary").document(user.getUid()).collection("myNotes").document();
                Map<String, Object> user = new HashMap<>();
                user.put("title", diaryjudul);
                user.put("content", diaryisi);
                user.put("Tanggal", tanggal);
                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(actDiary.this, "Diary has been Updated", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(actDiary.this, "Update Failed", Toast.LENGTH_SHORT).show();
                    }
                });

                Intent intent = new Intent(actDiary.this, actHome.class);
                startActivity(intent);
            }
        });
    }
}
