package com.company.controller;

import com.company.model.Note;
import com.company.view.View;

import java.util.Scanner;

import static com.company.controller.RegexContainer.*;
//import static com.company.controller.RegexContainer.REGEX_LOGIN;
import static com.company.view.TextConstant.*;
import static com.company.view.TextConstant.INPUT_LOGIN;

/**
 * Created by Dudchenko Liudmila on 05.07.2021
 */
public class InputNote {
    private View view;
    private Scanner sc;
    private Note note;

    /**
     * Constructor
     * @param view - view
     * @param sc - scanner
     * @param note - note
     */
    public InputNote(View view, Scanner sc, Note note){
        this.view = view;
        this.sc = sc;
        this.note = note;
    }

    /**
     * Method for getting information
     */
    public void inputNote() {
        UtilityController utilityController =
                new UtilityController(sc, view, note);
        boolean isUkrainian = String.valueOf(View.bundle.getLocale()).equals("ua");

        String str = isUkrainian ? REGEX_LASTNAME_UKR : REGEX_LASTNAME_ENG;
        note.setLastName(utilityController.inputStringWithScanner
                (INPUT_LASTNAME, str));

        str = isUkrainian ? REGEX_NAME_UKR : REGEX_NAME_ENG;
        note.setName(utilityController.inputStringWithScanner
                (INPUT_NAME, str));

        str = isUkrainian ? REGEX_PATRONYMIC_UKR : REGEX_PATRONYMIC_ENG;
        note.setPatronymic(utilityController.inputStringWithScanner
                (INPUT_PATRONYMIC, str));

        note.setLogin(utilityController.inputStringWithScanner
                        (INPUT_LOGIN, REGEX_NICKNAME));
    }

}
