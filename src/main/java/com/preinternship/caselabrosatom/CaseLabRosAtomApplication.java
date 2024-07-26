package com.preinternship.caselabrosatom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class CaseLabRosAtomApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaseLabRosAtomApplication.class, args);
    }

}
