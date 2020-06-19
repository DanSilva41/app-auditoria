package br.com.silva.app.service.impl;

import br.com.silva.app.repository.UsuarioRepository;
import br.com.silva.app.rest.dto.UsuarioDTO;
import br.com.silva.app.service.UsuarioService;
import br.com.silva.app.service.mapper.UsuarioMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;
    private UsuarioMapper usuarioMapper;

    @Override
    public Optional<UsuarioDTO> buscarPorUsername(String username) {
        return Optional.ofNullable(usuarioMapper.paraDTO(usuarioRepository.findByUsername(username)));
    }

    @Override
    public List<UsuarioDTO> buscarTodos() {
        return usuarioMapper.paraListaDTO(usuarioRepository.findAll());
    }
}
