package br.com.silva.app.service.impl;

import br.com.silva.app.repository.AlbumRepository;
import br.com.silva.app.repository.MusicaRepository;
import br.com.silva.app.repository.ProdutorRepository;
import br.com.silva.app.rest.dto.AlbumDTO;
import br.com.silva.app.rest.dto.MusicaDTO;
import br.com.silva.app.rest.dto.ProdutorDTO;
import br.com.silva.app.service.ColetaneaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
class ColetaneaServiceImpl implements ColetaneaService {

    private ProdutorRepository produtorRepository;
    private AlbumRepository albumRepository;
    private MusicaRepository musicaRepository;

    @Override
    public List<ProdutorDTO> buscarProdutores() {
        return null;
    }

    @Override
    public List<AlbumDTO> buscarAlbuns() {
        return null;
    }

    @Override
    public List<MusicaDTO> buscarMusicas() {
        return null;
    }
}
