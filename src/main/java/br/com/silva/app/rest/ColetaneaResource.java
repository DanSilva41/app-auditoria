package br.com.silva.app.rest;

import br.com.silva.app.rest.dto.AlbumDTO;
import br.com.silva.app.rest.dto.MusicaDTO;
import br.com.silva.app.rest.dto.ProdutorDTO;
import br.com.silva.app.service.ColetaneaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Tag(name = "coletanea", description = "API para busca de produtores, álbuns e músicas")
@RestController
@RequestMapping("/coletanea")
public class ColetaneaResource {

    private ColetaneaService coletaneaService;

    @GetMapping("/produtores")
    public ResponseEntity<List<ProdutorDTO>> buscarProdutores() {
        log.info("Requisição: Buscar todos os produtores");
        return ResponseEntity.ok(coletaneaService.buscarProdutores());
    }

    @GetMapping("/albuns")
    public ResponseEntity<List<AlbumDTO>> buscarAlbuns() {
        log.info("Requisição: Buscar todos os álbuns");
        return ResponseEntity.ok(coletaneaService.buscarAlbuns());
    }

    @GetMapping("/musicas")
    public ResponseEntity<List<MusicaDTO>> buscarMusicas() {
        log.info("Requisição: Buscar todas as músicas");
        return ResponseEntity.ok(coletaneaService.buscarMusicas());
    }
}
