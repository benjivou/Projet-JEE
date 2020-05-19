package com.exemple.bdd;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Date;

public class UtilisateurORM {
    public void createAndStoreEvent(
            String email,
            String motDePasse,
            String nom,
            String prenom
    ) {

        Session session = new Configuration().configure().buildSessionFactory().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        UtilisateurEntity com = new UtilisateurEntity();

        // the id is auto generate
        com.setEmail(email);
        com.setMotDePasse(motDePasse);
        com.setNom(nom);
        com.setPrenom(prenom);


        session.save(com);

        session.getTransaction().commit();
    }
}
