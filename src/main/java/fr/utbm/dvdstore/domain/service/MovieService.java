package fr.utbm.dvdstore.domain.service;

import fr.utbm.dvdstore.domain.entity.Movie;
import fr.utbm.dvdstore.infrastructure.repository.ConsoleMovieDao;
import fr.utbm.dvdstore.infrastructure.repository.FileMovieDao;
import fr.utbm.dvdstore.infrastructure.repository.HibernateMovieDao;
import fr.utbm.dvdstore.infrastructure.repository.JdbcMovieDao;

import java.util.ArrayList;

public class MovieService {

    public void registerMovie(Movie f) {
        ConsoleMovieDao cfd = new ConsoleMovieDao();
        FileMovieDao ffd = new FileMovieDao();

        JdbcMovieDao jfd = new JdbcMovieDao();
        HibernateMovieDao hfd = new HibernateMovieDao();
        cfd.save(f);
        ffd.save(f);
        jfd.save(f);
        hfd.save(f);

        ArrayList<Movie> list = jfd.listFilm();
        for (Movie film : list) {
            cfd.save(film);
            ffd.save(film);
        }
    }

    public Movie searchMovieById(int idMovie) {
        HibernateMovieDao hfd = new HibernateMovieDao();
        return hfd.getMovieById(idMovie);
    }

    public void updateMovie(Movie movie) {
        HibernateMovieDao hfd = new HibernateMovieDao();
        hfd.update(movie);
    }
}
