package fr.utbm.dvdstore.infrastructure.repository;

import fr.utbm.dvdstore.domain.entity.Movie;


import java.util.ArrayList;

import fr.utbm.dvdstore.domain.tools.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class HibernateMovieDao {

    Transaction transaction = null;

    public void save(Movie f) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(f);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public ArrayList<Movie> listFilm() {
        ArrayList<Movie> films = new ArrayList<Movie>();
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query q = session.createQuery("from Movie");
        films = (ArrayList<Movie>) q.list();
        return films;
    }

    public Movie getMovieById(Integer movieId) {
        System.out.println("A");
        Session session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("B");
        Query q = session.createQuery("from Movie where id = :idmovie");
        System.out.println("C");
        q.setParameter("idmovie", movieId);
        System.out.println("D");
        Movie movie = (Movie) q.uniqueResult();
        System.out.println("E");
        return movie;
    }

    public void update(Movie f) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(f);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

}
