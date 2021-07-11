package com.cadabloom.trident.core.repositories;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TestRepository {

    @Inject
    public TestRepository() {

    }

    public String getName() {
        return "test";
    }
}
