/**
 * Created by User on 24.06.2021.
 */

public class View {
    //Text's constants
    public static final String INPUT_STRING_DATA = "Input string = ";
    public static final String WRONG_INPUT_STRING_DATA = "Wrong input! Repeat please!\n";
    public static final String OUR_STRING = "String data = ";

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printMessageAndString(String message, String value){
        System.out.println(message+value);
    }
}
