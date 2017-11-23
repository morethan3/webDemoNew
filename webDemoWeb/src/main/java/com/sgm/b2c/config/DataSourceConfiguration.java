package com.sgm.b2c.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author Created by Li B.
 * @date Created in 2017/11/22.
 */
@Configuration
public class DataSourceConfiguration {

    @Bean(name = "secondDatasource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource secondDataSource() {
        return DataSourceBuilder.create().build();
    }
}
