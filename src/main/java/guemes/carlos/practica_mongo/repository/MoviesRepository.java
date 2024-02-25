package guemes.carlos.practica_mongo.repository;

import guemes.carlos.practica_mongo.jpa.Movies;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MoviesRepository extends MongoRepository<Movies, String> {
    @Query(value = "{'title': ?0}")
    Movies findByTitle(String title);

    @Query(value = "{'genres': { $all: ?0 }}")
    List<Movies> findByGenres(List<String> genres);
}
