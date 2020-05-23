package com.exemple.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/message")
public class Messages extends HttpServlet {

    public static final String VUE      = "/WEB-INF/message.jsp";
        public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
            /* Affichage de la page d'inscription */
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        }
}