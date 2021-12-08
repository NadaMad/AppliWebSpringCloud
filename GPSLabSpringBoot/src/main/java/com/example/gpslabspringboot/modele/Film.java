package com.example.gpslabspringboot.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titre;
    private String realisateur;
    private String anneSortie;

    public Film(int id, String titre, String realisateur, String anneSortie) {
        this.id = id;
        this.titre = titre;
        this.realisateur = realisateur;
        this.anneSortie = anneSortie;
    }
    public Film() {

    }

    public Integer getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public void setAnneSortie(String anneSortie) {
        this.anneSortie = anneSortie;
    }

    public String getAnneSortie() {
        return anneSortie;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", realisateur='" + realisateur + '\'' +
                ", anneSortie='" + anneSortie + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(id, film.id) && Objects.equals(titre, film.titre) && Objects.equals(realisateur, film.realisateur) && Objects.equals(anneSortie, film.anneSortie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titre, realisateur, anneSortie);
    }
}
