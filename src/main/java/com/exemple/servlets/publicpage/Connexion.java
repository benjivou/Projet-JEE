package com.exemple.servlets.publicpage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exemple.bdd.dao.DAOContext;


import com.exemple.bdd.entity.UtilisateurEntity;
import com.exemple.forms.ConnexionForm;

import static com.exemple.bdd.orm.UtilisateurORM.getAllUtilisateurs;
import static com.exemple.servlets.abstrct.AuthentificationAbstract.ATT_SESSION_BEFORE;
import static com.exemple.servlets.abstrct.AuthentificationAbstract.ATT_SESSION_USER;

@WebServlet(urlPatterns = {"/connexion"})
public class Connexion extends HttpServlet {
    public static final String ATT_USER         = "utilisateur";
    public static final String ATT_FORM         = "form";

    public static final String VUE              = "/WEB-INF/connexion.jsp";


    @Override
    public void init() throws ServletException {
        DAOContext.init( this.getServletContext() );
    }

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page de connexion */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );



    }

    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        Logger logger = Logger.getLogger(this.getClass().getName());
        logger.info("on est dans le post de Connexion");
        try {
            ArrayList<UtilisateurEntity> com =
                    (ArrayList<UtilisateurEntity>) getAllUtilisateurs();
            for (UtilisateurEntity c: com
                 ) {
                logger.warning("User list " + c.getNom());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
        Step 1 : Inscription
        */

        /* Préparation de l'objet formulaire */
        ConnexionForm form = new ConnexionForm();

        /* Traitement de la requête et récupération du bean en résultant */
        UtilisateurEntity utilisateur = form.connecterUtilisateur( request );

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur à la session, sinon suppression du bean de la session.
         */
        if ( form.getErreurs().isEmpty() ) {
            session.setAttribute( ATT_SESSION_USER, utilisateur );
        } else {
            session.setAttribute( ATT_SESSION_USER, null );
        }



        /*
        Quand il n'y a pas d'erreur
         */
        if(form.getErreurs().isEmpty()  ){
            // redirection vers la page table

            //request.setAttribute( ATT_USER, utilisateur );

            response.sendRedirect(request.getContextPath()+request.getSession().getAttribute(ATT_SESSION_BEFORE)   );
            // Redirection vers
            // la bonne
            // page

        }
        else{
            /* Stockage du formulaire et du bean dans l'objet request */
            request.setAttribute( ATT_FORM, form );
            request.setAttribute( ATT_USER, utilisateur );
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

        }
    }
}