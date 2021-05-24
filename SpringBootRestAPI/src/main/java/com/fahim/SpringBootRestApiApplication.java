package com.fahim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
@EnableSwagger2
@EnableJpaRepositories(basePackages = "com.fahim.repository")
@EntityScan(basePackages = "com.fahim.entity")
public class SpringBootRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestApiApplication.class, args);
    }

    @Bean
    public Docket getSwaggerDetails() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/*"))
                .apis(RequestHandlerSelectors.basePackage("com.fahim"))
                .build()
                .apiInfo(getApiInfoDetails());
    }

    @SuppressWarnings("deprecation")
    public ApiInfo getApiInfoDetails() {
        return new ApiInfo(null, null, null, null, null, null, null);
    }

}
