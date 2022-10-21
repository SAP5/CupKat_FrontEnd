package com.dev.loja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dev.loja.model.Cliente;
import com.dev.loja.service.ClienteI;


@SpringBootApplication
public class LojaApplication {



	public static void main(String[] args) {
		SpringApplication.run(LojaApplication.class, args);

		// //altera cliente
		// Cliente cl = new Cliente("felipe", "12332178909","henrique@email.com.br","senhaSenha90123@");
		// ClienteI cli = new ClienteI();
		
		// cli.update(cl, 2);
	}

}
