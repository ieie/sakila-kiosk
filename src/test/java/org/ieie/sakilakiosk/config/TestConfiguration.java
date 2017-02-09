package org.ieie.sakilakiosk.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by ievgenii on 25.05.15.
 */
@Import(TestPersistenceConfiguration.class)
@Configuration
@ComponentScan(basePackages = {"org.ieie.sakilakiosk.domain"})
public class TestConfiguration {

    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(){
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocation(new ClassPathResource("test-application.properties"));
        ppc.setIgnoreUnresolvablePlaceholders(true);
        return ppc;
    }

}
