package com.example.galaw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import javax.annotation.Nullable;

public class actAllTest extends AppCompatActivity {

    Button level1, level2, level3, lock1, lock2;
    int editklik;
    FirebaseFirestore fStore;
    FirebaseAuth fAuth;
    String userID;
    Task<QuerySnapshot> check;
    Task<QuerySnapshot> check2;
    Task<QuerySnapshot> check3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_all_test);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        fStore = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();
        userID = fAuth.getCurrentUser().getUid();

        int levelquiz = getIntent().getIntExtra("quiz",-1);
        level1 = (Button) findViewById(R.id.level1);
        level2 = (Button) findViewById(R.id.level2);
        level3 = (Button) findViewById(R.id.level3);
        lock1 = (Button) findViewById(R.id.lock1);
        lock2 = (Button) findViewById(R.id.lock2);

        DocumentReference documentReference = fStore.collection("Quiz").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if (documentSnapshot.getString("StressScore") == null) {
                    level1.setVisibility(View.VISIBLE);
                    level2.setVisibility(View.INVISIBLE);
                    level3.setVisibility(View.INVISIBLE);

                } else if (documentSnapshot.getString("AnxietyScore") == null) {
                    level1.setVisibility(View.VISIBLE);
                    level2.setVisibility(View.VISIBLE);
                    level3.setVisibility(View.INVISIBLE);

                } else if (documentSnapshot.getString("DepressionScore") == null) {
                    level1.setVisibility(View.VISIBLE);
                    level2.setVisibility(View.VISIBLE);
                    level3.setVisibility(View.VISIBLE);

                } else if (documentSnapshot.getString("DepressionScore") != null) {
                    level1.setVisibility(View.VISIBLE);
                    level2.setVisibility(View.VISIBLE);
                    level3.setVisibility(View.VISIBLE);
                }
            }
        });


        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(actAllTest.this, actStress.class);
                intent.putExtra("quiz",1);
                startActivity(intent);

                //level1.setVisibility(View.VISIBLE);
                //level2.setVisibility(View.INVISIBLE);
                //level3.setVisibility(View.INVISIBLE);
                //lock1.setVisibility(View.VISIBLE);
                //lock2.setVisibility(View.VISIBLE);

            }
        });

        level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(actAllTest.this, actAnxiety.class);
                intent.putExtra("quiz",2);
                startActivity(intent);

                //level1.setVisibility(View.VISIBLE);
                //level2.setVisibility(View.VISIBLE);
                //level3.setVisibility(View.VISIBLE);
                //lock1.setVisibility(View.INVISIBLE);
                //lock2.setVisibility(View.INVISIBLE);

            }
        });

        level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(actAllTest.this, actDepression.class);
                intent.putExtra("quiz",3);
                startActivity(intent);

                //level1.setVisibility(View.VISIBLE);
                //level2.setVisibility(View.VISIBLE);
                //level3.setVisibility(View.VISIBLE);
                //lock1.setVisibility(View.INVISIBLE);
                //lock2.setVisibility(View.INVISIBLE);

            }
        });

        lock1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(actAllTest.this, "Selesaikan level 1 dulu ya", Toast.LENGTH_LONG).show();
            }
        });

        lock2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(actAllTest.this, "Selesaikan level 2 dulu ya", Toast.LENGTH_LONG).show();
            }
        });

    }

}