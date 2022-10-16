package com.dev.loja.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.loja.model.Funcionario;
import com.dev.loja.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping
	public List<Funcionario> obterTodos() {
		return this.funcionarioService.obterTodos();
	}
	@GetMapping("/{codigo}")
	public Funcionario obterPorCodigo(@PathVariable String codigo) {
		return this.funcionarioService.obterPorCodigo(codigo);
	}
	@PostMapping
	public Funcionario criar(@RequestBody Funcionario funcionario) {
		return this.funcionarioService.criar(funcionario);
	}
}
