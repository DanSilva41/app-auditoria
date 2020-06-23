package br.com.silva.app.service.impl;

import br.com.silva.app.model.domain.Album;
import br.com.silva.app.model.domain.Musica;
import br.com.silva.app.model.domain.Produtor;
import br.com.silva.app.repository.AlbumRepository;
import br.com.silva.app.repository.MusicaRepository;
import br.com.silva.app.rest.dto.AlbumDTO;
import br.com.silva.app.rest.vm.LancamentoVM;
import br.com.silva.app.service.ColetaneaService;
import br.com.silva.app.service.ProducaoService;
import br.com.silva.app.service.mapper.AlbumMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
class ProducaoServiceImpl implements ProducaoService {

    private ColetaneaService coletaneaService;
    private AlbumRepository albumRepository;
    private MusicaRepository musicaRepository;

    private AlbumMapper albumMapper;

    @Override
    public AlbumDTO lancarNovoAlbum(LancamentoVM lancamentoAlbum) {
        Produtor produtor = coletaneaService.buscarProdutorPorID(lancamentoAlbum.getIdProdutor());
        List<Musica> musicas = coletaneaService.buscarMusicasPorID(lancamentoAlbum.getMusicas());

        Album album = Optional.ofNullable(lancamentoAlbum.getAlbum())
                .map(a -> Album.builder()
                        .id(a.getId())
                        .autor(a.getAutor())
                        .titulo(a.getTitulo())
                        .produtor(produtor)
                        .build()).orElse(null);

        album = albumRepository.save(album);
        atualizarMusicas(musicas, album);

        return albumMapper.paraDTO(album);
    }

    private void atualizarMusicas(List<Musica> musicas, Album album) {
        for (Musica m : musicas) {
            m.setAlbum(album);
        }

        musicaRepository.saveAll(musicas);
    }
}
