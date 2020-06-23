package br.com.silva.app.model.auditoria;

import br.com.silva.app.model.domain.Musica;
import br.com.silva.app.support.auditoria.AuditQueryResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.envers.RevisionType;

@Getter
@AllArgsConstructor
public class MusicaAuditoria {

    private final Musica musica;
    private final Number numeroRevisao;
    private final RevisionType tipoRevisao;

    public static MusicaAuditoria getMusicaAuditoria(AuditQueryResult<Musica> auditQueryResult) {
        return new MusicaAuditoria(
                auditQueryResult.getEntidade(),
                auditQueryResult.getRevisao().getId(),
                auditQueryResult.getTipo()
        );
    }
}
