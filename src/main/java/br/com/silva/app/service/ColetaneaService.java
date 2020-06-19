package br.com.silva.app.service;

import br.com.silva.app.rest.dto.AlbumDTO;
import br.com.silva.app.rest.dto.MusicaDTO;
import br.com.silva.app.rest.dto.ProdutorDTO;

import java.util.List;

public interface ColetaneaService {

    List<ProdutorDTO> buscarProdutores();

    List<AlbumDTO> buscarAlbuns();

    List<MusicaDTO> buscarMusicas();
}
