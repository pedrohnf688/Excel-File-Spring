package com.pedrohnf688;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.pedrohnf688")
public class ProjetoExcelFileSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoExcelFileSpringApplication.class, args);
	}

}
