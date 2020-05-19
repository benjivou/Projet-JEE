package com.exemple.bdd;

import org.hibernate.Session;

import java.sql.Date;


public class CommentaireORM {
    private void createAndStoreEvent(String contenu,UtilisateurEntity utilisateurEntity) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        CommentaireEntity com = new CommentaireEntity();

        // the id is auto generate
        com.setContent(contenu);
        com.setDate(new Date(System.currentTimeMillis()) );
        com.setIdUtilisateur(utilisateurEntity.getIdUtilisateur());


        session.save(com);

        session.getTransaction().commit();
    }
}
