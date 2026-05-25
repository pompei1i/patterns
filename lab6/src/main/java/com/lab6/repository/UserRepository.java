package com.lab6.repository;

import com.lab6.config.DatabaseConfig;
import javax.inject.Inject;

public class UserRepository {

    private final DatabaseConfig dbConfig;

    @Inject
    public UserRepository(DatabaseConfig dbConfig) {
        this.dbConfig = dbConfig;
    }

    public String findUser(int id) {
        System.out.println("UserRepository: finding user from DB " + dbConfig.getUrl());
        return "User#" + id;
    }
}
