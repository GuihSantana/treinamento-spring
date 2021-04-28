package com.treinospring.springdevelop;

import com.treinospring.springdevelop.domain.*;
import com.treinospring.springdevelop.enums.TipoCliente;
import com.treinospring.springdevelop.repositories.*;
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

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

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
		Produto mouseVermelho = new Produto(null, "Mouse",80.00);
		categoriaInformatica.getProdutos().addAll(Arrays.asList(computador,impressora,mouse));
		categoriaEscritório.getProdutos().add(impressora);

		computador.getCategorias().add(categoriaInformatica);
		impressora.getCategorias().addAll(Arrays.asList(categoriaEscritório,categoriaInformatica));
		mouse.getCategorias().add(categoriaInformatica);

		categoriaRepository.saveAll(Arrays.asList(categoriaInformatica,categoriaEscritório));
		produtoRepository.saveAll(Arrays.asList(computador,impressora,mouse));


		Estado minasGerais = new Estado(null, "Minas Gerais");
		Estado saoPaulo = new Estado(null, "São Paulo");

		Cidade uberlandia = new Cidade(null, "Uberlandia", minasGerais);
		Cidade saoPauloCidade = new Cidade(null, "São Paulo", saoPaulo);
		Cidade campinas = new Cidade(null, "Campinas", saoPaulo);

		saoPaulo.getCidades().addAll(Arrays.asList(campinas,saoPauloCidade));
		minasGerais.getCidades().add(uberlandia);

		estadoRepository.saveAll(Arrays.asList(minasGerais,saoPaulo));
		cidadeRepository.saveAll(Arrays.asList(uberlandia,saoPauloCidade,campinas));

		Cliente mariaSilva = new Cliente(null, "Maria Silva", "maria@gmail.com", "56165161", TipoCliente.PESSOAFISICA);
		mariaSilva.getTelefones().addAll(Arrays.asList("24077895","991361985"));

		Endereco enderecoMariaSilva = new Endereco(
				null, "Rua Flores", "300", "Apt 2", "Jardim","4998948", mariaSilva, uberlandia);
		Endereco enderecoMariaSilvaAlternativo = new Endereco(
				null, "Avenida Matos", "105","Sala 900","Centro","2661", mariaSilva, saoPauloCidade);

		mariaSilva.getEnderecos().addAll(Arrays.asList(enderecoMariaSilva,enderecoMariaSilvaAlternativo));

		clienteRepository.save(mariaSilva);
		enderecoRepository.saveAll(Arrays.asList(enderecoMariaSilva,enderecoMariaSilvaAlternativo));



	}
}
