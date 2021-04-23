package com.treinospring.springdevelop;

import com.treinospring.springdevelop.domain.Categoria;
import com.treinospring.springdevelop.domain.Produto;
import com.treinospring.springdevelop.repositories.CategoriaRepository;
import com.treinospring.springdevelop.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringdevelopApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringdevelopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria categoriaInformatica = new Categoria(null,"Informática");
		Categoria categoriaEscritório = new Categoria(null,"Escritório");

		Produto computador = new Produto(null, "Computador",2000.00);
		Produto impressora = new Produto(null, "Impressora",1300.00);
		Produto mouse = new Produto(null, "Mouse",80.00);

		categoriaInformatica.getProdutos().addAll(Arrays.asList(computador,impressora,mouse));
		categoriaEscritório.getProdutos().add(impressora);

		computador.getCategorias().add(categoriaInformatica);
		impressora.getCategorias().addAll(Arrays.asList(categoriaEscritório,categoriaInformatica));
		mouse.getCategorias().add(categoriaInformatica);



		categoriaRepository.saveAll(Arrays.asList(categoriaInformatica,categoriaEscritório));
		produtoRepository.saveAll(Arrays.asList(computador,impressora,mouse));

	}
}
