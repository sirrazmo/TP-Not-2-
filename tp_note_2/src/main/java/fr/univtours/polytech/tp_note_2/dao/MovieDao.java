package fr.univtours.polytech.tp_note_2.dao;

import java.util.List;

import fr.univtours.polytech.tp_note_2.model.MovieBean;

public interface MovieDao {

    public List<MovieBean> getMovies();

    public MovieBean getMovie(Integer id);

    public MovieBean getMovieByTitle(String title);

    public MovieBean getMovieByNote(Integer note);

    public MovieBean createMovie(MovieBean MovieBean);

    public MovieBean updateMovie(MovieBean MovieBean);

    public MovieBean deleteMovie(MovieBean MovieBean);
}
