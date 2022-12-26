package br.com.axolot.animal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DinoApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {		
		SpringApplication.run(DinoApplication.class, args);
		
	}
	  @Override
    protected SpringApplicationBuilder configure (SpringApplicationBuilder builder) {
        return builder.sources(DinoApplication.class);
    }
}
