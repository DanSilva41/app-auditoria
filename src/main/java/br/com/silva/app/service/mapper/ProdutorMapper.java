package br.com.silva.app.service.mapper;

import br.com.silva.app.domain.Produtor;
import br.com.silva.app.rest.dto.ProdutorDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdutorMapper extends AbstractMapper<Produtor, ProdutorDTO> {
}
