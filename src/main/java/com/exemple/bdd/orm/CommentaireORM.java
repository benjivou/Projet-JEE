package com.exemple.bdd.orm;





import com.exemple.bdd.entity.CommentaireEntity;
import com.exemple.bdd.entity.UtilisateurEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class CommentaireORM {
    public static CommentaireEntity createAndStoreEvent(String contenu, UtilisateurEntity utilisateurEntity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        CommentaireEntity com = new CommentaireEntity();

        // the id is auto generate
        com.setContent(contenu);
        com.setDate(new Date(System.currentTimeMillis()) );
        com.setIdUtilisateur(utilisateurEntity.getIdUtilisateur());


        session.save(com);

        session.getTransaction().commit();

        session.close();
        return com;
    }

    /**
     * donne les tops commentaires
     * @param nbTops nombre de commentaires voulus
     * @return retourne les nbTops tops commentaires
     */
    public static ArrayList<CommentaireEntity> getTopCommentaires(int nbTops){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List commentaires = null;
        try {


            commentaires = session.createQuery(
                    "from CommentaireEntity ORDER BY likes DESC "
            )
                    .setMaxResults(nbTops)
                    .getResultList();

        } finally {
            session.close();

        }

        return (ArrayList<CommentaireEntity>) commentaires;
    }


    public static List<CommentaireEntity> getAllCommentaires() throws Exception {

        Session session = HibernateUtil.getSessionFactory().openSession();
        List commentaires = null;
        try {
             commentaires = session.createQuery(
                     "from CommentaireEntity "
                    ).getResultList();

        } finally {
            session.close();

        }

        return commentaires;
    }

    public static CommentaireEntity getCommentaireById(int id){

        Session session = HibernateUtil.getSessionFactory().openSession();
        CommentaireEntity commentaires = null;
        try {
            commentaires = session.createQuery(
                    "from CommentaireEntity c where c.id="+ id,
                    CommentaireEntity.class
            ).getSingleResult();

        } finally {
            session.close();

        }

        return commentaires;
    }

}
