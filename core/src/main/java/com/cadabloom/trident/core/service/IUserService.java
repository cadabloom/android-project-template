package com.cadabloom.trident.core.service;

import com.cadabloom.trident.core.models.User;
import com.cadabloom.trident.core.requests.LoginUser;
import com.cadabloom.trident.core.requests.RegisterUser;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IUserService {
    @POST("5b5e97302e00006400694567")
    @Headers("Cache-Control: no-cache")
    Call<String> registerUser(@Body RegisterUser user);

    @GET("users/{id}")
    @Headers("Cache-Control: no-cache")
    Observable<User> getUserById(@Path(value = "id", encoded = true) String id);

    @POST("auth/signin")
    @Headers("Cache-Control: no-cache")
    Flowable<String> login(@Body LoginUser user);

    @POST("users/signup")
    @Headers("Cache-Control: no-cache")
    Flowable<String> register(@Body RegisterUser user);

    @POST("5b5e97302e00006400694567")
    @Headers("Cache-Control: no-cache")
    Observable<String> getMockyData();

    @GET("values")
    @Headers("Cache-Control: no-cache")
    Observable<List<String>> getValues();
}
