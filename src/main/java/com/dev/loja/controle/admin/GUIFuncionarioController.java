package com.dev.loja.controle.admin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dev.loja.model.Funcionario;
import com.dev.loja.service.FuncionarioI;

@Controller
@RequestMapping(path = "/adm")
public class GUIFuncionarioController {
    @Autowired
    FuncionarioI servico;

    @GetMapping("/funcionarios")
	public String listFuncionarios(Model model) {
		List<Funcionario> listFuncionarios = servico.obtemFuncionarios();
		model.addAttribute("listFuncionarios", listFuncionarios);
		return "administrativo/funcionarios";
	}

    @GetMapping("/funcionario")
	public String formFuncionario(Model model) {
        Funcionario funcionario = new Funcionario();
        model.addAttribute("funcionario",funcionario);
		return "administrativo/funcionario_form";
	}

    @PostMapping("/saveFuncionario")
	public String saveCliente(Funcionario funcionario, RedirectAttributes redirectAttributes) {
		System.out.println(funcionario);
		servico.save(funcionario);
		redirectAttributes.addFlashAttribute("message", "Funcionario criado com sucesso!");
		return "redirect:/adm/funcionarios";
	}

    @GetMapping("/alteraFunc/{id}")
	public String viewFuncionarioUpdate(@PathVariable("id") int id, Model model) {
        Funcionario funcionario = new Funcionario();
		funcionario = servico.getById(id);
        model.addAttribute("funcionario", funcionario);
		return "administrativo/funcionario_update";
	}

    @PostMapping("/funcionarios/update/{id}")
	public String updateFuncionario(@PathVariable("id") int id, Funcionario funcionario, RedirectAttributes redirectAttributes){
		servico.update(funcionario, id);
		System.out.println("passou");
        redirectAttributes.addFlashAttribute("message", "Funcionario alterado com sucesso!");
		return "redirect:/adm/funcionarios";
	}

    @GetMapping("/funcionarios/delete/{id}")
	public String deleteFuncionario(@PathVariable("id") int id){
		servico.delete(id);
		return "redirect:/adm/funcionarios";
	}

}
