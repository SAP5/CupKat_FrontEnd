package com.dev.loja;


import java.math.BigDecimal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dev.loja.model.Modelo;
import com.dev.loja.service.ModeloI;


@SpringBootApplication
public class LojaApplication {



	public static void main(String[] args) {
		SpringApplication.run(LojaApplication.class, args);

		//altera cliente
		// Cliente cl = new Cliente("felipe", "12332178909","henrique@email.com.br","senhaSenha90123@");
//		 ClienteI cli = new ClienteI();
//		 cli.getByEmail("novoclienteasdasdasf1@gmail.com");
//		 cli.isEmailUnique("novocliente1@gmail.com");
		// cli.update(cl, 2);


//		 Produto produto = new Produto();
//		 List<Integer> numC = new ArrayList<Integer>();
//		 List<Integer> numT = new ArrayList<Integer>();
//		 List<Integer> numCa = new ArrayList<Integer>();
//		 numC.add(1);
//		 numC.add(2);
//		 numT.add(1);
//		 numT.add(2);
//		 numCa.add(1);
//		 numCa.add(2);
//		 
//		 produto.setNome("Novo produto");
//		 produto.setDescricao("teste descrição");
//		 produto.setLucro(10.0);
//		 produto.setEstoque(10);
//		 produto.setCores(numC);
//		 produto.setTamanhos(numT);
//		 produto.setCategorias(numCa);
//		 produto.setModelo(3);
//		 
//		 ProdutoI p2 = new ProdutoI();
//		 p2.save(produto);

//		CorI cor = new CorI();
//		cor.obtemCores();
//		cor.getById(1);
//		TamanhoI tamanho = new TamanhoI();
//		tamanho.getById(1);
//		tamanho.obtemTamanhos();
//		CategoriaI categoria = new CategoriaI();
//		categoria.getById(1);
//		categoria.obtemCategoria();


		// Funcionario func = new Funcionario("Gabriel", "ghaamorim338@gmail.com", "@Teste123");
		// FuncionarioI service = new FuncionarioI();
		// service.save(func);

		// FuncionarioI service = new FuncionarioI();
		// service.obtemFuncionarios();

		// Funcionario func = new Funcionario("Gabriel", "ghaamorim338@gmail.com", "@Teste123");
		// service.update(func, 2);
		
		// service.delete(2);

		// service.getById(1);
		
		 
		 
//		CategoriaI cat = new CategoriaI();
//		Categoria cate = new Categoria();
		 
//		cate.setTitulo("Boinas");
//		cate.setDescricao("bonés novos");
		 
//		cat.save(cate);
//		cat.update(cate, 6);
//		cat.delete(6);
		 
//		cat.obtemCategoria();
//		cat.getById(1);
		
		
//		ModeloI mod = new ModeloI();
//		Modelo model = new Modelo();
//		BigDecimal x = new BigDecimal("30");
//		model.setTitulo("Adesivos");
//		model.setPrecoCusto(x);
//		model.setDescricao("Adesivos personalizados");
		
//		mod.delete(8);
//		mod.update(model, 5);
//		mod.save(model);
//		mod.getById(1);
//		mod.obtemModelos();
	}

}
