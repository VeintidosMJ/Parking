package com.clientes.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.clientes.v1.repositorios.ClienteRepositorio;

@SpringBootApplication
public class V1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(V1Application.class, args);
	}

	@Autowired
	private ClienteRepositorio repositorio;

	@Override
	public void run(String... args) throws Exception {

	}

}
