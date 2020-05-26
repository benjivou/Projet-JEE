package com.exemple.servlets.authentificationpage;

import com.exemple.servlets.abstrct.AuthentificationAbstract;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

import static com.exemple.forms.CommentaireForm.envoyerCommentaire;
import static com.exemple.servlets.publicpage.Connexion.ATT_USER;

@WebServlet(urlPatterns = "/livre")
public class Livre extends AuthentificationAbstract {


    public static final String VUE      = "/WEB-INF/livre.jsp";


    public Livre(){
        super();
        this.pagePrec = "/livre";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        super.doGet(request,response);
        Logger logger = Logger.getLogger(this.getClass().getName());
        logger.warning("on est dans le get de Livre ");
        /*
        Affichage de la page de connexion
         */
        if(this.utilisateur == null) {
            response.sendRedirect(request.getContextPath() + "/connexion");
        }else{
            /* Affichage de la page du livre*/
            request.setAttribute( ATT_USER,this.utilisateur);
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        }


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        Logger logger = Logger.getLogger(this.getClass().getName());
        logger.warning("on est dans le post de Livre ");
        logger.warning(request.getParameter( "nomChamp" ));
        /**
         * send the message to the database
         */
        envoyerCommentaire(request,this.utilisateur);



        /* retour à la page d'accueil */
        response.sendRedirect(request.getContextPath()+"/accueil"   );

    }
}
