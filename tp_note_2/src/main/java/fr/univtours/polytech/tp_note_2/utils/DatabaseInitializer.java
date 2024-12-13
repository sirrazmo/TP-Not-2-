package fr.univtours.polytech.tp_note_2.utils;

import fr.univtours.polytech.tp_note_2.business.MovieBusiness;
import fr.univtours.polytech.tp_note_2.model.MovieBean;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class DatabaseInitializer {

    @Inject
    private MovieBusiness movieBusiness;

    @PostConstruct
    public void init() {
        MovieBean bean1 = insertBeanInDB("Die hard");
        movieBusiness.createMovie(bean1);

        MovieBean bean2 = insertBeanInDB("La soupe au chou");
        movieBusiness.createMovie(bean2);

        MovieBean bean3 = insertBeanInDB("Le cerveau");
        movieBusiness.createMovie(bean3);

        MovieBean bean4 = insertBeanInDB("La grande vadrouille");
        movieBusiness.createMovie(bean4);
    }

    /**
     * Permet d'inserer un enregistrement en BDD.
     * 
     * @param title
     * @param note
     */
    private MovieBean insertBeanInDB(String title) {
        MovieBean bean = new MovieBean();

        bean.setTitle(title);
        bean.setNote(null);

        return bean;
    }
}
