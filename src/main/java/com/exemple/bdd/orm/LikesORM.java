package com.exemple.bdd.orm;

import com.exemple.bdd.entity.CommentaireEntity;
import com.exemple.bdd.entity.LikesEntity;
import com.exemple.bdd.entity.UtilisateurEntity;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class LikesORM {
    /**
     * permet de dire si l'utilisateur à déja "liké" le message
     * @param utilisateurEntity l'utilisateur actuel
     * @param commentaireEntity le commentaire a tester
     * @return true == le commentaire peut-être liker, false == le commentaire est déjà liké
     */
    public static boolean likeableCommentaire(UtilisateurEntity utilisateurEntity, CommentaireEntity commentaireEntity){
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean liked = false;
        try {

            List<LikesEntity> list =  session.createQuery(
                    "from LikesEntity where idUtilisateur = "+utilisateurEntity.getIdUtilisateur()+" AND " +
                            "idCommentaire = "+ commentaireEntity.getIdCommentaire(),LikesEntity.class
            ).getResultList();

            liked = list.isEmpty();

        } finally {
            session.close();

        }

        return  liked;
    }

    public static void ajouterLike(UtilisateurEntity utilisateurEntity, CommentaireEntity commentaireEntity){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        // add the likes numbers to the entity
        commentaireEntity.setLikes(commentaireEntity.getLikes()+1);

        // create the new likesEntry
        LikesEntity likesEntity = new LikesEntity();
        likesEntity.setIdCommentaire(commentaireEntity.getIdCommentaire());
        likesEntity.setIdUtilisateur(utilisateurEntity.getIdUtilisateur());
        session.save(commentaireEntity);
        session.save(likesEntity);



        session.getTransaction().commit();

        session.close();

    }
}
