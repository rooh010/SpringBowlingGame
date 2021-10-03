package com.example.bowling.helpers;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Configuration
public class JpaConfig {

    InputStream inputStream;

    @Bean(name = "mySqlDataSource")
    @Primary
    public DataSource mySqlDataSource() throws IOException {

        GetProperties properties = new GetProperties();
        Map<String, String> propsMap = properties.getPropValues();

        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(propsMap.get("jdbc_url"));
        dataSourceBuilder.username(propsMap.get("db_username"));
        dataSourceBuilder.password(propsMap.get("db_password"));
        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");

        return dataSourceBuilder.build();
    }

}
