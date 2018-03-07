package io.github.lucasduete.questao3;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "Metodo Ainda Nao Disponível");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String primParametro = request.getParameter("primParametro");
        String segParametro = request.getParameter("segParametro");
        String tercParametro = request.getParameter("tercParametro");
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Parametros</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Pamaretros :</h3><br/><br/><br/>");
            out.println("Primeiro Parametro : <b>" + primParametro + "</b><br/>");
            out.println("Segundo Parametro : <b>" + segParametro + "</b><br/>");
            out.println("Terceiro Parametro : <b>" + tercParametro + "</b><br/>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
