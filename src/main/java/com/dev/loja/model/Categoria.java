package com.dev.loja.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

public class Categoria {

	private Integer id;

	private LocalDateTime created_at;

	private LocalDateTime updated_at;

	private int status = 1;
	
	@NotBlank(message = "Título é requerido")
	private String titulo;
	@NotBlank(message = "Descrição é requerida")
	private String descricao;
		
	public Categoria() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
