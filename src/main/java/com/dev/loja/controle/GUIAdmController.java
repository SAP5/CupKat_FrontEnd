package com.dev.loja.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.loja.model.Cliente;
import com.dev.loja.service.ClienteI;

@Controller
@RequestMapping(path = "/adm")
public class GUIAdmController {
    @Autowired
    ClienteI servico;

    @GetMapping("/clientes")
	public String homeAdm(Model model) {
		List<Cliente> listClientes = servico.obtemClientes();
		model.addAttribute("listClientes", listClientes); 
		return "administrativo/Clientes";
	}
	
}
