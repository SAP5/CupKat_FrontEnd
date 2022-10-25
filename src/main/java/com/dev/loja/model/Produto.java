package com.dev.loja.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.Data;

@Data
public class Produto {
    private int id;
    private int status;
    @NotEmpty
    private String nome;
    @NotEmpty
    private String descricao;
    @NotNull
    private double lucro;
    @PositiveOrZero
    private int estoque;
    @NotEmpty
    private List<String> cores;
    @NotEmpty
    private List<String> tamanhos;
    @NotEmpty
    private List<Integer> categorias;
    @NotNull
    private int modelo;
    private String imagem;

    
}
