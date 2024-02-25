package guemes.carlos.practica_mongo.service;

import guemes.carlos.practica_mongo.jpa.Empleados;
import guemes.carlos.practica_mongo.jpa.Movies;

import java.util.List;

public interface MoviesService {

    public int savePelicula(Movies pelicula);

    public List<Movies> findAll();

    public Movies findByTitle(String titulo);

    public List<Movies> findByGenres(List<String> generos);

    public Movies updatePelicula(String id, String titulo, int anyo);

    public int deletePelicula(String id);

}
