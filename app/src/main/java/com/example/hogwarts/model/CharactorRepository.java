package com.example.hogwarts.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.hogwarts.R;
import com.example.hogwarts.service.DataService;
import com.example.hogwarts.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharactorRepository {
    private Student student;
    private MutableLiveData<Student> mutableLiveData=new MutableLiveData<>();
    private Application application;

    public CharactorRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<Student> getMutableLiveData(String studentId) {

        DataService dataService = RetrofitInstance.getService();

        Call<Student> call = dataService.getAStudent(studentId,application.getApplicationContext().getString(R.string.api_key));

        call.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                student = response.body();


                if (student != null) {

                    mutableLiveData.setValue(student);
                }
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {

                String error= t.getMessage();

            }

        });


        return mutableLiveData;
    }
}
