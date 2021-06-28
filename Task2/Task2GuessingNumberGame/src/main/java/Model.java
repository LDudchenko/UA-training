import java.util.LinkedHashSet;

public class Model {
    private int hiddenNumber;
    private int lowerLimit;
    private int higherLimit;
    private LinkedHashSet<Integer> attempts;

    public Model() {
        lowerLimit = 0;
        higherLimit = 100;
        hiddenNumber = (int) ((Math.random() * (higherLimit - lowerLimit)) + lowerLimit);
        System.out.println(hiddenNumber);
        attempts = new LinkedHashSet<>();
    }

    public Model(int lowerLimit, int higherLimit) {
        this.lowerLimit = lowerLimit;
        this.higherLimit = higherLimit;
        hiddenNumber = (int) ((Math.random() * (higherLimit - lowerLimit)) + lowerLimit);
        attempts = new LinkedHashSet<>();
    }

    public int getLowerLimit() {
        return lowerLimit;
    }

    public int getHigherLimit() {
        return higherLimit;
    }

    public String getAttempts() {
        return attempts.toString();
    }

    public int guessingOfNumber(int number) {
        attempts.add(number);
        if (number == hiddenNumber) {
            return 0;
        } else if (hiddenNumber > number) {
            lowerLimit = number;
            return 1;
        } else {
            higherLimit = number;
            return -1;
        }
    }

}
