package io.github.lucasduete.atividadePw.factory;

import io.github.lucasduete.atividadePw.dao.PedidoDaoPostgres;
import io.github.lucasduete.atividadePw.dao.ClienteDaoPostgres;

public interface FabricaDaoInterface {

    public ClienteDaoPostgres criarClienteDao();
    public PedidoDaoPostgres criarPedidoDao();
}
