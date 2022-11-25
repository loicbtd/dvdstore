package fr.utbm.dvdstore.api.controller;

import fr.utbm.dvdstore.domain.entity.Movie;
import fr.utbm.dvdstore.domain.service.MovieService;

import java.util.Scanner;

public class SearchMovieController {

    public void searchMovieFromConsoleInput() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Id Movie ?");
        String idmovie = sc.nextLine();

        System.out.println("Nouveau Titre ?");
        String titre = sc.nextLine();

        MovieService fs = new MovieService();
        Movie movie = fs.searchMovieById(Integer.parseInt(idmovie));
        System.out.println("Movie : " + movie.toString());
        movie.setTitle(titre);
        fs.updateMovie(movie);
    }
}
