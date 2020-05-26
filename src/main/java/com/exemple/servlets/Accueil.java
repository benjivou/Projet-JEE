package com.exemple.servlets;


import com.exemple.bdd.dao.DAOContext;
import com.exemple.bdd.entity.CommentaireEntity;
import com.exemple.bdd.orm.CommentaireORM;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;


@WebServlet(urlPatterns = "/accueil")
public class Accueil extends HttpServlet  {

    public static final String ATT_TOP="topcommentaire";

    public static final String VUE              = "/WEB-INF/accueil.jsp";

    @Override
    public void init() throws ServletException {
        DAOContext.init( this.getServletContext() );
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        Logger logger = Logger.getLogger(this.getClass().getName());
        ArrayList<CommentaireEntity> list = CommentaireORM.getTopCommentaires(3);

        for (CommentaireEntity com : list
             ) {
            logger.warning(com.getContent());
        }
        request.setAttribute( ATT_TOP, list);
        /* Affichage de la page de connexion */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );



    }


}
