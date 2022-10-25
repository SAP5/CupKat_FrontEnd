package com.dev.loja.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.dev.loja.service.ClienteI;


@Controller
public class PrincipalControle {
	@Autowired
	ClienteI servico;
	
	@GetMapping("/")
	public String homeCliente() {
		return "cliente/home";
	}

	@GetMapping("/adm")
	public String homeAdm() {
		return "administrativo/index";
	}

}
