package fr.univtours.polytech.tp_note_2.business;

import java.util.List;

import fr.univtours.polytech.tp_note_2.dao.DescriptionDao;
import fr.univtours.polytech.tp_note_2.model.Description;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class DescriptionBusinessImpl implements DescriptionBusiness {

    @Inject
    private DescriptionDao descriptionDao;

    @Override
    public List<Description> serachDescription(String search) {
        return this.descriptionDao.getDescription(search);
    }

}
