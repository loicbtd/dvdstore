package fr.utbm.dvdstore.infrastructure.repository;

import fr.utbm.dvdstore.domain.entity.Movie;

public class ConsoleMovieDao {

    public void save(Movie f) {
        System.out.println(f.toString());
    }
}
