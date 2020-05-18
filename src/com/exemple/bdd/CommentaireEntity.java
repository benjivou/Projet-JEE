package com.exemple.bdd;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "commentaire", schema = "cours_jee_exemple2", catalog = "")
public class CommentaireEntity {
    private int idCommentaire;
    private String content;
    private Date date;
    private UtilisateurEntity utilisateur;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentaireEntity that = (CommentaireEntity) o;
        return idCommentaire == that.idCommentaire &&
                Objects.equals(content, that.content) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCommentaire, content, date);
    }

    @ManyToOne
    public UtilisateurEntity getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurEntity utilisateur) {
        this.utilisateur = utilisateur;
    }
}
