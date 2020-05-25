package com.exemple.servlets;


import com.exemple.bdd.dao.DAOContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/accueil")
public class Accueil extends HttpServlet  {



    public static final String VUE              = "/WEB-INF/accueil.jsp";

    @Override
    public void init() throws ServletException {
        DAOContext.init( this.getServletContext() );
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page de connexion */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );



    }


}
