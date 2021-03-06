package com.exemple.servlets.abstrct;

import com.exemple.bdd.entity.UtilisateurEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

import static com.exemple.servlets.publicpage.Inscription.ATT_USER;

/**
 * Page with authentification check
 */
public class AuthentificationAbstract extends HttpServlet {
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String ATT_SESSION_BEFORE = "sessionPagePrécédente";

    protected UtilisateurEntity utilisateur;
    protected String pagePrec;
    /**
     * check if the user is login
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        Logger logger = Logger.getLogger(this.getClass().getName());


        /*
        Message part
         */


        /*
         * Test Utilisateur connecté ou non
         */
        // need to be connected
        if((UtilisateurEntity) request.getSession().getAttribute(ATT_SESSION_USER) == null && this.utilisateur == null){

            // after the connection process we will
            // go back to this page
            request.getSession().setAttribute(ATT_SESSION_BEFORE,this.pagePrec);




        }
        // no need
        else{
            // save the current user in the servlet



            this.utilisateur = (UtilisateurEntity) request.getSession().getAttribute(ATT_SESSION_USER);
            request.removeAttribute(ATT_USER);
        }


    }
}
