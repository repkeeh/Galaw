package com.example.galaw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class actResultDepresi extends AppCompatActivity {

    int type_Question;
    int number_Question;
    TextView Total;
    FirebaseFirestore fStore;
    FirebaseAuth fAuth;
    String userID;

    Integer result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_result);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        Total = findViewById(R.id.total);

        type_Question = getIntent().getIntExtra("total",-1);
        number_Question = 0;
        Total.setText("" + type_Question);

        final String totalQuiz = Total.getText().toString();

        userID = fAuth.getCurrentUser().getUid();
        final DocumentReference documentReference = fStore.collection("Quiz").document(userID);
        Map<String, Object> user = new HashMap<>();
        user.put("Depresi Score", totalQuiz);
        documentReference.update(user).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(actResultDepresi.this, "Score has been Updated", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(actResultDepresi.this, "Update Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
