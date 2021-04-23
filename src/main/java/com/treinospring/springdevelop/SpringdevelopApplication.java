package com.treinospring.springdevelop;

import com.treinospring.springdevelop.domain.Categoria;
import com.treinospring.springdevelop.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringdevelopApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringdevelopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria categoriaInformatica = new Categoria(null,"Informática");
		Categoria categoriaEscritório = new Categoria(null,"Escritório");

		categoriaRepository.saveAll(Arrays.asList(categoriaInformatica,categoriaEscritório));

	}
}
