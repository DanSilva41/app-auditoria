package br.com.silva.app.service;

import br.com.silva.app.rest.dto.UsuarioDTO;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    Optional<UsuarioDTO> buscarPorUsername(final String username);

    List<UsuarioDTO> buscarTodos();

}
