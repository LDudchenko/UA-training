package com.company.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dudchenko Liudmila on 05.07.2021
 */
public class Notebook {
    /**
     * Field for storing noted in models.Notebook
     */
    private List<Note> notes = new ArrayList<>();

    /**
     * Method for adding notes
     * @param note
     */
    public void addNote(Note note){
        notes.add(note);
    }

    /**
     * Method for getting list of notes
     * @return list of notes
     */
    public List<Note> getNotes() {
        return notes;
    }
}
