package br.com.silva.app.rest;

import br.com.silva.app.rest.dto.AlbumDTO;
import br.com.silva.app.rest.vm.LancamentoVM;
import br.com.silva.app.service.ProducaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@Tag(name = "producao", description = "API de lançamentos de produtores, álbuns e músicas")
@RestController(value = "/producao")
public class ProducaoResource {

    private ProducaoService producaoService;

    @PostMapping(value = "/lancamento/novo-album", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AlbumDTO> lancarNovoAlbum(@RequestBody LancamentoVM lancamentoAlbum) {
        log.info("Requisição: Registrar lançamento de um novo álbum");
        return ResponseEntity.ok(producaoService.lancarNovoAlbum(lancamentoAlbum));
    }
}
