package com.ElTopin;



import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.ElTopin.Ventanas;



@SpringBootApplication

public class ElTopin extends Ventanas implements CommandLineRunner{
	


	public static void main(String[] args) throws IOException {
		//SpringApplication.run(AdrianLlorian1Application.class, args);
		  //new SpringApplicationBuilder(ElTopin.class).headless(false).run(args);
		SpringApplicationBuilder builder = new SpringApplicationBuilder(ElTopin.class);
		builder.headless(false);
		ConfigurableApplicationContext context = builder.run(args);
	}
	
	
	@Override
    public void run(String... args) {
        crearVenatanaInicio();
    }
	

}
