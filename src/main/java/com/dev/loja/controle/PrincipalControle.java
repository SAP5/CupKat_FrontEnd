package com.dev.loja.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dev.loja.model.Cliente;
import com.dev.loja.service.ClienteI;


@Controller
public class PrincipalControle {
	@Autowired
	ClienteI servico;
	
	@GetMapping("/")
	public String homeCliente() {
		return "home";
	}
	
	@GetMapping("/login")
	public String loginCliente(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente",cliente);
		return "cliente_form";
	}
}
