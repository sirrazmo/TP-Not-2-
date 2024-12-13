package fr.univtours.polytech.tp_note_2.dao;

import java.util.List;

import fr.univtours.polytech.tp_note_2.model.Description;

public interface DescriptionDao {
    public List<Description> getDescription(String search);
}
