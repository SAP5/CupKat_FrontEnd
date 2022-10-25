package com.dev.loja.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Modelo {
    private int id;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private int status = 1;
    @NotEmpty
    private String titulo;
    @NotNull
    private Double precoCusto;
    @NotEmpty
    private String descricao;

    public Modelo(String titulo, Double precoCusto, String descricao){
        this.titulo = titulo;
        this.precoCusto = precoCusto;
        this.descricao = descricao;
    }
    public Modelo(){}
}
