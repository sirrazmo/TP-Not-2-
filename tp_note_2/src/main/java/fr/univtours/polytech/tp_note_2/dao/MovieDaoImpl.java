package fr.univtours.polytech.tp_note_2.dao;

import java.util.List;

import fr.univtours.polytech.tp_note_2.model.MovieBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class MovieDaoImpl implements MovieDao {

    @PersistenceContext(unitName = "Library")
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<MovieBean> getMovies() {
        Query requete = em.createNativeQuery("select * from MOVIE", MovieBean.class);
        return requete.getResultList();
    }

    @Override
    public MovieBean getMovie(Integer id) {
        return em.getReference(MovieBean.class, id);
    }

    @Override
    public MovieBean getMovieByTitle(String title) {
        return em.getReference(MovieBean.class, title);
    }

    @Override
    public MovieBean getMovieByNote(Integer note) {
        return em.getReference(MovieBean.class, note);
    }

    @Override
    public MovieBean createMovie(MovieBean MovieBean) {
        em.persist(MovieBean);
        return MovieBean;
    }

    @Override
    public MovieBean updateMovie(MovieBean MovieBean) {
        em.merge(MovieBean);
        return MovieBean;
    }

    @Override
    public MovieBean deleteMovie(MovieBean MovieBean) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteMovie'");
    }

}
