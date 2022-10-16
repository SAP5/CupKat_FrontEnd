package com.dev.loja.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dev.loja.model.Funcionario;

public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {

}
