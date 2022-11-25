package fr.utbm.dvdstore.infrastructure.repository;

import fr.utbm.dvdstore.domain.entity.Movie;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JdbcMovieDao {

    public void save(Movie f) {
        savePrepareStatement(f);
    }

    public void saveStatement(Movie f) {
        Connection con = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/video", "video", "video");
            Statement s = con.createStatement();
            s.executeUpdate("INSERT INTO VIDEO.MOVIE(TITLE,COPIES,MOVIE_TYPE) VALUES('"
                    + f.getTitle() + "', "
                    + f.getCopies() + ", '"
                    + f.getMovieType() + "')");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }

    public void savePrepareStatement(Movie f) {
        Connection con = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/video", "video", "video");
            PreparedStatement ps = con
                    .prepareStatement("INSERT INTO VIDEO.MOVIE(TITLE,COPIES,MOVIE_TYPE) VALUES(?,?,?)");
            ps.setString(1, f.getTitle());
            ps.setInt(2, f.getCopies());
            ps.setString(3, f.getMovieType());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Movie> listFilm() {
        Connection con = null;
        ArrayList<Movie> films = new ArrayList<Movie>();

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/video", "video", "video");
            String query = "SELECT * FROM Movie";
            Statement statement = con.createStatement();
            ResultSet resultset = statement.executeQuery(query);
            while (resultset.next()) {
                Movie f = new Movie();
                f.setMovieType(resultset.getString("MOVIE_TYPE"));
                f.setCopies(resultset.getInt("COPIES"));
                f.setTitle(resultset.getString("TITLE"));
                films.add(f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return films;
    }
}
