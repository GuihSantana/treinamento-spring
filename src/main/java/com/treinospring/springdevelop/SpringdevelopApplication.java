package com.treinospring.springdevelop;

import com.treinospring.springdevelop.domain.*;
import com.treinospring.springdevelop.enums.EstadoPagamento;
import com.treinospring.springdevelop.enums.TipoCliente;
import com.treinospring.springdevelop.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
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

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

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

		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("28/04/2021 22:03"),mariaSilva,enderecoMariaSilva);
		Pedido ped2 = new Pedido(null, sdf.parse("28/04/2021 22:55"),mariaSilva,enderecoMariaSilvaAlternativo);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2021 10:17"), null);
		ped2.setPagamento(pagto2);


		mariaSilva.getPedidos().addAll(Arrays.asList(ped1,ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));



	}
}
