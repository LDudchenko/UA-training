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

        view.printMessage(View.INPUT_LASTNAME);
        lastName = inputStringWithScanner(sc, Regex.REGEX_LASTNAME);
        note.setLastName(lastName);

        view.printMessage(View.INPUT_LOGIN);
        login = inputStringWithScanner(sc, Regex.REGEX_NICKNAME);
        note.setLogin(login);

        message = view.concatenationStrings(View.ENTERED_LASTNAME, note.getLastName());
        view.printMessage(message);

        message = view.concatenationStrings(View.ENTERED_LOGIN, note.getLogin());
        view.printMessage(message);

        notebook.addNote(note);
    }

    /**
     * Method for readind data which user enter
     * @param sc
     * @param regex
     * @return
     */
    public String inputStringWithScanner(Scanner sc, String regex){
        String nextString = "";
        while(sc.hasNext()){
            nextString = sc.nextLine();
            boolean isCorrect = nextString.matches(regex);
            if(isCorrect) {
                break;
            } else{
                view.printMessage(View.WRONG_INPUT + View.REPEATED_INPUT);
            }
        }
        return nextString;
    }
}
