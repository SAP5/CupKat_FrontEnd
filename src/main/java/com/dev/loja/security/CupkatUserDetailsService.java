package com.dev.loja.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dev.loja.model.Cliente;
import com.dev.loja.service.ClienteI;

public class CupkatUserDetailsService implements UserDetailsService {
	
	@Autowired
	private ClienteI cliRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Cliente cliente = cliRepo.getByEmail(email);
		
		if(cliente != null) {
			return new CupkatUserDetails(cliente);
		}
		
		throw new UsernameNotFoundException("Não foi encontrado usuário com esse email: " + email);
		
	}

}
