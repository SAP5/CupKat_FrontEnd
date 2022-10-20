package com.dev.loja.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import com.dev.loja.model.Cliente;

import nonapi.io.github.classgraph.utils.Assert;

@Service
public class ClienteI {

    public List<Cliente> obtemClientes() { 
        String url = "https://cupkat-prj.herokuapp.com/clientes/"; 
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/json");
        headers.set("Authorization", "authorizationHeader");
        
        HttpEntity requestEntity = new HttpEntity<>(null, headers);

        RestTemplate templ = new RestTemplate();
        ResponseEntity<List<Cliente>> resposta = templ.exchange(url,
            HttpMethod.GET,
            requestEntity,
            new ParameterizedTypeReference<List<Cliente>>() {
            });
        List<Cliente> clientes = resposta.getBody();
        return clientes;
    }

    public void save(Cliente cliente){
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://cupkat-prj.herokuapp.com/clientes";

        ResponseEntity<String> result = restTemplate.postForEntity(url, cliente, String.class);

        System.out.println(result);
	}

    public void delete(String id){
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://cupkat-prj.herokuapp.com/clientes/delete/{id}";

        restTemplate.delete(url, id, String.class);
    }

}