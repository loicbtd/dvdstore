package fr.utbm.dvdstore.api.controller;

import fr.utbm.dvdstore.domain.entity.Movie;
import fr.utbm.dvdstore.domain.service.MovieService;

import java.util.Scanner;

public class DefaultMovieController {

    public void registerMovieFromConsoleInput() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Titre ?");
        String titre = sc.nextLine();

        System.out.println("Genre ?");
        String genre = sc.nextLine();

        System.out.println("NbExemplaires ?");
        String nbExemplaires = sc.nextLine();

        Movie f = new Movie();
        f.setTitle(titre);
        f.setMovieType(genre);
        f.setCopies(Integer.parseInt(nbExemplaires));

        MovieService fs = new MovieService();
        fs.registerMovie(f);
    }
}
