package com.exemple.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.exemple.bdd.dao.UtilisateurDAO;
import com.exemple.bdd.entity.UtilisateurEntity;
import com.exemple.bdd.orm.UtilisateurORM;


public final class ConnexionForm extends FormAbstrsact{
    private static final String CHAMP_EMAIL = "email";
    private static final String CHAMP_PASS  = "motdepasse";
    private String              resultat;
    private Map<String, String> erreurs     = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public UtilisateurEntity connecterUtilisateur(HttpServletRequest request ) {

        /* Récupération des champs du formulaire */
        String email = getValeurChamp( request, CHAMP_EMAIL );
        String motDePasse = getValeurChamp( request, CHAMP_PASS );



        UtilisateurEntity utilisateur = new UtilisateurEntity();


        /* Validation du champ email. */
        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }


        /* Validation du champ mot de passe. */
        try {
            validationMotDePasse( motDePasse );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
        }


        /* Initialisation du résultat global de la validation. */
        if (  erreurs.isEmpty() && UtilisateurDAO.isValidLogin( email, motDePasse ) ) {

            /*
            Récupération de l'utilisateur
             */


            utilisateur = UtilisateurORM.getUtilisateurByEmail(email);
            resultat = "Succès de la connexion.";
            System.out.println( utilisateur );
        } else {
            resultat = "Échec de la connexion.";
            setErreur( CHAMP_PASS, "mauvais mot de passe" );
        }

        return utilisateur;
    }

    /**
     * Valide l'adresse email saisie.
     */
    private void validationEmail( String email ) throws Exception {
        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci de saisir une adresse mail valide." );
        } else if ( UtilisateurDAO.isValidEmail( email ) == false ) {
            throw new Exception( "Email introuvable." );
        }
    }

    /**
     * Valide le mot de passe saisi.
     */
    private void validationMotDePasse( String motDePasse ) throws Exception {
        if ( motDePasse != null ) {
            if ( motDePasse.length() < 3 ) {
                throw new Exception( "Le mot de passe doit contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }


}