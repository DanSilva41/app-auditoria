package br.com.silva.app.service;

import br.com.silva.app.rest.dto.AlbumDTO;
import br.com.silva.app.rest.vm.LancamentoVM;
import org.springframework.transaction.annotation.Transactional;

public interface ProducaoService {

    @Transactional
    AlbumDTO lancarNovoAlbum(LancamentoVM lancamentoAlbum);
}
