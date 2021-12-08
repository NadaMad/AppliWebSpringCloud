package swingClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class ClientCreate {


    public ClientCreate() {

    }


    /**
     * Methode pour Rechercher
     * **/
    public String getLesFilms() throws IOException {
        URL url = new URL("http://localhost:8080/Films" );
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        //Pour un bon affichage pour l'user
        String doublquotes = content.toString().replace("\"","");
        String accoladeOuverante = doublquotes.replace("},","\n");
        String accoladeFermante = accoladeOuverante.replace("{","");
        String corchetOuverant =accoladeFermante.replace("[","");
        String corchetFermant =corchetOuverant.replace("]","");
        String affichageBon =corchetFermant.replace("}","");
        return affichageBon;

    }

    public String getFilmByID(String id) throws IOException {
        int idValue = Integer.parseInt(id);
        URL url = new URL("http://localhost:8080/FilmsById/" + idValue);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        return content.toString();

    }


    public String getFilmByAnne(String anneSortie) throws IOException {
        int idValue = Integer.parseInt(anneSortie);
        URL url = new URL("http://localhost:8080/FilmsByAnneSortie/"+ idValue);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        return content.toString();
    }


    public String getFilmByTitre(String titre) throws IOException {
        String title= titre.replace(" ", "_");
        URL url = new URL("http://localhost:8080/FilmsByTitre/" + title);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        return content.toString();
    }

    public String getFilmByRealisateur(String realisateur) throws IOException {
        String real= realisateur.replace(" ", "_");
        URL url = new URL("http://localhost:8080/FilmsByRealisateur/" + real);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        return content.toString();
    }

    /**
     * Methode pour supprimer
     * **/

    public void deleteByID(String id) throws  IOException {
        URL url = new URL("http://localhost:8080/FilmsDelete/" + String.valueOf(id));
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");
        con.getResponseCode();
    }



    /*
    * Methode update
    * */



    public void update(String id,String titre, String realisateur,String anneSortie) throws IOException {
        URL url = new URL("http://localhost:8080/FilmsUpdate");
        String json = '{' +
                "\"id\": " + id + "," +
                "\"titre\": \"" + titre + "\"," +
                "\"realisateur\": \"" + realisateur + "\"," +
                "\"anneSortie\": \"" + anneSortie + "\"" +
                "}";
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("PUT");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);
        try(OutputStream os = con.getOutputStream()) {
            byte[] input = json.getBytes();
            os.write(input, 0, input.length);
        }
        con.getResponseCode();

    }


    /**
     * Methode pour ajouter
     * **/
    public void add(String titre, String realisateur,String anneSortie) throws IOException {
        URL url = new URL("http://localhost:8080/FilmsAdd");
        String generateJson = '{' +
                "\"titre\": \"" + titre + "\"," +
                "\"realisateur\": \"" + realisateur + "\"," +
                "\"anneSortie\": \"" + anneSortie + "\"" +
                "}";
        System.out.println(generateJson);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);
        try(OutputStream os = con.getOutputStream()) {
            byte[] input = generateJson.getBytes();
            os.write(input, 0, input.length);
        }
        con.getResponseCode();
    }

}