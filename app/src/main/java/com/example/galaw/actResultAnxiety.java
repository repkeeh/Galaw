package com.example.galaw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class actResultAnxiety extends AppCompatActivity {
    int type_Question;
    int number_Question;
    TextView Total;
    Button simpanData;
    FirebaseFirestore fStore;
    FirebaseAuth fAuth;
    String userID;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_result_anxiety);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        Total = findViewById(R.id.total);
        simpanData = findViewById(R.id.simpanData);

        type_Question = getIntent().getIntExtra("total",-1);
        number_Question = 0;

        Total.setText(setTingkatAnxietyOrang(type_Question));

        simpanData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String totalQuiz = Total.getText().toString();


                userID = fAuth.getCurrentUser().getUid();
                final DocumentReference documentReference = fStore.collection("Quiz").document(userID);
                Map<String, Object> user = new HashMap<>();
                user.put("AnxietyScore", totalQuiz);
                documentReference.update(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(actResultAnxiety.this, "Score has been Updated", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(actResultAnxiety.this, "Update Failed", Toast.LENGTH_SHORT).show();
                    }
                });

                if(totalQuiz == "KAMU BAIK BAIK SAJA"){
                    Intent intent = new Intent( actResultAnxiety.this, actHome.class );
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent( actResultAnxiety.this, actEduAnxiety.class );
                    startActivity(intent);
                }

            }

        });


    }

    private String setTingkatAnxietyOrang(int type_question) {
        String tingkatstress = "";
        if(type_question >= 0 && type_question <= 7){
            tingkatstress = "KAMU BAIK BAIK SAJA"; // NORMAL
        }
        else if(type_question >= 8 && type_question <= 9){
            tingkatstress = "ADA HAL YANG MEMBUATMU CEMAS TAPI KAMU CUKUP DAPAT MENGATASINYA"; // RINGAN
        }
        else if(type_question >= 10 && type_question <= 14){
            tingkatstress = "KAMU TAMPAKNYA MENGALAMI KECEMASAN"; // SEDANG
        }
        else if(type_question >= 15 && type_question <= 19){
            tingkatstress = "TAMPAKNYA BANYAK HAL YANG KAMU CEMASKAN SAAT INI DAN KAMU MERASA SULIT UNTUK MENGHADAPINYA"; // BERAT
        }
        else if(type_question >= 20){
            tingkatstress = "SEPERTINYA KAMU SEDANG ADA MASALAH, BACA DULU YUK TENTANG KESEHATAN MENTAL"; // SANGAT BERAT
        }
        return tingkatstress;
    }


}