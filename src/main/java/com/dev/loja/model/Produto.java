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
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getLucro() {
        return lucro;
    }
    public void setLucro(double lucro) {
        this.lucro = lucro;
    }
    public int getEstoque() {
        return estoque;
    }
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    public List<String> getCores() {
        return cores;
    }
    public void setCores(List<String> cores) {
        this.cores = cores;
    }
    public List<String> getTamanhos() {
        return tamanhos;
    }
    public void setTamanhos(List<String> tamanhos) {
        this.tamanhos = tamanhos;
    }
    public List<Integer> getCategorias() {
        return categorias;
    }
    public void setCategorias(List<Integer> categorias) {
        this.categorias = categorias;
    }
    public int getModelo() {
        return modelo;
    }
    public void setModelo(int modelo) {
        this.modelo = modelo;
    }
    public String getImagem() {
        return imagem;
    }
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    
    
}
