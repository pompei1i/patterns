package com.lab6.repository;

import com.lab6.config.DatabaseConfig;
import javax.inject.Inject;

public class ProductRepository {

    private final DatabaseConfig dbConfig;

    @Inject
    public ProductRepository(DatabaseConfig dbConfig) {
        this.dbConfig = dbConfig;
    }

    public String findProduct(int id) {
        System.out.println("ProductRepository: finding product from DB " + dbConfig.getUrl());
        return "Product#" + id;
    }
}
