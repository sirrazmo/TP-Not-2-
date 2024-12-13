package fr.univtours.polytech.tp_note_2.controlleur;

import java.io.IOException;
import java.util.List;

import fr.univtours.polytech.tp_note_2.business.MovieBusiness;
import fr.univtours.polytech.tp_note_2.model.MovieBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/movies")
public class MoviesServlet extends HttpServlet {

    @Inject
    private MovieBusiness movieBusiness;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<MovieBean> movies = movieBusiness.getMovies();
        request.setAttribute("MOVIES_LIST", movies);
        request.getRequestDispatcher("/movies.jsp").forward(request, response);
    }
}
