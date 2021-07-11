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

    public void addNote(Note note){
        notes.add(note);
    }

    public List<Note> getNotes() {
        return notes;
    }
}
