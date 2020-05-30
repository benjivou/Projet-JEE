package com.exemple.servlets.publicpage;

import com.exemple.servlets.abstrct.AuthentificationAbstract;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/deconnexion")
public class Deconnexion extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        /*
        Reset de la session
         */
        request.getSession().invalidate();
        request.getSession(false);


        /*
        Retour vers la page d'accueil
         */
        response.sendRedirect(request.getContextPath()+"/accueil"); // Redirection vers la bonne page
    }
}
