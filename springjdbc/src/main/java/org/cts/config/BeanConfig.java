package org.cts.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "org.cts")
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class BeanConfig {

    @Value("${mysql.driverName}")
    private String mySqlDriver;
    @Value("${mysql.connector-URL}")
    private String mySqlConnector;
    @Value("${mysql.userName}")
    private String mySqluserName;
    @Value("${mysql.passWord}")
    private String mySqlPassword;


    /* @Bean
     public DataSource dataSource() {
         return new EmbeddedDatabaseBuilder()
                 .setType(EmbeddedDatabaseType.H2)
                 .addScript("classpath:jdbc/schema.sql")
                 *//* .addScript("classpath:jdbc/test-data.sql")*//*.build();
    }*/
    /*@Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }*/

    @Bean
    public DataSource dataSource() {


        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(mySqlDriver);
        dataSource.setUrl(mySqlConnector);
        dataSource.setUsername(mySqluserName);
        dataSource.setPassword(mySqlPassword);

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource());
        return dataSourceTransactionManager;
    }
}
