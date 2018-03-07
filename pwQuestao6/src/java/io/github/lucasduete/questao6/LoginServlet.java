package io.github.lucasduete.questao6;

import io.github.lucasduete.questao6.model.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Este Método Não Está Disponível.");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getParameter("nome") == null || request.getParameter("nome").isEmpty() 
                || request.getParameter("password") == null
                || !request.getParameter("password").equals("admin123")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            
        } else {
            Usuario user = new Usuario(
                    request.getParameter("nome"),
                    request.getParameter("password")
            );
            
            request.getSession().setAttribute("status", true);
            request.getSession().setAttribute("usuario", user);
            
            response.setStatus(HttpServletResponse.SC_OK);
            response.sendRedirect("/index.html");
        }
    }
}