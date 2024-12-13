package fr.univtours.polytech.tp_note_2.business;

import java.util.List;

import fr.univtours.polytech.tp_note_2.model.Description;

public interface DescriptionBusiness {

    public List<Description> serachDescription(String search);
}
