package com.dev.loja.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Produto {

	private int id;

	private LocalDateTime created_at;

	private LocalDateTime updated_at;

	private int status = 1;

	@NotBlank(message = "Nome é requerido")
	private String nome;
	
	private String descricao;
	
	@NotNull(message = "Lucro é requerido")
	@Digits(integer=3,fraction=2,message="Apenas centenas e 2 casas após o ponto.")
	private BigDecimal lucro;
	
	@NotNull(message = "Estoque é requerido")
	private Integer estoque;

	private String imagem;
	
	@NotEmpty(message = "Nenhuma cor selecionada")
	private List<Integer> cores;
	
	@NotEmpty(message = "Nenhum tamanho selecionado")
	private List<Integer> tamanhos;
	
	@NotEmpty(message = "Nenhuma categoria selecionada")
	private List<Integer> categorias;
	
	@NotNull(message = "Modelo é requerido")
	private Integer modelo;

	public Produto() {

	}

	public List<Integer> getCores() {
		return cores;
	}

	public void setCores(List<Integer> cores) {
		this.cores = cores;
	}

	public List<Integer> getTamanhos() {
		return tamanhos;
	}

	public void setTamanhos(List<Integer> tamanhos) {
		this.tamanhos = tamanhos;
	}

	public List<Integer> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Integer> categorias) {
		this.categorias = categorias;
	}

	public Integer getModelo() {
		return modelo;
	}

	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
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

	public BigDecimal getLucro() {
		return lucro;
	}

	public void setLucro(BigDecimal lucro) {
		this.lucro = lucro;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

}
