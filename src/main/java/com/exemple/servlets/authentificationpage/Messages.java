package com.exemple.servlets.authentificationpage;

import com.exemple.bdd.dao.DAOContext;
import com.exemple.bdd.entity.CommentaireEntity;
import com.exemple.bdd.entity.UtilisateurEntity;
import com.exemple.bdd.orm.CommentaireORM;
import com.exemple.bdd.orm.LikesORM;
import com.exemple.servlets.abstrct.AuthentificationAbstract;
import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.util.Pair;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import static com.exemple.forms.FormAbstrsact.getValeurChamp;
import static com.exemple.servlets.publicpage.Connexion.ATT_USER;



@WebServlet(urlPatterns = "/message")
public class Messages extends AuthentificationAbstract {
    public static final String ATT_TOP = "topcommentaire";
    public static final String ATT_LIST = "commentaire";

    public static final String ATT_ID_LIST = "id";

    public static final String VUE      = "/WEB-INF/message.jsp";

    private ArrayList<Pair<CommentaireEntity, Boolean>> listCommentaire;// liste de tous les commentaires
    private ArrayList<Pair<CommentaireEntity,Boolean>> listTop;         // liste des tops commentaires en ce moment

    private Logger console = Logger.getLogger(
            this.getClass()
                    .getName());



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

            try {
                /*
                Prepare la première liste
                 */
                this.listCommentaire = prepareListe(
                        (ArrayList<CommentaireEntity>) CommentaireORM.getAllCommentaires()
                );

                /*
                Prépare la seconde list
                 */
                this.listTop = prepareListe(
                        (ArrayList<CommentaireEntity>) CommentaireORM.getTopCommentaires(3)
                );

            } catch (Exception e) {
                e.printStackTrace();
            }


            /*
            Commmunique tous les traitements
             */
            request.setAttribute( ATT_USER,this.utilisateur); // give the user to the front end
            request.setAttribute(ATT_TOP,this.listTop);
            request.setAttribute(ATT_LIST,this.listCommentaire);


            /* Affichage de la page des messages*/
            this.getServletContext()
                    .getRequestDispatcher( VUE )
                    .forward( request, response );
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        super.doPost(request, response);

        /*
        Récupération de la position du like suivant les listes
         */
         String idCommentaire =  getValeurChamp(request,ATT_ID_LIST);

         console.warning("l'id du commentaire est : " + idCommentaire);

         CommentaireEntity com = null;

         com = updateLikeabilite(Integer.parseInt(idCommentaire));

         /*
         Ajouter le like à la table
          */
        LikesORM.ajouterLike(this.utilisateur,com);

         /*
            Commmunique tous les traitements
             */
        request.setAttribute( ATT_USER,this.utilisateur); // give the user to the front end
        request.setAttribute(ATT_TOP,this.listTop);
        request.setAttribute(ATT_LIST,this.listCommentaire);


        /* Affichage de la page des messages*/
        request
                .getRequestDispatcher( VUE )
                .forward( request, response );

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

    /**
     * Prépare une liste de commentaire pour l'envoyer au front
     * @param listCom
     * @return
     */
    protected ArrayList<Pair<CommentaireEntity,Boolean>> prepareListe(ArrayList<CommentaireEntity> listCom){
        ArrayList<Pair<CommentaireEntity,Boolean>> resultList = new ArrayList<>();

        /*
        Traitement
         */
        for (CommentaireEntity com:
                listCom
             ) {
            resultList.add(commentaireLikeable(com));
        }

        return resultList;
    }

    /**
     * Lors d'un like ceci modifira les listes
     *
     * @param idCommentaire
     */
    protected CommentaireEntity updateLikeabilite(int idCommentaire){
        int count = 0;
        CommentaireEntity commentaireEntity = null;
        /*
        Update de la liste de tous les commentaires et récupération du commentaire
         */
        for (Pair<CommentaireEntity,Boolean> pair:
                this.listCommentaire
             ) {
            /* Si l'on trouve le bon commentaire */
            if(pair.getKey().getIdCommentaire() == idCommentaire){
                /* On modifie la list */
                this.listCommentaire.set(count,
                        new Pair<CommentaireEntity,Boolean>(
                        pair.getKey(),
                        false
                ));

                commentaireEntity = pair.getKey();
                break;
            }
            count ++;
        }

        for (Pair<CommentaireEntity,Boolean> pair:
                this.listTop
        ) {
            /* Si l'on trouve le bon commentaire */
            if(pair.getKey().getIdCommentaire() == idCommentaire){
                /* On modifie la list */
                this.listTop.set(count,
                        new Pair<CommentaireEntity,Boolean>(
                                pair.getKey(),
                                false
                        ));
                break;
            }
            count ++;
        }

        return commentaireEntity;
    }





}
