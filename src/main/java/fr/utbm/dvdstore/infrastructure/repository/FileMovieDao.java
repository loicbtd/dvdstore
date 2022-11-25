package fr.utbm.dvdstore.infrastructure.repository;

import fr.utbm.dvdstore.domain.entity.Movie;
import java.io.FileWriter;

public class FileMovieDao {

    public void save(Movie f) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("films.csv", true);
            fileWriter.write(f.getTitle() + ";" + f.getMovieType() + ";" + f.getCopies() + "\n");
            fileWriter.close();
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("Erreur");
        }
    }
}
