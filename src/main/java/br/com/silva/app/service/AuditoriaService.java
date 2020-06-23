package br.com.silva.app.service;

import br.com.silva.app.model.auditoria.AlbumAuditoria;
import br.com.silva.app.model.auditoria.MusicaAuditoria;
import br.com.silva.app.model.auditoria.ProdutorAuditoria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AuditoriaService {

    @Transactional(readOnly = true)
    List<ProdutorAuditoria> buscarAuditoriaProdutores();

    @Transactional(readOnly = true)
    List<AlbumAuditoria> buscarAuditoriaAlbuns();

    @Transactional(readOnly = true)
    List<MusicaAuditoria> buscarAuditoriaMusicas();
}
