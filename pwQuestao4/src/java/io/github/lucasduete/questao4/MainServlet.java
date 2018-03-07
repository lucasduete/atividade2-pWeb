package io.github.lucasduete.questao4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getParameter("parametro1") == null)
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Nao Foi Enviado Nada");
        
        else {
         
            Enumeration<String> nomes = request.getParameterNames();
            
            response.setContentType("text/html;charset=UTF-8");
        
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Parametros</title>");
                out.println("<style>table.blueTable {\n" +
                                "  border: 1px solid #1C6EA4;\n" +
                                "  background-color: #EEEEEE;\n" +
                                "  text-align: center;\n" +
                                "  border-collapse: collapse;\n" +
                                "}\n" +
                                "table.blueTable td, table.blueTable th {\n" +
                                "  border: 1px solid #AAAAAA;\n" +
                                "  padding: 3px 2px;\n" +
                                "}\n" +
                                "table.blueTable tbody td {\n" +
                                "  font-size: 13px;\n" +
                                "}\n" +
                                "table.blueTable tr:nth-child(even) {\n" +
                                "  background: #D0E4F5;\n" +
                                "}\n" +
                                "table.blueTable thead {\n" +
                                "  background: #1C6EA4;\n" +
                                "  background: -moz-linear-gradient(top, #5592bb 0%, #327cad 66%, #1C6EA4 100%);\n" +
                                "  background: -webkit-linear-gradient(top, #5592bb 0%, #327cad 66%, #1C6EA4 100%);\n" +
                                "  background: linear-gradient(to bottom, #5592bb 0%, #327cad 66%, #1C6EA4 100%);\n" +
                                "  border-bottom: 2px solid #444444;\n" +
                                "}\n" +
                                "table.blueTable thead th {\n" +
                                "  font-size: 15px;\n" +
                                "  font-weight: bold;\n" +
                                "  color: #FFFFFF;\n" +
                                "  border-left: 2px solid #D0E4F5;\n" +
                                "}\n" +
                                "table.blueTable thead th:first-child {\n" +
                                "  border-left: none;\n" +
                                "}\n" +
                                "table.blueTable tfoot {\n" +
                                "  font-size: 14px;\n" +
                                "  font-weight: bold;\n" +
                                "  color: #FFFFFF;\n" +
                                "  background: #D0E4F5;\n" +
                                "  background: -moz-linear-gradient(top, #dcebf7 0%, #d4e6f6 66%, #D0E4F5 100%);\n" +
                                "  background: -webkit-linear-gradient(top, #dcebf7 0%, #d4e6f6 66%, #D0E4F5 100%);\n" +
                                "  background: linear-gradient(to bottom, #dcebf7 0%, #d4e6f6 66%, #D0E4F5 100%);\n" +
                                "  border-top: 2px solid #444444;\n" +
                                "}\n" +
                                "table.blueTable tfoot td {\n" +
                                "  font-size: 14px;\n" +
                                "}\n" +
                                "table.blueTable tfoot .links {\n" +
                                "  text-align: right;\n" +
                                "}\n" +
                                "table.blueTable tfoot .links a{\n" +
                                "  display: inline-block;\n" +
                                "  background: #1C6EA4;\n" +
                                "  color: #FFFFFF;\n" +
                                "  padding: 2px 8px;\n" +
                                "  border-radius: 5px;\n" +
                                "}</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<br/><br/><h3>Lista de Parametros Enviados</h3");
                out.println("<br/><br/><table border class='blueTable'> ");

                    out.print("<thead");
                    out.print("<th>");
                        out.print("<td>Nome Parametro</td>");
                        out.print("<td>Valor do Parametro</td>");
                    out.print("</th>");                    
                    out.print("</thead");

                    out.print("<tbody>");
                        while(nomes.hasMoreElements()) {
                            String nome = nomes.nextElement();
                            String valor = request.getParameter(nome);
                            out.print("<tr>");
                                out.print("<td>" + nome + "</td>");
                                out.print("<td>" + valor + "</td>");
                            out.print("</tr>");
                        }
                    out.print("</tbody>");
                out.print("</table>");
                out.println("</body>");
                out.println("</html>");
            }
            
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
