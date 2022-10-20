package com.dev.loja.model;

import lombok.*;


@Data
public class Cliente{
    private int id;
    private int status = 1;
    private String nome;
    private String cpf;
    private String email;
    private String senha;

    public Cliente(String nome, String cpf, String email, String senha){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }
    public Cliente(){}
}