package fr.univtours.polytech.tp_note_2.dao;

import java.util.List;

import fr.univtours.polytech.tp_note_2.model.Description;
import fr.univtours.polytech.tp_note_2.model.WsMoviesResult;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

@Stateless
public class DescriptionDaoImpl implements DescriptionDao {
    private static String URL = "https://imdb.iamidiotareyoutoo.com";

    public List<Description> getDescription(String search) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(URL);

        target = target.path("search");
        target = target.queryParam("q", search);

        System.out.println(target.getUri());
        WsMoviesResult wsResult = target.request(MediaType.APPLICATION_JSON).get(WsMoviesResult.class);
        return wsResult.getDescription();
    }
}
