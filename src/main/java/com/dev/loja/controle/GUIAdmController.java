package com.dev.loja.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

	@GetMapping("/clientes/delete/{id}")
	public String deleteCliente(@PathVariable("id") int id){
		servico.delete(id);
		return "redirect:/adm/clientes";
	}

	@GetMapping("/alteraCli/{id}")
	public ModelAndView viewCliente(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("cliente/cliente_update");
        Cliente cliente = new Cliente();
		cliente = servico.getById(id);
        mv.addObject("cliente", cliente);
		return mv;
	}

	@PostMapping("/clientes/update/{id}")
	public String updateCliente(@PathVariable("id") int id, Cliente cliente){
		servico.update(cliente, id);
		System.out.println("passou");
		return "redirect:/adm/clientes";
	}
	
}
