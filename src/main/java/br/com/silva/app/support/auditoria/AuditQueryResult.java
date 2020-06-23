package br.com.silva.app.support.auditoria;

import br.com.silva.app.model.auditoria.EntidadeAuditada;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.envers.RevisionType;

@Getter
@AllArgsConstructor
public class AuditQueryResult<T> {

    private final T entidade;
    private final EntidadeAuditada revisao;
    private final RevisionType tipo;
}
