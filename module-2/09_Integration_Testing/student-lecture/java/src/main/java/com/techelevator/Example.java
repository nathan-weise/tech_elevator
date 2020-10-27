package com.techelevator;

import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class Example {

    public static void main(String[] args) {
        SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/dvdstore");
        dataSource.setUsername("postgres");
        dataSource.setPassword(System.getenv("DB_PASSWORD"));
        dataSource.setAutoCommit(false);

    }
}
