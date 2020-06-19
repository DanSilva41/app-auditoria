package br.com.silva.app.security;

import br.com.silva.app.rest.dto.UsuarioDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UsuarioSistema extends User {

    private static final long serialVersionUID = 1L;

    private UsuarioDTO usuario;

    UsuarioSistema(UsuarioDTO usuario, Collection<? extends GrantedAuthority> authorities) {
        super(usuario.getUsername(), usuario.getSenha(), authorities);
        this.usuario = usuario;
    }

    public UsuarioDTO getUsuario() {
        return usuario;

    }
}
