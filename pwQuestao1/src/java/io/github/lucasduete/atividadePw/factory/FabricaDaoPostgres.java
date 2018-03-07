package io.github.lucasduete.atividadePw.factory;

import io.github.lucasduete.atividadePw.dao.ClienteDaoPostgres;
import io.github.lucasduete.atividadePw.dao.PedidoDaoPostgres;

public class FabricaDaoPostgres implements FabricaDaoInterface {

    @Override
    public ClienteDaoPostgres criarClienteDao() {
        return new ClienteDaoPostgres();
    }

    @Override
    public PedidoDaoPostgres criarPedidoDao() {
        return new PedidoDaoPostgres();
    }
}
