package guemes.carlos.practica_mongo.service;

import guemes.carlos.practica_mongo.jpa.Empleados;
import guemes.carlos.practica_mongo.jpa.Movies;
import guemes.carlos.practica_mongo.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesServiceImpl implements MoviesService {

    @Autowired
    private MoviesRepository moviesRepository;

    @Override
    public int savePelicula(Movies pelicula) {
        Movies result = moviesRepository.save(pelicula);
        return null==result?0:1;
    }

    @Override
    public List<Movies> findAll() {
        return moviesRepository.findAll();
    }

    @Override
    public Movies findByTitle(String titulo) {
        Movies pelicula = null;
        boolean encontrada = true;

        try{
            pelicula = moviesRepository.findByTitle(titulo);
        }
        catch (Exception e){
            encontrada = false;
        }

        if (encontrada){
            return pelicula;
        }

        else{
            System.out.println("No se ha encontrado ninguna película con ese título");
            return null;
        }
    }

    @Override
    public List<Movies> findByGenres(List<String> generos) {
        return moviesRepository.findByGenres(generos);
    }

    @Override
    public Movies updatePelicula(String id, String titulo, int anyo) {
        Movies pelicula = null;
        boolean encontrado = true;
        try{
            pelicula = moviesRepository.findById(id).get();

        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            encontrado = false;
        }

        if (encontrado){
            pelicula.setTitle(titulo);
            pelicula.setYear(anyo);
            return pelicula;
        }
        else
            return null;
    }

    @Override
    public int deletePelicula(String id) {
        Movies pelicula = null;

        try{
            pelicula = moviesRepository.findById(id).get();
        }
        catch (Exception e){
            System.out.println("Error al conseguir pelicula");
        }

        return pelicula==null?0:1;
    }
}
