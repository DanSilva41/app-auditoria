package br.com.silva.app.service.impl;

import br.com.silva.app.rest.dto.AlbumDTO;
import br.com.silva.app.rest.vm.LancamentoVM;
import br.com.silva.app.service.ProducaoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class ProducaoServiceImpl implements ProducaoService {

    @Override
    public AlbumDTO lancarNovoAlbum(LancamentoVM lancamentoAlbum) {
        return AlbumDTO.builder().build();
    }
}
