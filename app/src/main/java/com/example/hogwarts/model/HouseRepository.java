package com.example.hogwarts.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.hogwarts.R;
import com.example.hogwarts.service.RetrofitInstance;
import com.example.hogwarts.service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HouseRepository {
    private ArrayList<House> houses=new ArrayList<>();
    private MutableLiveData<List<House>> mutableLiveData=new MutableLiveData<>();
    private Application application;

    public HouseRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<House>> getMutableLiveData() {

        DataService dataService = RetrofitInstance.getService();

        Call<List<House>> call = dataService.getHouses(application.getApplicationContext().getString(R.string.api_key));

        call.enqueue(new Callback<List<House>>() {
            @Override
            public void onResponse(Call<List<House>> call, Response<List<House>> response) {
                List<House> houseDBResponse = response.body();


                if (houseDBResponse != null) {

                    houses = (ArrayList<House>) houseDBResponse;
                    mutableLiveData.setValue(houses);
                }
            }

            @Override
            public void onFailure(Call<List<House>> call, Throwable t) {

            }

        });


        return mutableLiveData;
    }
}
