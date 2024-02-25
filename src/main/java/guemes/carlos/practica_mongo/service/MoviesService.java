package guemes.carlos.practica_mongo.service;

import guemes.carlos.practica_mongo.jpa.Movies;

import java.util.List;

public interface MoviesService {

    public List<Movies> findAll();

    public Movies findByTitle(String titulo);

    public List<Movies> findByGenres(List<String> generos);

}
