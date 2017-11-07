package net.azurewebsites.mypet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class MyPetApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyPetApplication.class, args);
	}
}
