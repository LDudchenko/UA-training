package com.company.controller;

import com.company.model.Note;
import com.company.model.Notebook;
import com.company.view.View;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Created by Dudchenko Liudmila on 05.07.2021
 */
public class Controller {

    /**
     * Field for note
     */
    private Note note;
    /**
     * Field for view
     */
    private View view;
    /**
     * Field for notebook
     */
    private Notebook notebook;

    /**
     * Constructor
     * @param note
     * @param view
     * @param notebook
     */
    public Controller(Note note, View view, Notebook notebook){
        this.note = note;
        this.view = view;
        this.notebook = notebook;
    }

    /**
     * Method for processing data
     */
    public void processUser(){
        Scanner sc = new Scanner(System.in);

        InputNote inputNote = new InputNote(view, sc, note);
        inputNote.inputNote();

        notebook.addNote(note);
        note.formLastNameAndFirstLetterOfName();
        System.out.println(note.getLastName()+"\n"+note.getName()+"\n"+note.getPatronymic()+"\n"+note.getFullName()+"\n"+note.getFullName());
    }
}
