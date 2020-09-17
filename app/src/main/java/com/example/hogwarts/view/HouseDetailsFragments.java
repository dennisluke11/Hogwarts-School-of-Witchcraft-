package com.example.hogwarts.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.hogwarts.R;
import com.example.hogwarts.databinding.FragmentHouseDetailBinding;
import com.example.hogwarts.databinding.FragmentHouseDetailsBinding;
import com.example.hogwarts.model.House;
import com.google.android.material.navigation.NavigationView;

public class HouseDetailsFragments extends Fragment {

    private FragmentHouseDetailBinding fragmentHouseDetailsBinding;

    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentHouseDetailsBinding= DataBindingUtil.inflate(
                inflater, R.layout.fragment_house_detail, container, false);
        View view = fragmentHouseDetailsBinding.getRoot();

        Bundle args = getArguments();
        House house= (House) args.getSerializable("selectedHouse");
        //fragmentHouseDetailsBinding.setHouse(house);
       // ((AppCompatActivity)getActivity()).getSupportActionBar().setSubtitle(R.string.subtitle);
        //Toolbar toolbar = fragmentHouseDetailsBinding.;
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        final ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
            actionBar.setDisplayShowTitleEnabled(false);
        }

        DrawerLayout drawer = fragmentHouseDetailsBinding.drawerLayout;


        return view;
    }
}
