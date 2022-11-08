package com.dev.loja.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import com.dev.loja.model.Funcionario;

@Service
public class FuncionarioI {

    public List<Funcionario> obtemFuncionarios() { 
        String url = "https://cupkat-test.herokuapp.com/funcionarios/"; 
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/json");
        headers.set("Authorization", "authorizationHeader");
        
        HttpEntity requestEntity = new HttpEntity<>(null, headers);

        RestTemplate templ = new RestTemplate();
        ResponseEntity<List<Funcionario>> resposta = templ.exchange(url,
            HttpMethod.GET,
            requestEntity,
            new ParameterizedTypeReference<List<Funcionario>>() {
            });
        List<Funcionario> funcionarios = resposta.getBody();
        return funcionarios;
    }

    public void save(Funcionario funcionario){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://cupkat-test.herokuapp.com/funcionarios";
        ResponseEntity<String> result = restTemplate.postForEntity(url, funcionario, String.class);
        System.out.println(result);
	}

    public void delete(int id){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://cupkat-test.herokuapp.com/funcionarios/delete/{id}";
        restTemplate.delete(url, id, String.class);
    }

    public void update(Funcionario funcionario, int id){
        RestTemplate restTemplate = new RestTemplate();
        funcionario.setId(id);
        String url = "https://cupkat-test.herokuapp.com/funcionarios/update/{id}";
        restTemplate.put(url, funcionario, funcionario.getId());
	}

    public Funcionario getById(int id){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://cupkat-test.herokuapp.com/funcionarios/by_id/{id}";
        ResponseEntity<Funcionario> result = restTemplate.getForEntity(url, Funcionario.class, id);
        return result.getBody();
    }
}
