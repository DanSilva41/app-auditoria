package br.com.silva.app.model.auditoria;

public enum TipoRevisaoEnum {

    ADD("Inserção"),
    MOD("Atualização"),
    DEL("Deleção");

    private final String descricao;

    TipoRevisaoEnum(String descricao) {
        this.descricao = descricao;
    }

    public static TipoRevisaoEnum getTipoRevisao(Number valor) {
        for (TipoRevisaoEnum tipoRevisao : TipoRevisaoEnum.values()) {
            if (tipoRevisao.ordinal() == valor.intValue()) {
                return tipoRevisao;
            }
        }
        return null;
    }

}
