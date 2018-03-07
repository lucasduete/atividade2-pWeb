package io.github.lucasduete.atividadePw.controll.commandImp;

import io.github.lucasduete.atividadePw.Enum.EnumAtivo;
import io.github.lucasduete.atividadePw.controll.commandIF.Command;
import io.github.lucasduete.atividadePw.factory.Fabrica;
import io.github.lucasduete.atividadePw.interfaces.ClienteDaoInterface;
import io.github.lucasduete.atividadePw.model.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastraCliente implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        Cliente cliente = (Cliente) request.getAttribute("cliente");
        
        ClienteDaoInterface clienteDao = Fabrica.criarDaoPostgres().criarClienteDao();
        
        clienteDao.incluir(cliente);
                
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Salvo Com Sucesso</title>");
            out.println("</head>");
            out.println("<body onload='alert(\"Salvo Com Sucesso!\")'>");
            out.println("<button onclick=\"location.href='cadastroCliente.jsp'\">Voltar</button>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
}
