import com.mysql.cj.protocol.Message;

public class View {
    public static final String INPUT_NUMBER = "Enter an integer in the range of %d and %d: ";
    public static final String HIGHER_NUMBER = "The hidden number is higher.";
    public static final String LOWER_NUMBER = "The hidden number is lower.";
    public static final String NOT_INTEGER_VALUE = "It`s not an integer! Please, try again.\n";
    public static final String OUT_OF_BOUNDS = "It`s out of bounds! Please, try again.\n";
    public static final String SUCCESSFUL_INPUT = "Yes, you are absolutely right! The number is ";
    public static final String STATISTIC = "Statistic (your attempts):";
    public static final String GREETING = "Hi! In this game you need to guess the number, which I am thinking of.\n";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMessageAndParam(String message, int value) {
        System.out.println(message + value);
    }

    public void printMessageAndTwoParams(String message, int parameter1, int parameter2) {
        System.out.printf(message, parameter1, parameter2);
    }

}
