package com.company;

import com.company.controller.Controller;
import com.company.model.Note;
import com.company.model.Notebook;
import com.company.view.View;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Controller controller =
                new Controller(new Note(), new View(), new Notebook());
        // Run
        controller.processUser();
    }
}
