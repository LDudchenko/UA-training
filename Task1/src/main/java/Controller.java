import java.util.Scanner;

/**
 * Created by User on 24.06.2021.
 */

public class Controller {

    private Model model;
    private View view;

    //Constructor
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    // The Work method
    public void processUser(){
        Scanner sc = new Scanner(System.in);

        model.setFirstPart(inputStringWithScanner(sc, 1));
        model.setSecondPart(inputStringWithScanner(sc, 2));
        model.makeSentence();

        view.printMessageAndString(View.OUR_STRING, model.getSentence());
    }

    public String inputStringWithScanner(Scanner sc, int numOfPart){
        String nextString = "";

        view.printMessage(View.INPUT_STRING_DATA);
        while(sc.hasNext()){
            nextString = sc.next();
            boolean isCorrect = (numOfPart == 1) ? checkFirstPart(nextString) : checkSecondPart(nextString);
            if(isCorrect) {
                break;
            } else{
                view.printMessage(View.WRONG_INPUT_STRING_DATA + View.INPUT_STRING_DATA);
            }
        }
        return nextString;
    }

    public boolean checkFirstPart(String firstPart){
        return firstPart.equals("Hello");
    }

    public boolean checkSecondPart(String secondPart){
        return secondPart.equals("world!");
    }

}
