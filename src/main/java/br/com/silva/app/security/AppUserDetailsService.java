package br.com.silva.app.security;

import br.com.silva.app.rest.dto.UsuarioDTO;
import br.com.silva.app.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@AllArgsConstructor
@Service
public class AppUserDetailsService implements UserDetailsService {

    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UsuarioDTO usuario = usuarioService.buscarPorUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuario e/ou senha incorretos"));
        return new UsuarioSistema(usuario, new HashSet<SimpleGrantedAuthority>());
    }
}

