package com.example.hogwarts.view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hogwarts.R;
import com.example.hogwarts.databinding.FragmentLandingBinding;

import java.util.ArrayList;

public class LandingFragment extends Fragment {
    FragmentLandingBinding fragmentLandingBinding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_landing, container, false);

        fragmentLandingBinding= DataBindingUtil.inflate(
                inflater, R.layout.fragment_landing, container, false);
        View view = fragmentLandingBinding.getRoot();

        fragmentLandingBinding.house.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController= Navigation.findNavController(v);
                navController.navigate(R.id.action_landingFragment_to_houseFragment);
            }
        });


        return view;



    }
}
