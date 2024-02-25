package guemes.carlos.practica_mongo.service;

import guemes.carlos.practica_mongo.jpa.Movies;
import guemes.carlos.practica_mongo.repository.EmpleadoRepository;
import guemes.carlos.practica_mongo.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesServiceImpl implements MoviesService {

    @Autowired
    private MoviesRepository moviesRepository;

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
}
