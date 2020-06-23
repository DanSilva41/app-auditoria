package br.com.silva.app.model.auditoria;

public enum TipoRevisaoEnum {

    ADD,
    MOD,
    DEL;

    public static TipoRevisaoEnum getTipoRevisao(Number valor) {
        for (TipoRevisaoEnum tipoRevisao : TipoRevisaoEnum.values()) {
            if (tipoRevisao.ordinal() == valor.intValue()) {
                return tipoRevisao;
            }
        }
        return null;
    }

}
