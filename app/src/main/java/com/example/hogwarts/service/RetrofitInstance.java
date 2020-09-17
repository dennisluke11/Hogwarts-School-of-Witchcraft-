package com.example.hogwarts.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dennis Luke Owuor
 */
public class RetrofitInstance {

    private static Retrofit retrofit = null;
    private static String BASE_URL="https://www.potterapi.com/v1/";

    public static DataService getService(){


        if(retrofit==null){

               retrofit=new Retrofit
                       .Builder()
                       .baseUrl(BASE_URL)
                       .addConverterFactory(GsonConverterFactory.create())
                       .build();

        }

        return retrofit.create(DataService.class);

    }

}
