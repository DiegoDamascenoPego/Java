package com.liveworking.api.produtos.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.liveworking.api.produtos.model.Permissao;
import com.liveworking.api.produtos.model.Usuario;
import com.liveworking.api.produtos.repository.UsuarioRepository;

@Component
public class AppUserDetailService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(email);

		Usuario usuario = usuarioOptional.orElseThrow(() -> new UsernameNotFoundException("usuário incorreto"));

		return new User(email, usuario.getSenha(), getPermissoes(usuario));

	}

	private Collection<? extends GrantedAuthority> getPermissoes(Usuario usuario) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();

		for (Permissao permissao : usuario.getPermissoes()) {

			authorities.add(new SimpleGrantedAuthority(permissao.getDescricao().toUpperCase()));

		}

		return authorities;
	}

}
