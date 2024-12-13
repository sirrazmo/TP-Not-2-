package fr.univtours.polytech.tp_note_2.business;

import java.util.List;

import fr.univtours.polytech.tp_note_2.model.MovieBean;

public interface MovieBusiness {

    public List<MovieBean> getMovies();

    public MovieBean getMovieByTitle(String title);

    public MovieBean getMovieByNote(Integer note);

    public MovieBean getMovieById(Integer id);

    public MovieBean createMovie(MovieBean movieBean);

    public void updateMovie(MovieBean movieBean);

    public MovieBean upNote(Integer id);

    public MovieBean downNote(Integer id);

    public void deleteMovie(MovieBean movieBean);

}
