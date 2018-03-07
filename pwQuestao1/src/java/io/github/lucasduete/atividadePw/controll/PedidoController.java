package io.github.lucasduete.atividadePw.controll;

import io.github.lucasduete.atividadePw.factory.Fabrica;
import io.github.lucasduete.atividadePw.interfaces.PedidoDaoInterface;
import io.github.lucasduete.atividadePw.model.Pedido;

import java.util.ArrayList;

public class PedidoController implements PedidoDaoInterface {

    PedidoDaoInterface pedidoDao;

    public PedidoController() {
        pedidoDao = new Fabrica().criarDaoPostgres().criarPedidoDao();
    }

    @Override
    public boolean incluir(Pedido pedido) {

        return pedidoDao.incluir(pedido);
    }

    @Override
    public boolean alterar(Pedido pedido) {

        return pedidoDao.alterar(pedido);
    }

    @Override
    public boolean excluir(Pedido pedido) {

        return pedidoDao.excluir(pedido);
    }

    @Override
    public ArrayList<Pedido> listar(int idCliente) {

        return pedidoDao.listar(idCliente);
    }
}
