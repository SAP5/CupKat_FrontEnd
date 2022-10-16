package com.dev.loja.service;

import com.dev.loja.model.Funcionario;
import java.util.List;

public interface FuncionarioService {
	public List<Funcionario> obterTodos();
	
	public Funcionario obterPorCodigo(String codigo);
	
	public Funcionario criar(Funcionario funcionario);
	
}
