package com.dev.loja.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class Categoria {
    private int id;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private int status = 1;

    @NotEmpty
    private String titulo;
    private String descricao;

    public Categoria(String titulo, String descricao){
        this.descricao = descricao;
        this.titulo = titulo;
    }
    public Categoria(){
    }
}
