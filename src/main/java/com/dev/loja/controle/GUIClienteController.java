package com.dev.loja.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dev.loja.model.Cliente;
import com.dev.loja.service.ClienteI;

@Controller
@RequestMapping(path = "/")
public class GUIClienteController {
    @Autowired
    ClienteI servico;

    @GetMapping("/cliente")
	public String formCliente(Model model) {
        Cliente cliente = new Cliente();
        model.addAttribute("cliente",cliente);
		return "cliente/cliente_form";
	}


    @PostMapping("/saveUser")
	public String saveCliente(Cliente cliente, RedirectAttributes redirectAttributes) {
		System.out.println(cliente);
		servico.save(cliente);
		redirectAttributes.addFlashAttribute("message", "Usuário criado com sucesso!");
		return "redirect:/";
	}

}
