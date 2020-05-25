package com.exemple.bdd;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.NoResultException;
import java.util.Date;
import java.sql.Timestamp;



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








}
