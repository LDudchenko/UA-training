
public class Main {
    public static void main(String[] args) {
        Notebook notebook = new Notebook();
        Note note = new Note();
        View view = new View();
        Controller controller = new Controller(note, view, notebook);

        controller.processUser();
    }
}
