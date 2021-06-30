import java.util.LinkedHashSet;

public class Model {
    private int hiddenNumber;
    private int lowerLimit;

    private int higherLimit;

    private LinkedHashSet<Integer> attempts = new LinkedHashSet<>();

    public void setHiddenNumber(){
        hiddenNumber = (int)Math.ceil(Math.random()*
                (higherLimit - lowerLimit - 1) + lowerLimit);
    }

    public void setPrimaryLimits(int minBarrier, int maxBarrier){
        this.lowerLimit = minBarrier;
        this.higherLimit = maxBarrier;
    }

    public int getLowerLimit() {
        return lowerLimit;
    }

    public int getHigherLimit() {
        return higherLimit;
    }


    public int getHiddenNumber() {
        return hiddenNumber;
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
