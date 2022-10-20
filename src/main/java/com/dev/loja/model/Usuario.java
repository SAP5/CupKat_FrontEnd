package com.dev.loja.model;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class Usuario extends Model{
    @NotEmpty(message = "o nome não pode ser vazio")
    private String nome;
    @NotEmpty(message = "o email não pode ser vazio")
    @Email
    private String email;
    @NotEmpty(message = "A senha não pode estar vazia")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$*&@#])(?:([0-9a-zA-Z$*&@#])(?!\\1)){8,}$", message = "A senha é muito fraca")
    private String senha;
}