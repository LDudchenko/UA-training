package com.company;

import com.company.controller.AlreadyExistedLogin;
import com.company.controller.Controller;
import com.company.model.Note;
import com.company.model.Notebook;
import com.company.view.View;

public class Main {

    public static void main(String[] args) throws AlreadyExistedLogin {
        Notebook notebook = new Notebook();

        //note for creating collision
        Note note = new Note(notebook);
        note.setLogin("sun23");
        notebook.addNote(note);

        Controller controller = new Controller(new Note(notebook), new View(), notebook);

        // Run
        controller.processUser();
    }
}
