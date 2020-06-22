package br.com.silva.app.service.impl;

import br.com.silva.app.repository.AlbumRepository;
import br.com.silva.app.repository.MusicaRepository;
import br.com.silva.app.repository.ProdutorRepository;
import br.com.silva.app.rest.dto.AlbumDTO;
import br.com.silva.app.rest.dto.MusicaDTO;
import br.com.silva.app.rest.dto.ProdutorDTO;
import br.com.silva.app.service.ColetaneaService;
import br.com.silva.app.service.mapper.AlbumMapper;
import br.com.silva.app.service.mapper.MusicaMapper;
import br.com.silva.app.service.mapper.ProdutorMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
class ColetaneaServiceImpl implements ColetaneaService {

    private ProdutorRepository produtorRepository;
    private AlbumRepository albumRepository;
    private MusicaRepository musicaRepository;

    private ProdutorMapper produtorMapper;
    private AlbumMapper albumMapper;
    private MusicaMapper musicaMapper;

    @Override
    public List<ProdutorDTO> buscarProdutores() {
        return produtorMapper.paraListaDTO(produtorRepository.findAll());
    }

    @Override
    public List<AlbumDTO> buscarAlbuns() {
        return albumMapper.paraListaDTO(albumRepository.findAll());
    }

    @Override
    public List<MusicaDTO> buscarMusicas() {
        return musicaMapper.paraListaDTO(musicaRepository.findAll());
    }
}
