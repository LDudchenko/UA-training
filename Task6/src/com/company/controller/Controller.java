package com.company.controller;

import com.company.model.Note;
import com.company.model.Notebook;
import com.company.view.View;

import java.util.Scanner;

/**
 * Created by Dudchenko Liudmila on 05.07.2021
 */
public class Controller {

    private Note note;
    private View view;
    private Notebook notebook;

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
        System.out.println(note.toString());
    }
}
