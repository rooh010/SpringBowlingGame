package com.example.bowling;

import com.example.bowling.helpers.DbConnectionTest;
import com.example.bowling.helpers.GetProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Logger;


@SpringBootApplication
public class BowlingApplication implements CommandLineRunner {

    private static final Logger LOG = Logger
            .getLogger(BowlingApplication.class.getName());


    public static void main(String[] args) throws IOException, SQLException {
        SpringApplication.run(BowlingApplication.class, args);

        LOG.info("Getting Properties");
        GetProperties properties = new GetProperties();
        Map<String, String> propsMap = properties.getPropValues();

        LOG.info("Test Database Connection");
        DbConnectionTest conn = new DbConnectionTest();
        String RecordsCount = conn.ConnectDb(propsMap);
        LOG.info("Records in Players Table: " + RecordsCount);

        LOG.info("We are ready to boooowwwwllllll");
    }

    @Override
    public void run(String... args) {
        LOG.info("Running: Initialising Application");
    }
}