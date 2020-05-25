package com.exemple.servlets;

import com.exemple.bdd.entity.UtilisateurEntity;
import com.exemple.servlets.abstrct.AuthentificationAbstract;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

import static com.exemple.servlets.Connexion.ATT_USER;

@WebServlet(urlPatterns = "/livre")
public class Livre extends AuthentificationAbstract {


    public static final String VUE      = "/WEB-INF/livre.jsp";


    public Livre(){
        super();
        this.pagePrec = "/livre";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        super.doGet(request,response);
        if(this.utilisateur == null) {
            response.sendRedirect(request.getContextPath() + "/connexion");
        }else{
            /* Affichage de la page du livre*/

            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        }


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        Logger logger = Logger.getLogger(this.getClass().getName());
        logger.warning("on est dans le get de Livre ");

        logger.warning("la valeur de l'attribut user session est :  "+ ((UtilisateurEntity)request.getSession().getAttribute(ATT_SESSION_USER)).getEmail());
        request.setAttribute( ATT_USER,(UtilisateurEntity) request.getSession().getAttribute(ATT_SESSION_USER));
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }
}
