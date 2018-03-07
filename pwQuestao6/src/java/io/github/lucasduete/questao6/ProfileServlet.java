package io.github.lucasduete.questao6;

import io.github.lucasduete.questao6.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        boolean status = (Boolean) request.getSession().getAttribute("status");
        Usuario user = (Usuario) request.getSession().getAttribute("usuario");
        
        if(status == false) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.sendRedirect("/login.html");
        }
        if(user == null 
                || user.getNome() == null
                || user.getNome().isEmpty()
                || user.getPassword() == null
                || user.getPassword().isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.sendRedirect("/login.html");
        }
                
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Perfil</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<br/><h3>Perfil: </h3></br>");
            out.println("Nome: <input type='text' value='" + user.getNome() + "' disabled><br/>");
            out.println("Password: <input type='password' value='" + user.getPassword() + "' disabled><br/>");
            out.println("<button onclick=\"location.href='index.html'\">Index</button>|");
            out.println("<button onclick=\"location.href='LogoutServlet'\">Logout</button>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_BAD_GATEWAY, "Este Método Não Está Disponível.");
    }

}
