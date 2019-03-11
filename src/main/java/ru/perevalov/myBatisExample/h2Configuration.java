package ru.perevalov.myBatisExample;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
public class h2Configuration {

    private final static  String SCRIPT_ENCODING = "UTF-8";
    private final static  String DB_URL = "jdbs:h2:~/h2-testdb;MODE=ORACLE";
    private final static  String DB_USER = "sa";
    private final static  String DB_PASS = "UTF-8";
    @Value("classpath:prepare_test_db.sql")
    private Resource createDbScript;
    @Value("classpath:fill_test_db.sql")
    private Resource fillDbScript;

    @Bean
    public DataSource dataSource(){
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setDescription(DB_URL);
        dataSource.setUser(DB_USER);
        dataSource.setPassword(DB_PASS);
        return dataSource;
    }
    @Bean
    public DataSourceInitializer dataSourceInitializer(){
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(dataSource());
        dataSourceInitializer.setDatabasePopulator(dataSourcePopulator());
        return dataSourceInitializer;
    }

    private DatabasePopulator dataSourcePopulator() {
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
        resourceDatabasePopulator.addScript(createDbScript);
        resourceDatabasePopulator.addScript(fillDbScript);
        resourceDatabasePopulator.setSqlScriptEncoding(SCRIPT_ENCODING);
        return resourceDatabasePopulator;
    }


}
