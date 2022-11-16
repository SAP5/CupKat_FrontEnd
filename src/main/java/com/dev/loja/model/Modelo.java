package com.dev.loja.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

public class Modelo {

	private int id;

	private LocalDateTime created_at;

	private LocalDateTime updated_at;

	private int status = 1;
	
	@NotBlank(message = "Título é requerido")
	private String titulo;
	
	@NotNull(message = "Custo é requerido")
	@Digits(integer=3,fraction=2,message="Apenas centenas e 2 casas após o ponto.")
	private BigDecimal precoCusto;
	
	@NotBlank(message = "Descrição é requerido")
	private String descricao;

	public Modelo(){}

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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public BigDecimal getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(BigDecimal precoCusto) {
		this.precoCusto = precoCusto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	
	
	
	
}
