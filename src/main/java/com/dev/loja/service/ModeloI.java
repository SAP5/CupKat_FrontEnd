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
import com.dev.loja.model.Modelo;

@Service
public class ModeloI {
	public List<Modelo> obtemModelos() { 
        String url = "https://cupkat-test.herokuapp.com/modelos/"; 
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/json");
        headers.set("Authorization", "authorizationHeader");
        
        HttpEntity requestEntity = new HttpEntity<>(null, headers);

        RestTemplate templ = new RestTemplate();
        ResponseEntity<List<Modelo>> resposta = templ.exchange(url,
            HttpMethod.GET,
            requestEntity,
            new ParameterizedTypeReference<List<Modelo>>() {
            });
        List<Modelo> modelos = resposta.getBody();
        System.out.println(modelos);
        return modelos;
	}
	
	public Modelo getById(int id){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://cupkat-test.herokuapp.com/modelos/by_id/{id}";   
        ResponseEntity<Modelo> result = restTemplate.getForEntity(url, Modelo.class, id);
        System.out.println(result.getBody().getTitulo());
        return result.getBody();
    }
	
	public void save(Modelo modelo){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://cupkat-test.herokuapp.com/modelos";
        ResponseEntity<String> result = restTemplate.postForEntity(url, modelo, String.class);
        System.out.println(result.getBody());
	}
	
	 public void update(Modelo modelo, int id){
	        RestTemplate restTemplate = new RestTemplate();
	        modelo.setId(id);
	        String url = "https://cupkat-dev.herokuapp.com/modelos/update/{id}";
	        restTemplate.put(url, modelo, modelo.getId());
	}
	
	 public void delete(int id){
	        RestTemplate restTemplate = new RestTemplate();
	        String url = "https://cupkat-test.herokuapp.com/modelos/delete/{id}";
	        restTemplate.delete(url, id, String.class);
	 }
	
	
}
