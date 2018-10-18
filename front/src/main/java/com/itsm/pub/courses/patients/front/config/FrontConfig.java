package com.itsm.pub.courses.patients.front.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.vibur.dbcp.ViburDBCPDataSource;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
@ComponentScan("com.itsm.pub.courses.patients")
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
public class FrontConfig {

    @Autowired
    private ConfigurableEnvironment environment;

    @Value("${server.driver}")
    private String driver;
    @Value("${server.url}")
    private String url;
    @Value("${server.user}")
    private String user;
    @Value("${server.password}")
    private String password;

    @Bean
    public DataSource ds() {
        ViburDBCPDataSource ds = new ViburDBCPDataSource();

        ds.setDriverClassName(driver);
        ds.setJdbcUrl(url);
        ds.setUsername(user);
        ds.setPassword(password);

        ds.start();

        return ds;
    }

    @Bean
    public SpringLiquibase springLiquibase(DataSource ds) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(ds);
        liquibase.setChangeLog("classpath:db/changeLog.xml");

        return liquibase;
    }

    @Bean
    public PlatformTransactionManager txManager(DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource ds) {
        return new JdbcTemplate(ds);
    }


    @PostConstruct
    public void initProfiles() {
        String profiles = environment.getProperty("spring.profiles.active");
        environment.setActiveProfiles(profiles.split(","));
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}