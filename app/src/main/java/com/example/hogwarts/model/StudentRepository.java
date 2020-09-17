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

public class StudentRepository {
    private ArrayList<Student> students=new ArrayList<>();
    private MutableLiveData<List<Student>> mutableLiveData=new MutableLiveData<>();
    private Application application;

    public StudentRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Student>> getMutableLiveData() {

        DataService dataService = RetrofitInstance.getService();

        Call<List<Student>> call = dataService.getStudents(application.getApplicationContext().getString(R.string.api_key));

        call.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                List<Student> studentDBResponse = response.body();


                if (studentDBResponse != null) {

                    students = (ArrayList<Student>) studentDBResponse;
                    mutableLiveData.setValue(students);
                }
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {

            }

        });


        return mutableLiveData;
    }
}
