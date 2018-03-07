package io.github.lucasduete.atividadePw.controll.commandImp;

import io.github.lucasduete.atividadePw.Enum.EnumAtivo;
import io.github.lucasduete.atividadePw.controll.commandIF.Command;
import io.github.lucasduete.atividadePw.factory.Fabrica;
import io.github.lucasduete.atividadePw.interfaces.PedidoDaoInterface;
import io.github.lucasduete.atividadePw.model.Cliente;
import io.github.lucasduete.atividadePw.model.Pedido;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastraPedido implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Date data = Date.valueOf(request.getParameter("data"));
        Double valor = Double.parseDouble(request.getParameter("valor"));
        
        Cliente cliente = (Cliente) request.getAttribute("cliente");
        
        Instant instant = Instant.ofEpochMilli(data.getTime());
        LocalDate localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        Pedido pedido  = new Pedido(1, localDate, cliente, valor);
        
        PedidoDaoInterface pedidoDao = Fabrica.criarDaoPostgres().criarPedidoDao();
        
        pedidoDao.incluir(pedido);
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Salvo Com Sucesso</title>");
            out.println("</head>");
            out.println("<body onload='alert(\"Salvo Com Sucesso!\")'>");
            out.println("<button onclick=\"location.href='cadastroPedido.jsp'\">Voltar</button>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    
    
}
