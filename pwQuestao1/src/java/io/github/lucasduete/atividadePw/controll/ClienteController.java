package io.github.lucasduete.atividadePw.controll;

import io.github.lucasduete.atividadePw.factory.Fabrica;
import io.github.lucasduete.atividadePw.interfaces.ClienteDaoInterface;
import io.github.lucasduete.atividadePw.model.Cliente;

import java.util.ArrayList;

public class ClienteController implements ClienteDaoInterface {

    ClienteDaoInterface clienteDao;

    public ClienteController() {
        clienteDao = new Fabrica().criarDaoPostgres().criarClienteDao();
    }

    @Override
    public boolean incluir(Cliente cliente) {

        return clienteDao.incluir(cliente);
    }

    @Override
    public boolean alterar(Cliente cliente) {

        return clienteDao.alterar(cliente);
    }

    @Override
    public boolean excluir(Cliente cliente) {

        return clienteDao.excluir(cliente);
    }

    @Override
    public ArrayList<Cliente> listar() {

        return clienteDao.listar();
    }
}
