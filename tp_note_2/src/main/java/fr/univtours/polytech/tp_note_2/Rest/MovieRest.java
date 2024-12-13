package fr.univtours.polytech.tp_note_2.Rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.univtours.polytech.tp_note_2.business.MovieBusiness;
import fr.univtours.polytech.tp_note_2.model.MovieBean;
import jakarta.ejb.EJB;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("v1.0.0")
public class MovieRest {

    @EJB
    private MovieBusiness movieBusiness;

    @Path("movies")
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<MovieBean> getMovies(@QueryParam("tri") String tri, @QueryParam("filtre") String filtre) {
        List<MovieBean> movies = this.movieBusiness.getMovies();
        List<MovieBean> resultats = new ArrayList<MovieBean>();
        if (null != filtre && !"".equals(filtre)) {
            for (MovieBean movieBean : movies) {
                if (filtre.equals(movieBean.getTitle())) {
                    resultats.add(movieBean);
                }
            }
        } else {
            resultats = movies;
        }

        if ("noteCroissante".equals(tri)) {
            Collections.sort(resultats, (a, b) -> a.getNote() < b.getNote() ? -1 : 1);
        }
        if ("noteDecroissante".equals(tri)) {
            Collections.sort(resultats, (a, b) -> a.getNote() < b.getNote() ? 1 : -1);
        }

        return resultats;
    }

    @GET
    @Path("movies/{titre}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public MovieBean getMovies(@PathParam("titre") String titre) {
        MovieBean movieBean = this.movieBusiness.getMovieByTitle(titre);
        return movieBean;
    }

    @GET
    @Path("movies/{note}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public MovieBean getMovies(@PathParam("note") Integer note) {
        MovieBean movieBean = this.movieBusiness.getMovieByNote(note);
        return movieBean;
    }

    @GET
    @Path("movies/id/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public MovieBean getMovieById(@PathParam("id") Integer idMovie) {
        MovieBean movieBean = this.movieBusiness.getMovieById(idMovie);
        return movieBean;
    }

    @POST
    @Path("movies")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public MovieBean createMovie(MovieBean movieBean) {
        return this.movieBusiness.createMovie(movieBean);
    }

    @PUT
    @Path("movies/{id}")
    public Response fullUpdateMovie(@PathParam("id") Integer idMovie, MovieBean nouveauMovie) {
        MovieBean ancienMovieBean = this.movieBusiness.getMovieById(idMovie);
        if (null == ancienMovieBean) {
            return Response.status(Status.NOT_FOUND).build();
        }

        ancienMovieBean.setNote(nouveauMovie.getNote());
        ancienMovieBean.setTitle(nouveauMovie.getTitle());

        this.movieBusiness.updateMovie(ancienMovieBean);
        return Response.status(Status.ACCEPTED).build();
    }

    @PATCH
    @Path("movies/{id}")
    public Response partialUpdateMovie(@PathParam("id") Integer idMovie, MovieBean nouveauMovie) {
        MovieBean ancienMovieBean = this.movieBusiness.getMovieById(idMovie);
        if (null == ancienMovieBean) {
            return Response.status(Status.NOT_FOUND).build();
        }

        if (null != nouveauMovie.getNote())
            ancienMovieBean.setNote(nouveauMovie.getNote());
        if (null != nouveauMovie.getTitle() && !"".equals(nouveauMovie.getTitle()))
            ancienMovieBean.setTitle(nouveauMovie.getTitle());

        this.movieBusiness.updateMovie(ancienMovieBean);
        return Response.status(Status.ACCEPTED).build();
    }

    @DELETE
    @Path("movies/{id}")
    public Response deleteMovie(@PathParam("id") Integer idMovie) {
        MovieBean movieBean = this.movieBusiness.getMovieById(idMovie);
        if (null == movieBean) {
            return Response.status(Status.NOT_FOUND).build();
        }

        this.movieBusiness.deleteMovie(movieBean);
        return Response.status(Status.ACCEPTED).build();
    }

}