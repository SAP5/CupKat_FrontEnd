package com.dev.loja.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dev.loja.model.Categoria;

@Service
public class CategoriaI {
	public List<Categoria> obtemCategoria() { 
        String url = "https://cupkat-test.herokuapp.com/categorias/"; 
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/json");
        headers.set("Authorization", "authorizationHeader");
        
        HttpEntity requestEntity = new HttpEntity<>(null, headers);

        RestTemplate templ = new RestTemplate();
        ResponseEntity<List<Categoria>> resposta = templ.exchange(url,
            HttpMethod.GET,
            requestEntity,
            new ParameterizedTypeReference<List<Categoria>>() {
            });
        List<Categoria> categorias = resposta.getBody();
        System.out.println(categorias);
        return categorias;
	}
	public Categoria getById(int id){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://cupkat-test.herokuapp.com/categorias/by_id/{id}";   
        ResponseEntity<Categoria> result = restTemplate.getForEntity(url, Categoria.class, id);
        System.out.println(result);
        return result.getBody();
    }
}