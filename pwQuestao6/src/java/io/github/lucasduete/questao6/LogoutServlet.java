package io.github.lucasduete.questao6;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Este Método Não Está Disponível.");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean status = false;
        
        try {
            status = (Boolean) request.getSession().getAttribute("status");
        } catch (Exception ex) {
          response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        
        if (status == true) {
            request.getSession().setAttribute("status", false);
            request.getSession().setAttribute("usuario", null);
            response.setStatus(HttpServletResponse.SC_OK);
            response.sendRedirect("/login.html");
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }        
    }
    
}
