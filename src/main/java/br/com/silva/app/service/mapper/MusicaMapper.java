package br.com.silva.app.service.mapper;

import br.com.silva.app.domain.Musica;
import br.com.silva.app.rest.dto.MusicaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MusicaMapper extends AbstractMapper<Musica, MusicaDTO> {
}
