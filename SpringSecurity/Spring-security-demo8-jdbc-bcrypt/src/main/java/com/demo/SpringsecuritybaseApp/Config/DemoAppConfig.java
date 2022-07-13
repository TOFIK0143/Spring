package com.demo.SpringsecuritybaseApp.Config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.demo.SpringsecuritybaseApp")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {

    // set up a variable to store/hold properties

    @Autowired
    private Environment evn;

    // set up logger for diagnostics
    private Logger myLogger = Logger.getLogger(getClass().getName());



    // define a bean for ViewResolver

    @Bean
    public ViewResolver viewResolver() {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    //define a bean for our security data-source
    @Bean
    public DataSource securityDataSource()
    {
        // create connection pool
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        // set the jdbc driver class
        try {
            dataSource.setDriverClass(evn.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

        // log the connection props
        // for sanity's sake, log this info
        // just to make sure we are REALLY reading data from properties file
        myLogger.info(">>> jdbc.url=" + evn.getProperty("jdbc.url"));
        myLogger.info(">>> jdbc.user=" + evn.getProperty("jdbc.user"));


        // set database connection props
        dataSource.setJdbcUrl(evn.getProperty("jdbc.url"));
        dataSource.setUser(evn.getProperty("jdbc.user"));
        dataSource.setPassword(evn.getProperty("jdbc.password"));

        // set connection pool props

        dataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));

        dataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));

        dataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));

        dataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));


        return dataSource;
    }

    // need a helper method
    // read environment property and convert to int

    private int getIntProperty(String propName) {

        String propVal = evn.getProperty(propName);

        // now convert to int
        int intPropVal = Integer.parseInt(propVal);

        return intPropVal;
    }
}
