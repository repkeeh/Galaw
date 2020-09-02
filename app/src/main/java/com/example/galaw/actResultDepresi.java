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

public class actResultDepresi extends AppCompatActivity {

    int type_Question;
    int number_Question;
    TextView Total;
    Button simpanData;
    FirebaseFirestore fStore;
    FirebaseAuth fAuth;
    String userID;


    Integer result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_result_depresi);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        Total = findViewById(R.id.total);
        simpanData = findViewById(R.id.simpanData);

        type_Question = getIntent().getIntExtra("total",-1);
        number_Question = 0;
        Total.setText(setTingkatDepresiOrang(type_Question));

        simpanData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String totalQuiz = Total.getText().toString();


                userID = fAuth.getCurrentUser().getUid();
                final DocumentReference documentReference = fStore.collection("Quiz").document(userID);
                Map<String, Object> user = new HashMap<>();
                user.put("DepressionScore", totalQuiz);
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
                if(totalQuiz == "SELAMAT. KAMU BAIK BAIK SAJA"){
                    Intent intent = new Intent( actResultDepresi.this, actHome.class );
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent( actResultDepresi.this, actDepresiHeal1.class );
                    startActivity(intent);
                }
            }
        });



    }

    private String setTingkatDepresiOrang(int type_question) {
        String tingkatstress = "";
        if(type_question >= 0 && type_question <= 9){
            tingkatstress = "SELAMAT. KAMU BAIK BAIK SAJA";//normal
        }
        else if(type_question >= 10 && type_question <= 13){
            tingkatstress = "APAKAH KAMU MERASA SULIT MENGHADAPI MASALAH SEHARI HARI ?";//ringan
        }
        else if(type_question >= 14 && type_question <= 20){
            tingkatstress = "KAMU INGIN MENYENDIRI JAUH DARI SEGALA MASALAH "; // sedang
        }
        else if(type_question >= 21 && type_question <= 27){
            tingkatstress = "KAMU MERASA SANGAT TIDAK BERDAYA. SEGERA HUBUNGI BANTUAN PROFESIONAL DI KLINIK PSIKOLOGI YARSI";//berat
        }
        else if(type_question >= 28){
            tingkatstress = "KAMU MERASA SANGAT TIDAK BERDAYA. SEGERA HUBUNGI BANTUAN PROFESIONAL DI KLINIK PSIKOLOGI YARSI"; // sangat berat
        }
        return tingkatstress;
    }

}