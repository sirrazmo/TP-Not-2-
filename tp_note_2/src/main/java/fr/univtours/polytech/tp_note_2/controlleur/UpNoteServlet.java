package fr.univtours.polytech.tp_note_2.controlleur;

import java.io.IOException;

import fr.univtours.polytech.tp_note_2.business.MovieBusiness;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/upNote")
public class UpNoteServlet extends HttpServlet {

    @Inject
    private MovieBusiness movieBusiness;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        movieBusiness.upNote(id);
        response.sendRedirect("movies");
    }
}