package io.github.lucasduete.atividadePw.controller;

import io.github.lucasduete.atividadePw.Enum.EnumAtivo;
import io.github.lucasduete.atividadePw.controll.commandIF.Command;
import io.github.lucasduete.atividadePw.controll.commandImp.*;
import io.github.lucasduete.atividadePw.model.Cliente;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nomeCliente = request.getParameter("nomeCliente");
        String nomePedido = request.getParameter("nomePedido");
        
        if (nomeCliente == null) {
            Command buscaCliente = new BuscaCliente();
            
            buscaCliente.execute(request, response);            
        } else if (nomePedido == null) {
            
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Envie os Dados Necessários");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Date data = Date.valueOf(request.getParameter("data"));
        
        String nome = request.getParameter("nome");
        String documento = request.getParameter("documento");
        Double saldo = Double.parseDouble(request.getParameter("saldo"));
        EnumAtivo status = EnumAtivo.valueOf(request.getParameter("ativo").toUpperCase());
        
        Cliente cliente = new Cliente(1, nome, documento, saldo, status);
        request.setAttribute("cliente", cliente);
                
        if(data == null) {
            Command cadastroCliente = new CadastraCliente();
            
            cadastroCliente.execute(request, response);
        } else {
            Command cadastroPedido = new CadastraPedido();
            
            cadastroPedido.execute(request, response);            
        }
    }
    
}
