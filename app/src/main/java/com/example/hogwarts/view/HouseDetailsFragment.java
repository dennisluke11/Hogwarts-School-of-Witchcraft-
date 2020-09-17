package com.example.hogwarts.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hogwarts.R;
import com.example.hogwarts.databinding.FragmentHouseBinding;
import com.example.hogwarts.databinding.FragmentHouseDetailsBinding;
import com.example.hogwarts.model.House;
import com.example.hogwarts.viewmodel.MainActivityViewModel;
import com.google.android.material.navigation.NavigationView;

import java.io.Serializable;
import java.util.ArrayList;

public class HouseDetailsFragment extends Fragment {

    private FragmentHouseDetailsBinding fragmentHouseDetailsBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentHouseDetailsBinding= DataBindingUtil.inflate(
                inflater, R.layout.fragment_house_details, container, false);
        final View view = fragmentHouseDetailsBinding.getRoot();

        Bundle args = getArguments();
        final House house= (House) args.getSerializable("selectedHouse");
        fragmentHouseDetailsBinding.setHouse(house);
        //((AppCompatActivity)getActivity()).getSupportActionBar().setSubtitle(R.string.subtitle);

      fragmentHouseDetailsBinding.clickCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
      Bundle bundles = new Bundle();
      bundles.putSerializable("house",house);
      bundles.putStringArrayList("characterList", (ArrayList<String>) house.getMembers());
      NavController navController= Navigation.findNavController(view);
      navController.navigate(R.id.action_houseDetailsFragment2_to_charactersFragment,bundles);
            }
        });

        return view;
    }



}
