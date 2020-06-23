package br.com.silva.app.model.auditoria;

import br.com.silva.app.model.domain.Album;
import br.com.silva.app.support.auditoria.AuditQueryResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.envers.RevisionType;

@Getter
@AllArgsConstructor
public class AlbumAuditoria {

    private final Album album;
    private final Number numeroRevisao;
    private final RevisionType tipoRevisao;

    public static AlbumAuditoria getAlbumAuditoria(AuditQueryResult<Album> auditQueryResult) {
        return new AlbumAuditoria(
                auditQueryResult.getEntidade(),
                auditQueryResult.getRevisao().getId(),
                auditQueryResult.getTipo()
        );
    }
}
