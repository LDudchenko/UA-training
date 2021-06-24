/**
 * Created by User on 24.06.2021.
 */

public class Model {
    private String firstPart;
    private String secondPart;
    private String sentence;

    //The Program logic

    /**
     * in this method make sentence from two parts
     */
    public void makeSentence() {
        this.sentence = firstPart + " " + secondPart;
    }

    public void setFirstPart(String firstPart) {
        this.firstPart = firstPart;
    }

    public void setSecondPart(String secondPart) {
        this.secondPart = secondPart;
    }

    public String getFirstPart() {
        return firstPart;
    }

    public String getSecondPart() {
        return secondPart;
    }

    public String getSentence(){
        return sentence;
    }

}
