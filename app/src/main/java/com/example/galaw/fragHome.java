package com.example.galaw;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;



public class fragHome extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    //private String mParam1;
    //private String mParam2;
    Button banner1, banner2, banner3;
    ViewFlipper flipperHome;
    TextView healthDef;
    private int levelquiz;

    public fragHome() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    /*public static fragHome newInstance(String param1, String param2) {
        fragHome fragment = new fragHome();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //mParam1 = getArguments().getString(ARG_PARAM1);
            //mParam2 = getArguments().getString(ARG_PARAM2);
            levelquiz = getArguments().getInt("quiz");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_home2, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageSlider imageSlider = view.findViewById(R.id.SliderBanner);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.bannerdepresi));
        slideModels.add(new SlideModel(R.drawable.bannerstress));
        slideModels.add(new SlideModel(R.drawable.bannercemas));
        imageSlider.setImageList(slideModels, true);

        banner1 = view.findViewById(R.id.banner1);
        banner2 = view.findViewById(R.id.banner2);
        banner3 = view.findViewById(R.id.banner3);
        healthDef = view.findViewById(R.id.healthDef);



        healthDef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), actMentalDef.class);
                startActivity(intent);
            }
        });


        banner1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), actAllTest.class);
                intent.putExtra("quiz",levelquiz);
                startActivity(intent);


            }
        });

        banner2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), actAnxiety.class);
                intent.putExtra("quiz",levelquiz);
                startActivity(intent);
            }
        });

        banner3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), actDepression.class);
                startActivity(intent);
            }
        });

    }
}
