package com.ptmind.ptengine;

import com.ptmind.ptengine.config.AbstractApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.net.UnknownHostException;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.ptmind")
public class Application extends AbstractApplication {

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
//        abstractMain(app, args);
    }
}
