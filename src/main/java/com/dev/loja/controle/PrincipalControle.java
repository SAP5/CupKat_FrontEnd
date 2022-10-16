package com.dev.loja.controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalControle {
	
	@GetMapping("/")
	public String homeCliente() {
		return "cliente/home";
	}

	@GetMapping("/adm")
	public String homeAdm() {
		return "administrativo/home";
	}
}
