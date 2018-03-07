package io.github.lucasduete.questao5;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessao = request.getSession();
        Instant criacao = Instant.ofEpochMilli(sessao.getCreationTime());
        Instant ultAcesso = Instant.ofEpochMilli(sessao.getLastAccessedTime());
        Integer sessoesAtivas = (Integer) sessao.getServletContext().getAttribute("sessoesAtivas");
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MainServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<br/><br/><h2>Dados da Sessão</h2>");
            out.println("<br/><br/><p>Identificador da Sessão : <b>" + sessao.getId() + "</b></p>");
            out.println("<br/><br/><p>Data/Hora da Criação da Sessão : <b>" + Date.from(criacao) + "</b></p>");
            out.println("<br/><br/><p>Último Acesso : <b>" + Date.from(ultAcesso) + "</b></p>");
            out.println("<br/><br/><p>Número de Acessos : <b>" + sessoesAtivas + "</b></p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "Método Não Disponível");
    }

}
