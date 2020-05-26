package com.exemple.bdd.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "utilisateur", schema = "cours_jee_exemple2", catalog = "")
public class UtilisateurEntity {
    private int idUtilisateur;
    private String email;
    private String motDePasse;
    private String nom;
    private Timestamp dateInscription;
    private String prenom;
    private int likes;

    @Id
    @Column(name = "id_utilisateur", nullable = false)
    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 60)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "mot_de_passe", nullable = false, length = 32)
    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @Basic
    @Column(name = "nom", nullable = false, length = 20)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "date_inscription", nullable = false)
    public Timestamp getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Timestamp dateInscription) {
        this.dateInscription = dateInscription;
    }

    @Basic
    @Column(name = "prenom", nullable = false, length = 100)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UtilisateurEntity that = (UtilisateurEntity) o;

        if (idUtilisateur != that.idUtilisateur) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (motDePasse != null ? !motDePasse.equals(that.motDePasse) : that.motDePasse != null) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (dateInscription != null ? !dateInscription.equals(that.dateInscription) : that.dateInscription != null)
            return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUtilisateur;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (motDePasse != null ? motDePasse.hashCode() : 0);
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (dateInscription != null ? dateInscription.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "likes", nullable = false)
    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {

        this.likes = likes;
    }
}
