package io.github.lucasduete.atividadePw.controll.commandImp;

import io.github.lucasduete.atividadePw.controll.commandIF.Command;
import io.github.lucasduete.atividadePw.factory.Fabrica;
import io.github.lucasduete.atividadePw.interfaces.ClienteDaoInterface;
import io.github.lucasduete.atividadePw.model.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuscaCliente implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String nomeCliente = request.getParameter("nomeCliente");
        
        ClienteDaoInterface clienteDao = Fabrica.criarDaoPostgres().criarClienteDao();
        
        ArrayList<Cliente> clientes = clienteDao.listar();
        
        for(int aux=0; aux < clientes.size(); aux++) {
            if (!(clientes.get(aux).getNome().contains(nomeCliente)))
                clientes.remove(aux);
        }
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Lista Clientes</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<table>");
                out.println("<tr>");
                    out.println("<th>Id</th>");
                    out.println("<th>Nome</th>");
                    out.println("<th>Documento</th>");
                    out.println("<th>Saldo</th>");
                    out.println("<th>Ativo</th>");
                out.println("</tr>");
                
                for(Cliente cliente : clientes) {
                    out.println("<tr>");
                        out.println("<td>" + cliente.getId() + "</td>");
                        out.println("<td>" + cliente.getNome() + "</td>");
                        out.println("<td>" + cliente.getDocumento()+ "</td>");
                        out.println("<td>" + cliente.getSaldo() + "</td>");
                        out.println("<td>" + cliente.getAtivo() + "</td>");
                    out.println("</tr>");
                }
            
            out.println("</table>");
            out.println("<br/><br/><button onclick=\"location.href='cadastroCliente.jsp'\">Voltar</button>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
}
