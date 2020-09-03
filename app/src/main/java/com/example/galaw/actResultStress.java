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

public class actResultStress extends AppCompatActivity {

    int type_Question;
    int number_Question;
    TextView Total, tesHasil;
    Button simpanData;
    FirebaseFirestore fStore;
    FirebaseAuth fAuth;
    String userID;


    Integer result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_result_stress);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        Total = findViewById(R.id.total);
        simpanData = findViewById(R.id.simpanData);
        tesHasil = findViewById(R.id.tesHasil);

        type_Question = getIntent().getIntExtra("total",-1);
        number_Question = 0;
        Total.setText(setTingkatStressOrang(type_Question));

        String hasilTes = Total.getText().toString();

        if (hasilTes == "TAMPAKNYA KAMU BAIK BAIK SAJA"){
            tesHasil.setText("Kamu mampu mengatasi stress. Kembali ke beranda. ");
        } else {
            tesHasil.setText("Mari lanjutkan ke Ruang Sandar. ");
        }

        simpanData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String totalQuiz = Total.getText().toString();


                userID = fAuth.getCurrentUser().getUid();
                final DocumentReference documentReference = fStore.collection("Quiz").document(userID);
                Map<String, Object> user = new HashMap<>();
                user.put("StressScore", totalQuiz);
                documentReference.update(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(actResultStress.this, "Score has been Updated", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(actResultStress.this, "Update Failed", Toast.LENGTH_SHORT).show();
                    }
                });

                if(totalQuiz == "TAMPAKNYA KAMU BAIK BAIK SAJA"){
                Intent intent = new Intent( actResultStress.this, actHome.class );
                startActivity(intent);
                }
                else {
                    Intent intent = new Intent( actResultStress.this, actStressHeal1.class );
                    startActivity(intent);
                }
            }
        });



    }

    private String setTingkatStressOrang(int type_question) {
        String tingkatstress = "";
        if(type_question >= 0 && type_question <= 14){
            tingkatstress = "TAMPAKNYA KAMU BAIK BAIK SAJA";
        }
        else if(type_question >= 15 && type_question <= 18){
            tingkatstress = "ADAKAH YANG SEDANG MEMBUAT KAMU RESAH PADA SAAT INI?";
        }
        else if(type_question >= 19 && type_question <= 25){
            tingkatstress = "SEPERTINYA KAMU SEDANG MERASA TERTEKAN ";
        }
        else if(type_question >= 26 && type_question <= 33){
            tingkatstress = "KAMU MERASAKAN BEBAN HIDUP YANG SANGAT BESAR DAN SULIT UNTUK MENGHADAPINYA";
        }
        else if(type_question >= 34){
            tingkatstress = "MARI LEPASKAN SEJENAK KEKHAWATIRANMU DENGAN MELAKUKAN RELAKSASI";
        }
        return tingkatstress;
    }
}