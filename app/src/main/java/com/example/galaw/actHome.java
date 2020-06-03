package com.example.galaw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import javax.annotation.Nullable;

public class actHome extends AppCompatActivity  {


    TextView name;
    Button setting;
    ImageView profileImage;
    StorageReference storageReference;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;



    Button[] navigationButton = new Button[4];
    int indexNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_home);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        profileImage = findViewById(R.id.profileImage);

        fAuth = FirebaseAuth.getInstance();

        Log.d("tag", "onCreate: " + fAuth.getCurrentUser().getEmail() + fAuth.getCurrentUser().getDisplayName());

        fStore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();

        userID = fAuth.getCurrentUser().getUid();
        name = findViewById(R.id.nameProfile);



        DocumentReference documentReference = fStore.collection("Users").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                name.setText(documentSnapshot.getString("Name"));
            }
        });


        StorageReference profileRef = storageReference.child("Users/"+fAuth.getCurrentUser().getUid()+"/profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(profileImage);
            }
        });

        indexNav = 0;
        navigationButton[0] = findViewById(R.id.homeButton);
        navigationButton[1] = findViewById(R.id.publicButton);
        navigationButton[2] = findViewById(R.id.healButton);
        navigationButton[3] = findViewById(R.id.profileButton);
        setting = findViewById(R.id.setting);

        setting.setVisibility(View.GONE);

        navigationButton[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout, new fragHome());
                ft.commit();

                navigationButton[indexNav].setTextColor((Color.parseColor("#7B5CFF")));
                navigationButton[indexNav].setBackgroundColor((Color.parseColor("#FFFFFF")));

                setting.setVisibility(View.GONE);

                indexNav = 0;

                navigationButton[indexNav].setTextColor((Color.parseColor("#ffffff")));
                navigationButton[indexNav].setBackgroundColor((Color.parseColor("#7B5CFF")));
            }
        });

        navigationButton[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout, new fragPublic());
                ft.commit();

                navigationButton[indexNav].setTextColor((Color.parseColor("#7B5CFF")));
                navigationButton[indexNav].setBackgroundColor((Color.parseColor("#FFFFFF")));

                setting.setVisibility(View.GONE);
                indexNav = 1;

                navigationButton[indexNav].setTextColor((Color.parseColor("#ffffff")));
                navigationButton[indexNav].setBackgroundColor((Color.parseColor("#7B5CFF")));
            }
        });

        navigationButton[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout, new fragHeal());
                ft.commit();

                navigationButton[indexNav].setTextColor((Color.parseColor("#7B5CFF")));
                navigationButton[indexNav].setBackgroundColor((Color.parseColor("#FFFFFF")));

                setting.setVisibility(View.GONE);
                indexNav = 2;

                navigationButton[indexNav].setTextColor((Color.parseColor("#ffffff")));
                navigationButton[indexNav].setBackgroundColor((Color.parseColor("#7B5CFF")));
            }
        });

        navigationButton[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout, new fragProfile());
                ft.commit();

                navigationButton[indexNav].setTextColor((Color.parseColor("#7B5CFF")));
                navigationButton[indexNav].setBackgroundColor((Color.parseColor("#FFFFFF")));

                setting.setVisibility(View.VISIBLE);
                indexNav = 3;

                navigationButton[indexNav].setTextColor((Color.parseColor("#ffffff")));
                navigationButton[indexNav].setBackgroundColor((Color.parseColor("#7B5CFF")));
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(actHome.this, actEditProfile.class);
            startActivity(intent);
            }
        });


        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, new fragHome());
        ft.commit();
    }


}
