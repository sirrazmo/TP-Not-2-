package fr.univtours.polytech.tp_note_2.controlleur;

import java.io.IOException;
import java.util.ArrayList;

import fr.univtours.polytech.tp_note_2.business.DescriptionBusiness;
import fr.univtours.polytech.tp_note_2.model.Description;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("searchDescription")
public class DescriptionServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("DESCRIPTION", new ArrayList<Description>());
        request.getRequestDispatcher("movies.jsp").forward(request, response);
    }

}
