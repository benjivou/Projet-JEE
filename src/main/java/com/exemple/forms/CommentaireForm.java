package com.exemple.forms;

import com.exemple.bdd.entity.CommentaireEntity;
import com.exemple.bdd.entity.UtilisateurEntity;
import com.exemple.bdd.orm.CommentaireORM;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class CommentaireForm {
    private static final String CHAMP_CONTENU  = "content";
    private String              resultat;
    private Map<String, String> erreurs     = new HashMap<String, String>();

    /**
     * envoyer commentaire permet de stocker un commentaire dans la base de donnée
     * @param request de la page jsp
     * @param utilisateurEntity l'utilisateur de la session
     * @return commentaireEntity non null si tous les tests sont valide ( dans la v1 du site pas de test donc on aura
     * toujours un commentaire Entity non nul )
     */
    public static CommentaireEntity envoyerCommentaire(HttpServletRequest request,
                                                       UtilisateurEntity utilisateurEntity){


        String content  = getValeurChamp(request,CHAMP_CONTENU);

            CommentaireEntity commentaireEntity = CommentaireORM.createAndStoreEvent(content,utilisateurEntity) ;


            return commentaireEntity;
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }
}
