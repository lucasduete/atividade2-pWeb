package io.github.lucasduete.atividadePw.factory;

public class Fabrica {

    public static FabricaDaoPostgres criarDaoPostgres() {
        return new FabricaDaoPostgres();
    }
}
