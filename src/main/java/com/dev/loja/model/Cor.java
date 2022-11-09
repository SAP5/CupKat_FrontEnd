package com.dev.loja.model;


public class Cor {
    private int id;
    
    private String nome;
    
    private String cor;
    
    
    public Cor(String nome) {
        this.nome = nome;
    }
    
    public Cor() {
    	
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
    
    
}
