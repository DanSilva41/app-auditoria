package br.com.silva.app.rest;

import br.com.silva.app.model.auditoria.AlbumAuditoria;
import br.com.silva.app.model.auditoria.MusicaAuditoria;
import br.com.silva.app.model.auditoria.ProdutorAuditoria;
import br.com.silva.app.service.AuditoriaService;
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
@Tag(name = "auditoria", description = "API para busca de informações de auditoria")
@RestController
@RequestMapping("/auditoria")
public class AuditoriaResource {

    private AuditoriaService auditoriaService;

    @GetMapping("/produtores")
    public ResponseEntity<List<ProdutorAuditoria>> buscarAuditoriaProdutores() {
        log.info("Requisição: Buscar informações de auditoria todos os produtores");
        return ResponseEntity.ok(auditoriaService.buscarAuditoriaProdutores());
    }

    @GetMapping("/albuns")
    public ResponseEntity<List<AlbumAuditoria>> buscarAuditoriaAlbuns() {
        log.info("Requisição: Buscar informações de auditoria todos os álbuns");
        return ResponseEntity.ok(auditoriaService.buscarAuditoriaAlbuns());
    }

    @GetMapping("/musicas")
    public ResponseEntity<List<MusicaAuditoria>> buscarAuditoriaMusicas() {
        log.info("Requisição: Buscar informações de auditoria todas as músicas");
        return ResponseEntity.ok(auditoriaService.buscarAuditoriaMusicas());
    }
}
