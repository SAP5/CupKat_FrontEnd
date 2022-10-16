package com.dev.loja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.loja.model.Funcionario;
import com.dev.loja.repository.FuncionarioRepository;
import com.dev.loja.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Override
	public List<Funcionario> obterTodos() {
		// TODO Auto-generated method stub
		return this.funcionarioRepository.findAll();
	}

	@Override
	public Funcionario obterPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.funcionarioRepository
				.findById(codigo)
				.orElseThrow(() -> new IllegalArgumentException("Funcionário não existe."));
	}

	@Override
	public Funcionario criar(Funcionario funcionario) {
		// TODO Auto-generated method stub
		
		return this.funcionarioRepository.save(funcionario);
	}

}
