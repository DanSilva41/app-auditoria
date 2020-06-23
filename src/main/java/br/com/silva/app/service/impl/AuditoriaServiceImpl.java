package br.com.silva.app.service.impl;

import br.com.silva.app.model.auditoria.AlbumAuditoria;
import br.com.silva.app.model.auditoria.MusicaAuditoria;
import br.com.silva.app.model.auditoria.ProdutorAuditoria;
import br.com.silva.app.model.domain.Album;
import br.com.silva.app.model.domain.Musica;
import br.com.silva.app.model.domain.Produtor;
import br.com.silva.app.service.AuditoriaService;
import br.com.silva.app.support.auditoria.AuditQueryUtils;
import lombok.AllArgsConstructor;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
class AuditoriaServiceImpl implements AuditoriaService {

    private EntityManager entityManager;

    @Override
    public List<ProdutorAuditoria> buscarAuditoriaProdutores() {
        AuditReader auditReader = this.criarLeitorAuditoria();

        AuditQuery auditQuery = auditReader.createQuery()
                .forRevisionsOfEntity(Produtor.class, false, false);

        return AuditQueryUtils.getAuditQueryResults(auditQuery, Produtor.class).stream()
                .map(ProdutorAuditoria::getProdutorAuditoria)
                .collect(Collectors.toList());
    }

    @Override
    public List<AlbumAuditoria> buscarAuditoriaAlbuns() {
        AuditReader auditReader = this.criarLeitorAuditoria();

        AuditQuery auditQuery = auditReader.createQuery()
                .forRevisionsOfEntity(Album.class, false, false);

        return AuditQueryUtils.getAuditQueryResults(auditQuery, Album.class).stream()
                .map(AlbumAuditoria::getAlbumAuditoria)
                .collect(Collectors.toList());
    }

    @Override
    public List<MusicaAuditoria> buscarAuditoriaMusicas() {
        AuditReader auditReader = this.criarLeitorAuditoria();

        AuditQuery auditQuery = auditReader.createQuery()
                .forRevisionsOfEntity(Musica.class, false, false);

        return AuditQueryUtils.getAuditQueryResults(auditQuery, Musica.class).stream()
                .map(MusicaAuditoria::getMusicaAuditoria)
                .collect(Collectors.toList());
    }

    /**
     * Crie o leitor de auditoria. Ele usa o EntityManager, que será aberto quando
     * Inicia a nova transação e fecha quando a transação termina.
     *
     * @return AuditReader
     */
    private AuditReader criarLeitorAuditoria() {
        return AuditReaderFactory.get(entityManager);
    }
}
