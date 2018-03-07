package io.github.lucasduete.atividadePw.Enum;

public enum EnumAtivo {

    ATIVO("Ativo"), INATIVO("Inativo");

    private String status;

    EnumAtivo(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
