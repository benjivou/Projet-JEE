package com.exemple.bdd.orm;

import com.exemple.bdd.entity.UtilisateurEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


public class UtilisateurORM {


    /**
     * Create a user in the Database
     * @param email
     * @param motDePasse
     * @param nom
     * @param prenom
     * @return the user after insert
     */
    public static UtilisateurEntity createAndStoreEvent(
            String email,
            String motDePasse,
            String nom,
            String prenom
    ) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        UtilisateurEntity com = new UtilisateurEntity();

        // the id is auto generate
        com.setEmail(email);
        com.setMotDePasse(motDePasse);
        com.setNom(nom);
        com.setPrenom(prenom);

        com.setDateInscription(new Timestamp(new Date().getTime()));

        session.save(com);

        session.getTransaction().commit();

        return com;
    }



    public static List<UtilisateurEntity> getAllUtilisateurs() throws Exception {


        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        List commentaires = null;
        try {
            commentaires = session.createQuery(
                    "from UtilisateurEntity",UtilisateurEntity.class
            ).getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }

        return commentaires;
    }

    public static UtilisateurEntity getUtilisateurById(int id){

        Session session = HibernateUtil.getSessionFactory().openSession();
        UtilisateurEntity utilisateurs = null;
        try {
            utilisateurs = session.createQuery(
                    "from UtilisateurEntity c where c.id="+ id,
                    UtilisateurEntity.class
            ).getSingleResult();

        } finally {
            session.close();

        }

        return utilisateurs;
    }

    /**
     * Get the user by his email
     * @param email
     * @return
     */
    public static UtilisateurEntity getUtilisateurByEmail(String email){

        Session session = HibernateUtil.getSessionFactory().openSession();
        UtilisateurEntity utilisateurs = null;
        try {
            utilisateurs = session.createQuery(
                    "from UtilisateurEntity c where c.email='"+ email+"'",
                    UtilisateurEntity.class
            ).getSingleResult();

        } finally {
            session.close();

        }

        return utilisateurs;
    }




}
