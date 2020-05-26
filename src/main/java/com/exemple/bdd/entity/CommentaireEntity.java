package com.exemple.bdd.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "commentaire", schema = "cours_jee_exemple2", catalog = "")
public class CommentaireEntity {
    private int idCommentaire;
    private String content;
    private Date date;
    private int idUtilisateur;
    private int likes;

    @Id
    @Column(name = "id_commentaire", nullable = false)
    public int getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(int idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    @Basic
    @Column(name = "content", nullable = false, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "id_utilisateur", nullable = false)
    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentaireEntity that = (CommentaireEntity) o;

        if (idCommentaire != that.idCommentaire) return false;
        if (idUtilisateur != that.idUtilisateur) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCommentaire;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + idUtilisateur;
        return result;
    }

    @Basic
    @Column(name = "Likes", nullable = false)
    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
