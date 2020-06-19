package br.com.silva.app.service.mapper;

import br.com.silva.app.domain.Album;
import br.com.silva.app.rest.dto.AlbumDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlbumMapper extends AbstractMapper<Album, AlbumDTO> {
}
