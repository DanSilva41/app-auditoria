package br.com.silva.app.service;

import br.com.silva.app.rest.dto.AlbumDTO;
import br.com.silva.app.rest.vm.LancamentoVM;

public interface ProducaoService {

    AlbumDTO lancarNovoAlbum(LancamentoVM lancamentoAlbum);
}
