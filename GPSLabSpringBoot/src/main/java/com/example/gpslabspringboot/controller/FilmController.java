package com.example.gpslabspringboot.controller;


import com.example.gpslabspringboot.dao.IFillmDAO;
import com.example.gpslabspringboot.modele.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class FilmController {
    @Autowired
    private IFillmDAO dao;

    /*
    * Methode get
    * */

    @GetMapping(value="/Films")
    public Iterable<Film> getLesFilms(){
        return dao.findAll();
            }


    @GetMapping(value="/FilmsByAnneSortie/{annesortie}")
    public Iterable<Film> findByAnneSortie(@PathVariable String annesortie){
        return dao.findByAnneSortie(annesortie);
    }


    @GetMapping(value="/FilmsById/{id}")
    public Optional<Film> getFilmById(@PathVariable int id){
        return dao.findById(id);
    }


    @GetMapping(value="/FilmsByTitre/{titre}")
    public  Film getFilmByTitre(@PathVariable String titre){
        String title= titre.replace("_", " ");
        return dao.findByTitre(title);
    }


    @GetMapping(value="/FilmsByRealisateur/{realisateur}")
    public  Iterable<Film> getFilmByRealisateur(@PathVariable String realisateur){
        String real= realisateur.replace("_", " ");
        return dao.findByRealisateur(real);
    }


    /*
     * Methode delete
     * */

    @DeleteMapping(value="/FilmsDelete/{id}")
    public void deteleteById(@PathVariable int id ){
        dao.deleteById(id);
    }




    /*
     * Methode put
     * */

    @PutMapping(value = "/FilmsUpdate")
    public void updateUser(@RequestBody Film film) {
        dao.save(film);
    }

    /*
     * Methode Post
     * */


    @PostMapping(value="FilmsAdd")
    public void addFilm(@RequestBody Film f){
        dao.save(f);
    }

}

