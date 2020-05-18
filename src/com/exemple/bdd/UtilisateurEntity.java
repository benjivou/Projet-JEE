package com.exemple.bdd;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "utilisateur", schema = "cours_jee_exemple2", catalog = "")
public class UtilisateurEntity {
    private int idUtilisateur;
    private String email;
    private String motDePasse;
    private String nom;
    private Timestamp dateInscription;
    private String prenom;
    private List<CommentaireEntity> liste_commentaires;

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
        return idUtilisateur == that.idUtilisateur &&
                Objects.equals(email, that.email) &&
                Objects.equals(motDePasse, that.motDePasse) &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(dateInscription, that.dateInscription) &&
                Objects.equals(prenom, that.prenom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUtilisateur, email, motDePasse, nom, dateInscription, prenom);
    }

    @OneToMany(mappedBy = "utilisateur")
    public List<CommentaireEntity> getListe_commentaires() {
        return liste_commentaires;
    }

    public void setListe_commentaires(List<CommentaireEntity> liste_commentaires) {
        this.liste_commentaires = liste_commentaires;
    }
}
