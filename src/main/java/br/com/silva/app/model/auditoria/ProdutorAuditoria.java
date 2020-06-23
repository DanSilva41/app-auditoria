package br.com.silva.app.model.auditoria;

import br.com.silva.app.model.domain.Produtor;
import br.com.silva.app.model.seguranca.Usuario;
import br.com.silva.app.support.auditoria.AuditQueryResult;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProdutorAuditoria {

    private final Produtor produtor;
    private final Number numeroRevisao;
    private final TipoRevisaoEnum tipoRevisao;
    private final Usuario usuarioResponsavel;

    public static ProdutorAuditoria getProdutorAuditoria(AuditQueryResult<Produtor> auditQueryResult) {
        return new ProdutorAuditoria(
                auditQueryResult.getEntidade(),
                auditQueryResult.getRevisao().getId(),
                TipoRevisaoEnum.getTipoRevisao(auditQueryResult.getTipo().ordinal()),
                auditQueryResult.getRevisao().getUsuarioResponsavel()
        );
    }

}
