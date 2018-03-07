package io.github.lucasduete.atividadePw.interfaces;

import io.github.lucasduete.atividadePw.model.Cliente;

import java.util.ArrayList;

public interface ClienteDaoInterface {

    public boolean incluir(Cliente cliente);
    public boolean alterar(Cliente cliente);
    public boolean excluir(Cliente cliente);
    public ArrayList<Cliente> listar();

}
