package com.ilyass.webapp;

import com.ilyass.webapp.repository.CustomProperties;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Data
@SpringBootApplication
public class WebappApplication  implements CommandLineRunner {

    @Autowired
    private CustomProperties properties;

    public static void main(String[] args) {

        SpringApplication.run(WebappApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("CustomProperties properties.getApiUrl():  "+
                properties.getApiUrl());
    }
}
