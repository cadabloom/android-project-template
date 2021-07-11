package com.cadabloom.trident.core.di;

import com.cadabloom.trident.core.bus.RxBus;
import com.cadabloom.trident.core.repositories.TestRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@InstallIn(SingletonComponent.class)
@Module
public class CoreModule {

    @Provides
    static TestRepository testRepository() {
        return new TestRepository();
    }

    @Provides
    @Singleton
    static RxBus rxBus(){
        return new RxBus();
    }
}
