package fr.univtours.polytech.tp_note_2.business;

import java.util.List;

import fr.univtours.polytech.tp_note_2.dao.MovieDao;
import fr.univtours.polytech.tp_note_2.model.MovieBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class MovieBusinessImpl implements MovieBusiness {

    @Inject
    private MovieDao movieDao;

    @Override
    public List<MovieBean> getMovies() {
        List<MovieBean> movies = this.movieDao.getMovies();
        for (MovieBean movieBean : movies) {
            movieBean.setUrl1("<a href=\"upNote?id=" + movieBean.getId() + "\"> + </a>");
            movieBean.setUrl2("<a href=\"downNote?id=" + movieBean.getId() + "\"> - </a>");
        }
        return movies;
    }

    @Override
    public MovieBean getMovieByTitle(String title) {
        return movieDao.getMovieByTitle(title);
    }

    @Override
    public MovieBean getMovieByNote(Integer note) {
        return movieDao.getMovieByNote(note);
    }

    @Override
    public MovieBean getMovieById(Integer id) {
        return movieDao.getMovie(id);
    }

    @Override
    public MovieBean createMovie(MovieBean movieBean) {
        return this.movieDao.createMovie(movieBean);
    }

    @Override
    public MovieBean upNote(Integer id) {
        MovieBean movieBean = this.movieDao.getMovie(id);
        if (movieBean.getNote() == null) {
            movieBean.setNote(1);
        } else {
            Integer note = movieBean.getNote();
            if (note >= 0 && note < 5) {
                movieBean.setNote(note + 1);
            }
        }
        return movieBean;
    }

    @Override
    public MovieBean downNote(Integer id) {
        MovieBean movieBean = this.movieDao.getMovie(id);
        if (movieBean.getNote() == null) {
            movieBean.setNote(5);
        } else {
            Integer note = movieBean.getNote();
            if (note > 0 && note <= 5) {
                movieBean.setNote(note - 1);
            }
        }
        return movieBean;
    }

    @Override
    public void updateMovie(MovieBean movieBean) {
        movieDao.updateMovie(movieBean);
    }

    @Override
    public void deleteMovie(MovieBean movieBean) {
        movieDao.deleteMovie(movieBean);
    }
}
