/**
 * Created by Dudchenko Liudmila on 05.07.2021
 */
public class View {

    /**
     * String constants
     */
    public static final String INPUT_LASTNAME = "Enter your lastname, please: ";
    public static final String INPUT_LOGIN = "Enter your login, please: ";
    public static final String WRONG_INPUT = "Wrong input! Repeat please!\n";
    public static final String ENTERED_LASTNAME = "Lastname: ";
    public static final String ENTERED_LOGIN = "Login: ";
    public static final String REPEATED_INPUT = "Enter data again, please: ";

    /**
     * Method for printing message
     * @param message
     */
    public void printMessage(String message){
        System.out.println(message);
    }

    /**
     * Menhod for concatenation strings
     * @param strings
     * @return
     */
    public String concatenationStrings(String... strings){
        StringBuilder concatString = new StringBuilder();
        for (String v : strings){
            concatString = concatString.append(v);
        }
        return new String(concatString);
    }
}
