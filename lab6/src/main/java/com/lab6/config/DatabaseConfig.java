package com.lab6.config;

import javax.inject.Inject;

public class DatabaseConfig {

    @Inject
    public DatabaseConfig() {}

    public String getUrl() {
        return "jdbc:h2:mem:testdb";
    }
}
