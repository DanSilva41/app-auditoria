package br.com.silva.app.model.auditoria;

import br.com.silva.app.model.domain.Produtor;
import br.com.silva.app.support.auditoria.AuditQueryResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.envers.RevisionType;

@Getter
@AllArgsConstructor
public class ProdutorAuditoria {

    private final Produtor produtor;
    private final Number numeroRevisao;
    private final RevisionType tipoRevisao;

    public static ProdutorAuditoria getProdutorAuditoria(AuditQueryResult<Produtor> auditQueryResult) {
        return new ProdutorAuditoria(
                auditQueryResult.getEntidade(),
                auditQueryResult.getRevisao().getId(),
                auditQueryResult.getTipo()
        );
    }

}
