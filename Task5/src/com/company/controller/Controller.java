package com.company.controller;

import com.company.model.Note;
import com.company.model.Notebook;
import com.company.view.View;

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
        String lastName;
        String login;
        String message;

        InputNote inputNote = new InputNote(view, sc, note);
        inputNote.inputNote();

//        view.printMessage(view.TextConstants.INPUT_LASTNAME);
//        lastName = inputStringWithScanner(sc, controller.Regex.REGEX_LASTNAME);
//        note.setLastName(lastName);
//
//        view.printMessage(view.TextConstants.INPUT_LOGIN);
//        login = inputStringWithScanner(sc, controller.Regex.REGEX_NICKNAME);
//        note.setLogin(login);
//
//        message = view.concatenationStrings(view.TextConstants.ENTERED_LASTNAME, note.getLastName());
//        view.printMessage(message);
//
//        message = view.concatenationStrings(view.TextConstants.ENTERED_LOGIN, note.getLogin());
//        view.printMessage(message);

        notebook.addNote(note);
    }
}
