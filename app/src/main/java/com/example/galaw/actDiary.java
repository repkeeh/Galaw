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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class actDiary extends AppCompatActivity {

    EditText diaryJudul, diaryIsi;
    Button savediary;
    FirebaseFirestore fStore;
    FirebaseAuth fAuth;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_diary);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        TextView textViewDate = findViewById(R.id.tanggal);
        textViewDate.setText(currentDate);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        diaryJudul = findViewById(R.id.diaryJudul);
        diaryIsi = findViewById(R.id.diaryIsi);

        savediary = findViewById(R.id.savediary);

        savediary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String diaryjudul = diaryJudul.getText().toString();
                final String diaryisi = diaryIsi.getText().toString();

                userID = fAuth.getCurrentUser().getUid();

                final DocumentReference documentReference = fStore.collection("Diary").document(userID);
                Map<String, Object> user = new HashMap<>();
                user.put("Judul", diaryjudul);
                user.put("Isi", diaryisi);
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
