package ru.venkispb.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;

import java.util.logging.Level;
import java.util.logging.Logger;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@EnableSwagger2
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("ru.venkispb.server.controller"))
//                .paths(regex("/product.*"))
                .build();
    }

    @PostConstruct
    public void initialize() {
        final Logger logger = Logger.getLogger(ServerApplication.class.getName());
        logger.log(Level.SEVERE, "****USER:" + System.getenv("JDBC_DATABASE_USERNAME"));
        logger.log(Level.SEVERE, "****PASSWORD:" + System.getenv("JDBC_DATABASE_PASSWORD"));
    }

}
