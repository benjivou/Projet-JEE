package com.exemple.bdd.entity;

import javax.persistence.*;

@Entity
@Table(name = "likes", schema = "cours_jee_exemple2", catalog = "")
public class LikesEntity {
    private int idLike;
    private int idUtilisateur;
    private int idCommentaire;

    @Id
    @Column(name = "idLike", nullable = false)
    public int getIdLike() {
        return idLike;
    }

    public void setIdLike(int idLike) {
        this.idLike = idLike;
    }

    @Basic
    @Column(name = "idUtilisateur", nullable = false)
    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Basic
    @Column(name = "idCommentaire", nullable = false)
    public int getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(int idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LikesEntity that = (LikesEntity) o;

        if (idLike != that.idLike) return false;
        if (idUtilisateur != that.idUtilisateur) return false;
        if (idCommentaire != that.idCommentaire) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idLike;
        result = 31 * result + idUtilisateur;
        result = 31 * result + idCommentaire;
        return result;
    }
}
