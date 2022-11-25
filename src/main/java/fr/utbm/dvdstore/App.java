package fr.utbm.dvdstore;

import fr.utbm.dvdstore.api.controller.SearchMovieController;
import fr.utbm.dvdstore.domain.tools.HibernateUtil;

public class App {
  public static void main(String[] args) {
    SearchMovieController sfc = new SearchMovieController();
    sfc.searchMovieFromConsoleInput();
    HibernateUtil.shutdown();
  }
}