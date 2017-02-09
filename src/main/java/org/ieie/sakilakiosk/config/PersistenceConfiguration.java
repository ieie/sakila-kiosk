package org.ieie.sakilakiosk.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;

/**
 * Created by ievgenii on 06.02.17.
 */
@Configuration
@EnableJpaRepositories(basePackages = {"org.ieie.sakilakiosk.domain"})
public class PersistenceConfiguration {


    @Value("${jdbc.driverClassName}")
    private String jdbcDriverClassName;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUsername;
    @Value("${jdbc.password}")
    private String jdbcPassword;
    @Value("${jdbc.schema}")
    private String jdbcSchema;

    @Value("${hibernate.dialect}")
    private String hibernateDialect;
    @Value("${hibernate.show_sql}")
    private String hibernateShowSql;
    @Value("${hibernate.hbm2ddl.auto}")
    private String hibernateHbm2DdlAuto;
    @Value("${hibernate.generate_statistics}")
    private String hibernateGenerateStatistics;

    @Bean
    public DriverManagerDataSource driverManagerDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(jdbcDriverClassName);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(jdbcUsername);
        dataSource.setPassword(jdbcPassword);
        dataSource.setSchema(jdbcSchema);
        return dataSource;
    }

    @Bean
    public Properties jpaProperties() {
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.dialect", hibernateDialect);
//        jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        jpaProperties.setProperty("hibernate.show_sql", hibernateShowSql);
        jpaProperties.setProperty("hibernate.hbm2ddl.auto", hibernateHbm2DdlAuto);
        jpaProperties.setProperty("hibernate.generate_statistics", hibernateGenerateStatistics);
        return jpaProperties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {


        LocalContainerEntityManagerFactoryBean emFactory = new LocalContainerEntityManagerFactoryBean();
        emFactory.setDataSource(driverManagerDataSource());
        emFactory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        emFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emFactory.setJpaProperties(jpaProperties());
//        emFactory.setPackagesToScan("domain");

        return emFactory;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

}
