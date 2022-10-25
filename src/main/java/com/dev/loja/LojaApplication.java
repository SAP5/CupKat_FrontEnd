package com.dev.loja;


import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dev.loja.model.Categoria;
import com.dev.loja.model.Cliente;
import com.dev.loja.model.Modelo;
import com.dev.loja.model.Produto;
import com.dev.loja.service.ClienteI;
import com.dev.loja.service.ProdutoI;


@SpringBootApplication
public class LojaApplication {



	public static void main(String[] args) {
		SpringApplication.run(LojaApplication.class, args);

		//altera cliente
		// Cliente cl = new Cliente("felipe", "12332178909","henrique@email.com.br","senhaSenha90123@");
		// ClienteI cli = new ClienteI();
		
		// cli.update(cl, 2);


		// Produto produto = new Produto();
		
		// List<String> cores = new ArrayList<String>();
		// cores.add("vermelho");

		// List<String> tamanhos = new ArrayList<String>();
		// tamanhos.add("médio");

	
		// List<Integer> cat = new ArrayList<Integer>();
		// cat.add(1);

		// produto.setNome("zzzzzzzzzzzzzzzzzzzzzzzzzzz");
		// produto.setDescricao("teste descrição");
		// produto.setLucro(10.0);
		// produto.setEstoque(10);
		// produto.setCores(cores);
		// produto.setTamanhos(tamanhos);
		// produto.setCategorias(cat);
		// produto.setModelo(1);
		
		// ProdutoI p2 = new ProdutoI();
		// p2.obtemProdutos();
		// p2.getById(3);
		// p2.update(produto, 3);
		// p2.save(produto);
		// p2.delete(6);


	}

}
