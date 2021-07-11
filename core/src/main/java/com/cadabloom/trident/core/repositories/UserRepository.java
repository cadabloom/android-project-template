package com.cadabloom.trident.core.repositories;

import com.cadabloom.trident.core.models.User;
import com.cadabloom.trident.core.requests.LoginUser;
import com.cadabloom.trident.core.requests.RegisterUser;
import com.cadabloom.trident.core.service.IUserService;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import timber.log.Timber;

public class UserRepository {
    private IUserService userService;

    public UserRepository(Retrofit retrofit) {
        Timber.i(retrofit.baseUrl().toString());
        this.userService = retrofit.create(IUserService.class);
    }

    public Call<String> registerUser(RegisterUser user) {
        return this.userService.registerUser(user);
    }

    public Observable<User> getUserById(String id) {
        return this.userService.getUserById(id);
    }

    public Flowable<String> login(LoginUser user) {
        return this.userService.login(user);
    }

    public Flowable<String> register(RegisterUser registerUser) {
        return this.userService.register(registerUser)
                .onErrorReturn(throwable -> String.format("error: %s", throwable.getMessage()));
    }

    public Observable<String> getMockyData() {
        return this.userService.getMockyData();
    }
}
