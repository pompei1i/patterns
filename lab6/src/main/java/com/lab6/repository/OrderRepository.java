package com.lab6.repository;

import com.lab6.config.DatabaseConfig;
import javax.inject.Inject;

public class OrderRepository {

    private final DatabaseConfig dbConfig;

    @Inject
    public OrderRepository(DatabaseConfig dbConfig) {
        this.dbConfig = dbConfig;
    }

    public String findOrder(int id) {
        System.out.println("OrderRepository: finding order from DB " + dbConfig.getUrl());
        return "Order#" + id;
    }
}
