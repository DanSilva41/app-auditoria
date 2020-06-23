package br.com.silva.app.service;

import br.com.silva.app.model.domain.Musica;
import br.com.silva.app.model.domain.Produtor;
import br.com.silva.app.rest.dto.AlbumDTO;
import br.com.silva.app.rest.dto.MusicaDTO;
import br.com.silva.app.rest.dto.ProdutorDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ColetaneaService {

    @Transactional(readOnly = true)
    List<ProdutorDTO> buscarProdutores();

    @Transactional(readOnly = true)
    List<AlbumDTO> buscarAlbuns();

    @Transactional(readOnly = true)
    List<MusicaDTO> buscarMusicas();

    @Transactional(readOnly = true)
    List<Musica> buscarMusicasPorID(List<Integer> idMusicas);

    @Transactional(readOnly = true)
    Produtor buscarProdutorPorID(Integer idProdutor);
}
