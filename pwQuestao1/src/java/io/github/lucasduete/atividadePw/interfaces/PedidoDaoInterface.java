package io.github.lucasduete.atividadePw.interfaces;

import io.github.lucasduete.atividadePw.model.Pedido;

import java.util.ArrayList;

public interface PedidoDaoInterface {

    public boolean incluir(Pedido pedido);
    public boolean alterar(Pedido pedido);
    public boolean excluir(Pedido pedido);
    public ArrayList<Pedido> listar(int idCliente);
}
