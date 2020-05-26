package com.exemple.servlets.authentificationpage;

import com.exemple.bdd.entity.CommentaireEntity;
import com.exemple.bdd.entity.UtilisateurEntity;
import com.exemple.bdd.orm.LikesORM;
import com.exemple.servlets.abstrct.AuthentificationAbstract;
import javafx.util.Pair;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.exemple.servlets.publicpage.Connexion.ATT_USER;

@WebServlet(urlPatterns = "/message")
public class Messages extends AuthentificationAbstract {
    public static final String ATT_TOP = "topcommentaire";
    public static final String VUE      = "/WEB-INF/message.jsp";

    public Messages(){
        super();
        this.pagePrec = "/message";
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        super.doGet(request,response);
        /* Affichage de la page de connexion */
        if(this.utilisateur == null) {
            response.sendRedirect(request.getContextPath() + "/connexion");
        }else{



            request.setAttribute( ATT_USER,this.utilisateur); // give the user to the front end
            request.setAttribute(ATT_TOP,this);

            /* Affichage de la page des messages*/
            this.getServletContext()
                    .getRequestDispatcher( VUE )
                    .forward( request, response );
        }

    }

    /**
     * associe à 1 commentaire un boolean qui indique si oui il est likeable par l'utilisateur
     * @param commentaireEntity
     * @return
     */
    protected Pair<CommentaireEntity,Boolean> commentaireLikeable(CommentaireEntity commentaireEntity){
            return new Pair<CommentaireEntity,Boolean>(
                    commentaireEntity,
                    LikesORM.likeableCommentaire(this.utilisateur,commentaireEntity)

            );
        }
}
