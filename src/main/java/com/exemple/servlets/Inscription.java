package com.exemple.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exemple.bdd.dao.DAOContext;

import com.exemple.bdd.entity.UtilisateurEntity;
import com.exemple.forms.InscriptionForm;

@WebServlet(urlPatterns = "/inscription")
public class Inscription extends HttpServlet {
    public static final String ATT_USER = "utilisateur";
    public static final String ATT_FORM = "form";
    public static final String VUE      = "/WEB-INF/inscription.jsp";

    @Override
    public void init() throws ServletException {
        DAOContext.init( this.getServletContext() );
    }

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        InscriptionForm form = new InscriptionForm();

        /*
         * Appel au traitement et à la validation de la requête, et récupération
         * du bean en résultant
         */
        UtilisateurEntity utilisateur = null;
        try {
             utilisateur = form.inscrireUtilisateur(request);
            /* Stockage du formulaire et du bean dans l'objet request */
            request.setAttribute( ATT_FORM, form );
            request.setAttribute( ATT_USER, utilisateur );

            /* Redirection sur la page de connexion */
            response.sendRedirect(request.getContextPath()+"/accueil"); // Redirection vers la bonne page

        }
        catch(SQLException e){
            /* Stockage du formulaire et du bean dans l'objet request */
            request.setAttribute( ATT_FORM, form );
            request.setAttribute( ATT_USER, utilisateur );
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        }





    }
}