package com.company.controller;

import com.company.model.Note;
import com.company.view.View;
import java.util.Scanner;

import static com.company.view.TextConstant.REPEATED_INPUT;
import static com.company.view.TextConstant.WRONG_INPUT;

/**
 * Created by Dudchenko Liudmila on 07.07.2021
 */
public class UtilityController {
    private Scanner sc;
    private View view;
    private Note note;

    public UtilityController(Scanner scanner, View view, Note note){
        this.sc = scanner;
        this.view = view;
        this.note = note;
    }

    /**
     * Method for readind data which user enter
     * @param message
     * @param regex
     * @return
     */
    public String inputStringWithScanner(String message, String regex){
        String nextString = "";

        view.printMessage(View.bundle.getString(message));

        while(sc.hasNext()){
            nextString = sc.nextLine();
            boolean isCorrect = nextString.matches(regex);
            if(isCorrect) {
                break;
            } else{
                view.printMessage(View.bundle.getString(WRONG_INPUT) + View.bundle.getString(REPEATED_INPUT));
            }
        }
        return nextString;
    }
}
