package com.example.hogwarts.service;

import com.example.hogwarts.model.House;
import com.example.hogwarts.model.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Dennis luke Owuor
 */
public interface DataService {


    @GET("characters")
    Call<List<Student>>getStudents(@Query("key") String apiKey);

    @GET("houses")
    Call<List<House>>getHouses(@Query("key") String apiKey);

    @GET("characters/{character_id}")
    Call<Student>getAStudent(
            @Path(value = "character_id",encoded = true) String studentId,
            @Query("key") String apiKey);
}
