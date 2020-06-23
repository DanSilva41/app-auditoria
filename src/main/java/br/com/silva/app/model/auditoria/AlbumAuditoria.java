package br.com.silva.app.model.auditoria;

import br.com.silva.app.model.domain.Album;
import br.com.silva.app.model.seguranca.Usuario;
import br.com.silva.app.support.auditoria.AuditQueryResult;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AlbumAuditoria {

    private final Album album;
    private final Number numeroRevisao;
    private final TipoRevisaoEnum tipoRevisao;
    private final Usuario usuarioResponsavel;

    public static AlbumAuditoria getAlbumAuditoria(AuditQueryResult<Album> auditQueryResult) {
        return new AlbumAuditoria(
                auditQueryResult.getEntidade(),
                auditQueryResult.getRevisao().getId(),
                TipoRevisaoEnum.getTipoRevisao(auditQueryResult.getTipo().ordinal()),
                auditQueryResult.getRevisao().getUsuarioResponsavel()
        );
    }
}
