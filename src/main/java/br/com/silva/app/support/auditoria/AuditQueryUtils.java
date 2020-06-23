package br.com.silva.app.support.auditoria;

import org.hibernate.envers.query.AuditQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AuditQueryUtils {

    private AuditQueryUtils() {
    }

    public static <TTargetType> List<AuditQueryResult<TTargetType>> getAuditQueryResults(AuditQuery query, Class<TTargetType> targetType) {

        List<?> results = query.getResultList();

        if (results == null) {
            return new ArrayList<>();
        }

        // O AuditReader retorna uma lista de objetos [], onde os índices são:
        //
        // 0 - A entidade consultada
        // 1 - A entidade de revisão
        // 2 - O tipo de revisão
        //
        // Nós o convertemos em algo útil para um acesso seguro:
        return results.stream()
                // Use apenas os resultados do Object []:
                .filter(x -> x instanceof Object[])
                // Depois converta para Object []:
                .map(x -> (Object[]) x)
                // Transforme em AuditQueryResult:
                .map(x -> AuditQueryResultUtils.getAuditQueryResult(x, targetType))
                // E colete os resultados em uma lista:
                .collect(Collectors.toList());
    }
}
