package com.dev.loja.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dev.loja.model.Tamanho;

@Service
public class TamanhoI {
	public List<Tamanho> obtemTamanhos() { 
        String url = "https://cupkat-test.herokuapp.com/tamanhos/"; 
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/json");
        headers.set("Authorization", "authorizationHeader");
        
        HttpEntity requestEntity = new HttpEntity<>(null, headers);

        RestTemplate templ = new RestTemplate();
        ResponseEntity<List<Tamanho>> resposta = templ.exchange(url,
            HttpMethod.GET,
            requestEntity,
            new ParameterizedTypeReference<List<Tamanho>>() {
            });
        List<Tamanho> tamanhos = resposta.getBody();
        return tamanhos;
	}
	
	public Tamanho getById(int id){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://cupkat-test.herokuapp.com/tamanhos/{id}";
        ResponseEntity<Tamanho> result = restTemplate.getForEntity(url, Tamanho.class, id);
        System.out.println(result);
        return result.getBody();
    }
}
