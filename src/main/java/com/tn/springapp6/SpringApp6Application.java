package com.tn.springapp6;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableEncryptableProperties
@SpringBootApplication
public class SpringApp6Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringApp6Application.class, args);
    }

}
