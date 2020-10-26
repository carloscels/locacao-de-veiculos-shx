package com.shx.carros.configuracao;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.shx.carros.entidades.Categoria;
import com.shx.carros.entidades.Usuario;
import com.shx.carros.entidades.Ordem;
import com.shx.carros.entidades.OrdemProduto;
import com.shx.carros.entidades.Pagamento;
import com.shx.carros.entidades.Produto;
import com.shx.carros.entidades.enums.OrdemdeStatus;
import com.shx.carros.repositorios.RepositoriodaCategoria;
import com.shx.carros.repositorios.RepositoriodoUsuario;
import com.shx.carros.repositorios.RepositoriodaOrdem;
import com.shx.carros.repositorios.RepositoriodaOrdemProduto;
import com.shx.carros.repositorios.RepositoriodoProduto;
//aqui estão os testes.
@Configuration
@Profile("test")
public class TestConfiguracao implements CommandLineRunner {
	
	@Autowired
	private RepositoriodoUsuario usuarioRepositorio;
	
	@Autowired
	private RepositoriodaOrdem ordemRespositorio;

	@Autowired
	private RepositoriodaCategoria categoriaRepositorio;
	
	@Autowired
	private RepositoriodoProduto produtoRepositorio;
	
	@Autowired
	private RepositoriodaOrdemProduto ordemprodutoRepositorio;
	
	
	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "carro azul");
		Categoria cat2 = new Categoria(null, "carro vermelho");
		Categoria cat3 = new Categoria(null, "carro verde"); 
		
		Produto p1 = new Produto(null, "carro1", "abc", "2010","grande", "gasolina",200.0,2);
		Produto p2 = new Produto(null, "carro1", "abc", "2010","grande", "gasolina", 200.0,2);
		Produto p3 = new Produto(null, "carro1", "abc", "2010","grande", "gasolina",200.0,2);
		Produto p4 = new Produto(null, "carro1", "abc", "2010","grande", "gasolina", 200.0,2);
		Produto p5 = new Produto(null, "carro1", "abc", "2010","grande", "gasolina", 200.0,2);
		
		categoriaRepositorio.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		produtoRepositorio.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategorias().add(cat1);
		p2.getCategorias().add(cat2);
		p3.getCategorias().add(cat3);
		p4.getCategorias().add(cat2);
		p5.getCategorias().add(cat1);

		produtoRepositorio.saveAll(Arrays.asList(p1, p2, p3, p4, p5)); 
		
		
		Usuario a = new Usuario (null,"carlos", "12345678901","12345678");
		Usuario b = new Usuario (null,"eduardo", "12345678902","12345678");
		
		Ordem ca = new Ordem(null,Instant.parse("2020-10-25T19:53:07Z"),OrdemdeStatus.PAID,a);
		Ordem cb = new Ordem(null,null,OrdemdeStatus.WAITING_PAYMENT,null);
		Ordem cc = new Ordem(null,null,OrdemdeStatus.WAITING_PAYMENT,null);
		
		
		usuarioRepositorio.saveAll(Arrays.asList(a,b));
		ordemRespositorio.saveAll(Arrays.asList(ca,cb,cc));
		

		OrdemProduto oi1 = new OrdemProduto(ca, p1, 1, p1.getPreco());
		OrdemProduto oi2 = new OrdemProduto(ca, p3, 1, p3.getPreco());
		OrdemProduto oi3 = new OrdemProduto(cb, p3, 2, p3.getPreco());
		OrdemProduto oi4 = new OrdemProduto(cb, p5, 2, p5.getPreco());
	
		ordemprodutoRepositorio.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
	
		
		Pagamento pag1 = new Pagamento(null, Instant.parse("2020-10-25T19:53:07Z"),ca);
		ca.setPagamento(pag1);
		
		ordemRespositorio.saveAll(Arrays.asList(ca));
		
	}

}
