package com.example.hogwarts.view;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hogwarts.R;
import com.example.hogwarts.adapter.HouseAdapter;
import com.example.hogwarts.databinding.FragmentHouseBinding;
import com.example.hogwarts.model.House;
import com.example.hogwarts.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class HouseFragment extends Fragment {
    private ArrayList<House> house;
    private RecyclerView recyclerView;
    private HouseAdapter houseAdapter;
    private MainActivityViewModel mainActivityViewModel;
    private FragmentHouseBinding fragmentHouseBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentHouseBinding= DataBindingUtil.inflate(
                inflater, R.layout.fragment_house, container, false);
        View view = fragmentHouseBinding.getRoot();
       // ((AppCompatActivity)getActivity()).getSupportActionBar().setSubtitle(R.string.subtitle);
        mainActivityViewModel= ViewModelProviders.of(this).get(MainActivityViewModel.class);
        getHouses();
        return view;
    }



    public void getHouses() {

        mainActivityViewModel.getAllHouses().observe(this, new Observer<List<House>>() {
            @Override
            public void onChanged(@Nullable List<House> housesFromLiveData) {
                house = (ArrayList<House>) housesFromLiveData;
                showOnRecyclerView();
            }
        });


    }

    private void showOnRecyclerView() {

        recyclerView = fragmentHouseBinding.rvHouse;
        houseAdapter = new HouseAdapter(getContext(), house);

        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        } else {


            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));


        }

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(houseAdapter);
        houseAdapter.notifyDataSetChanged();

    }














}
