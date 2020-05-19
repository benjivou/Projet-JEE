package com.exemple.servlets;

import com.exemple.beans.Utilisateur;
import com.exemple.forms.ConnexionForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/table")
public class Table  extends HttpServlet {

    public static final String VUE      = "/WEB-INF/table.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        /*
        Step 1 : Inscription
        */
        List<String> tableUser = new ArrayList<>();
        tableUser.add("toto");
        tableUser.add("roro");

        /* Préparation de l'objet formulaire */
        ConnexionForm form = new ConnexionForm();

        /* Traitement de la requête et récupération du bean en résultant */
        Utilisateur utilisateur = form.connecterUtilisateur( request );

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();




        request.setAttribute("table",tableUser);

        this.getServletContext().getRequestDispatcher( VUE).forward( request, response );
    }
}
