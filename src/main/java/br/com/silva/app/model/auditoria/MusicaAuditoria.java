package br.com.silva.app.model.auditoria;

import br.com.silva.app.model.domain.Musica;
import br.com.silva.app.model.seguranca.Usuario;
import br.com.silva.app.support.auditoria.AuditQueryResult;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MusicaAuditoria {

    private final Musica musica;
    private final Number numeroRevisao;
    private final TipoRevisaoEnum tipoRevisao;
    private final Usuario usuarioResponsavel;

    public static MusicaAuditoria getMusicaAuditoria(AuditQueryResult<Musica> auditQueryResult) {
        return new MusicaAuditoria(
                auditQueryResult.getEntidade(),
                auditQueryResult.getRevisao().getId(),
                TipoRevisaoEnum.getTipoRevisao(auditQueryResult.getTipo().ordinal()),
                auditQueryResult.getRevisao().getUsuarioResponsavel()
        );
    }
}
