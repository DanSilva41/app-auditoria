package br.com.silva.app.support.auditoria;

import br.com.silva.app.model.auditoria.EntidadeAuditada;
import org.hibernate.envers.RevisionType;

public class AuditQueryResultUtils {

    private AuditQueryResultUtils() {
    }

    public static <TTargetType> AuditQueryResult<TTargetType> getAuditQueryResult(Object[] item, Class<TTargetType> tipo) {

        // Saída antecipada, se nenhum item for fornecido:
        if (item == null) {
            return null;
        }

        // Saída antecipada, se não houver dados suficientes:
        if (item.length < 3) {
            return null;
        }

        // Cast item [0] para a Entidade:
        TTargetType entidade = null;
        if (tipo.isInstance(item[0])) {
            entidade = tipo.cast(item[0]);
        }

        // Em seguida, obtenha a entidade de revisão:
        EntidadeAuditada revisao = null;
        if (item[1] instanceof EntidadeAuditada) {
            revisao = (EntidadeAuditada) item[1];
        }

        // Em seguida, obtenha o tipo de revisão:
        RevisionType tipoRevisao = null;
        if (item[2] instanceof RevisionType) {
            tipoRevisao = (RevisionType) item[2];
        }

        // Crie o resultado da consulta:
        return new AuditQueryResult<TTargetType>(entidade, revisao, tipoRevisao);
    }
}
