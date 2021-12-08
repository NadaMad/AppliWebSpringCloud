package com.example.gpslabspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

@SpringBootApplication
public class FilmService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static void main(String[] args){
        SpringApplication.run(FilmService.class);
    }
    @PostConstruct
    private void initDb(){
        String sqlStatement[] = {
                "INSERT INTO FILM (TITRE, REALISATEUR,ANNE_SORTIE) VALUES('Nothing hill', 'Roger Michell','1999');",
                "INSERT INTO film (TITRE, REALISATEUR,ANNE_SORTIE) VALUES('Her', 'Spike Jonze','2014');",
                "INSERT INTO film (TITRE, REALISATEUR,ANNE_SORTIE) VALUES('Titanic', 'James Cameron','1998');",
                "INSERT INTO film (TITRE, REALISATEUR,ANNE_SORTIE) VALUES('Alien', 'Ridley Scott','2003');",
                "INSERT INTO film (TITRE, REALISATEUR,ANNE_SORTIE) VALUES('Leon', 'Luc Besson','1994');",
                "INSERT INTO film (TITRE, REALISATEUR,ANNE_SORTIE) VALUES('Spider-Man 2', 'Sam Raimi','2014');",
                "INSERT INTO film (TITRE, REALISATEUR,ANNE_SORTIE) VALUES('Spider-Man', 'Sam Raimi','2002');"

        };

        Arrays.asList(sqlStatement).forEach(sql -> {
            jdbcTemplate.execute(sql);
        });

        System.out.println("Affichage de tous les films");
        jdbcTemplate.query("select * from film",
                new RowMapper<Object>() {
                    @Override
                    public Object mapRow(ResultSet film, int rowNum) throws SQLException {
                        System.out.println("id : "+film.getString("id")+
                                " titre : "+film.getString("titre")+
                                " realisateur : "+film.getString("realisateur")+
                                " Année sortie : "+film.getString("ANNE_SORTIE"));
                        return null;                    }


                }
        );
    }

}
