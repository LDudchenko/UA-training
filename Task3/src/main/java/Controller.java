import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        int number;
        int answer;

        Scanner sc = new Scanner(System.in);

        model.setPrimaryLimits(GlobalConstants.PRIMARY_MIN_BARRIER, GlobalConstants.PRIMARY_MAX_BARRIER);
        model.setHiddenNumber();

        view.printMessage(View.GREETING);

        do {
            number = inputIntValueWithScanner(sc);
            answer = model.guessingOfNumber(number);
            if (answer == 1) {
                view.printMessage(View.HIGHER_NUMBER);
            } else if (answer == -1) {
                view.printMessage(View.LOWER_NUMBER);
            }
            view.printMessage(View.STATISTIC + model.getAttempts() + "\n");
        } while (answer != 0);

        view.printMessageAndParam(View.SUCCESSFUL_INPUT, number);
    }

    public int inputIntValueWithScanner(Scanner sc) {
        int nextInt;
        view.printMessageAndTwoParams(View.INPUT_NUMBER, model.getLowerLimit(), model.getHigherLimit());
        while (true) {
            if (sc.hasNextInt()) {
                nextInt = sc.nextInt();
                if (nextInt > model.getLowerLimit() && nextInt < model.getHigherLimit()) {
                    return nextInt;
                } else {
                    view.printMessage(View.OUT_OF_BOUNDS);
                    view.printMessageAndTwoParams(View.INPUT_NUMBER, model.getLowerLimit(), model.getHigherLimit());

                }
            } else {
                view.printMessage(View.NOT_INTEGER_VALUE);
                view.printMessageAndTwoParams(View.INPUT_NUMBER, model.getLowerLimit(), model.getHigherLimit());
                sc.next();
            }
        }
    }
}
