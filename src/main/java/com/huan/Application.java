package com.huan;

import com.huan.config.AbstractApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.net.UnknownHostException;

@SpringBootApplication(scanBasePackages = "com.huan", exclude = {DataSourceAutoConfiguration.class})
public class Application extends AbstractApplication {

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
//        abstractMain(app, args);
    }
}
