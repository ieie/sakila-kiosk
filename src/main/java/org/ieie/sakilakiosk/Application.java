package org.ieie.sakilakiosk;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by ievgenii on 3/1/14.
 */
@Log4j2
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories
@ComponentScan//(basePackages = "org.ieie.sakilakiosk.domain")
public class Application { //extends SpringBootServletInitializer{


    public static void main(String... args){
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        log.info(ctx.getBeanDefinitionNames());
    }

//    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
}
