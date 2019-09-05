package com.example.demo.config;

import com.mongodb.MongoClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

/**
 * MongoConfiguration
 */
@Configuration
public class MongoConfiguration extends AbstractMongoConfiguration {

    private final String mongoHost;
    private final int mongoPort;

    public MongoConfiguration(@Autowired Environment environment) {
        super();
        final var host = environment.getProperty("APP_DB");
        mongoHost = host != null ? host : "localhost";

        final var port = environment.getProperty("APP_DB_PORT");
        mongoPort = port != null ? Integer.parseInt(port) : 27017;
    }

    @Override
    public MongoClient mongoClient() {
        return new MongoClient(String.format("%s:%d", mongoHost, mongoPort));
    }

    @Override
    protected String getDatabaseName() {
        return mongoHost;
    }
}
