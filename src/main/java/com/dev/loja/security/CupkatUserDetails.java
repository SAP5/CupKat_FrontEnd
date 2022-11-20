package com.dev.loja.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.dev.loja.model.Cliente;

public class CupkatUserDetails implements UserDetails {
	
	private Cliente cliente;

	public CupkatUserDetails(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		System.out.println(cliente.getSenha());
		return cliente.getSenha();
	}

	@Override
	public String getUsername() {
		return cliente.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		if (cliente.getStatus()==1) {
			return true;
		}
		return false;
	}
	
	public String getFullname() {
		return this.cliente.getNome();
	}

}
