package com.example.gpslabspringboot.dao;


import com.example.gpslabspringboot.modele.Film;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IFillmDAO extends CrudRepository<Film,Integer> {
    Film findByTitre(String titre);
    Iterable<Film> findByAnneSortie(String annesortie);
    Iterable<Film> findByRealisateur(String realisateur);
    Iterable<Film> findAll();
    Optional<Film> findById(int id);


    void deleteById(int id);




}
