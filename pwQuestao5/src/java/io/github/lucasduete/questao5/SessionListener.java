package io.github.lucasduete.questao5;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        ServletContext contexto = event.getSession().getServletContext();
        System.out.println(contexto);
        System.out.println(contexto.getAttribute("sessoesAtivas"));
        Integer sessoesAtivas = null;
        try {
            sessoesAtivas = Integer.parseInt(contexto.getAttribute("sessoesAtivas").toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (sessoesAtivas == null) 
            sessoesAtivas = 1;
        else
            sessoesAtivas++;
        contexto.setAttribute("sessoesAtivas", sessoesAtivas);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        ServletContext contexto = event.getSession().getServletContext();
        Integer sessoesAtivas = null;
        try {
            sessoesAtivas = Integer.parseInt(contexto.getAttribute("sessoesAtivas").toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (sessoesAtivas == null) 
            sessoesAtivas = 0;
        else
            sessoesAtivas--;
        contexto.setAttribute("sessoesAtivas", sessoesAtivas);
    }
    
    
}
