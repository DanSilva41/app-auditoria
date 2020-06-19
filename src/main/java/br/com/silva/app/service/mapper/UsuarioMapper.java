package br.com.silva.app.service.mapper;

import br.com.silva.app.model.seguranca.Usuario;
import br.com.silva.app.rest.dto.UsuarioDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper extends AbstractMapper<Usuario, UsuarioDTO> {
}
