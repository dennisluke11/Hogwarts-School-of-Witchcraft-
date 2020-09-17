package com.example.hogwarts.viewmodel;

import android.app.Application;



import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.hogwarts.model.CharactorRepository;
import com.example.hogwarts.model.House;
import com.example.hogwarts.model.HouseRepository;
import com.example.hogwarts.model.Student;
import com.example.hogwarts.model.StudentRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private HouseRepository houseRepository;
    private CharactorRepository charactorRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        houseRepository=new HouseRepository(application);
        charactorRepository=new CharactorRepository(application);
    }

    public LiveData<List<House>> getAllHouses(){

        return houseRepository.getMutableLiveData();
    }


    public MutableLiveData<Student> getStudent( String studentId){

        return charactorRepository.getMutableLiveData(studentId);
    }


}
