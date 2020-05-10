package com.example.galaw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class actLogin extends AppCompatActivity {

    EditText memail;
    EditText mpassword;
    Button mloginButton, msignup;
    TextView signup, forgotTextLink;
    ProgressBar progressBar;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_login);

        memail = findViewById(R.id.email);
        mpassword = findViewById(R.id.password);
        mloginButton = findViewById(R.id.loginButton);
        progressBar = findViewById(R.id.progressBar);
        msignup = findViewById(R.id.buttonSignup);
        forgotTextLink = findViewById(R.id.forgotPassword);
        fAuth = FirebaseAuth.getInstance();


        mloginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = memail.getText().toString().trim();
                String password = mpassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    memail.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mpassword.setError("Password is Required");
                    return;
                }

                if(password. length() < 6 ){
                    mpassword.setError("Password harus lebih dari 6 karakter");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                // Authenticate the user

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                     if (task.isSuccessful()){
                         Toast.makeText(actLogin.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                         startActivity(new Intent(getApplicationContext(),actHome.class));
                     }else{
                         Toast.makeText(actLogin.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                         progressBar.setVisibility(View.GONE);
                     }

                    }
                });

            }
        });


        msignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext() ,actSignUp.class));
            }
        });

        forgotTextLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText resetMail = new EditText(v.getContext());
                AlertDialog.Builder passwordResetDialong = new AlertDialog.Builder(v.getContext());
                passwordResetDialong.setTitle("Reset Password");
                passwordResetDialong.setMessage("Enter Your Email To Received Reset Link");
                passwordResetDialong.setView(resetMail);

                passwordResetDialong.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //extract the email and send reset link
                        String mail = resetMail.getText().toString();
                        fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(actLogin.this, "Reset Link Sent To Your Email", Toast.LENGTH_SHORT).show();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(actLogin.this, "Error ! Reset Link is Not Sent" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }) ;
                    }
                });

                passwordResetDialong.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // close the dialog

                    }
                });

                passwordResetDialong.create().show();
            }
        });


    }
}
