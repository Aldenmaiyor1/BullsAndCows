import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;


public class HardAi implements Ai{
    public ArrayList<String> possibleAnswers;
    public int bullsCount;
    public int cowsCount;


    public HardAi(){
        this.possibleAnswers = setPossibleAnswers();
        bullsCount = 10;
        cowsCount = 10;
    }
    public String guessNumber(){
        int guessedIndex = (int) (Math.random() * (this.possibleAnswers.size()));
        String guess = this.possibleAnswers.get(guessedIndex);
        return guess;
    }

    public void trimPossibleNumbers(String guess){
        ArrayList<String> posNum = new ArrayList<>();
        for (int i = 0; i < possibleAnswers.size(); i++) {
            if (sameBullsAndCows(possibleAnswers.get(i), guess)){
                posNum.add(possibleAnswers.get(i));
            }
        }
        this.possibleAnswers = posNum;
    }

    public void setBullsAndCows(int bulls, int cows){
        this.bullsCount = bulls;
        this.cowsCount = cows;
    }

    public boolean sameBullsAndCows(String possibleNumber, String guess) {
        int potCows = 0;
        int potBulls = 0;
        ArrayList<String> possibleNumberArray = convertToList(possibleNumber);
        ArrayList<String> guessArray = convertToList(guess);
        for (int i = 0; i < possibleNumberArray.size(); i++) {
            if (possibleNumberArray.get(i).equals(guessArray.get(i))) {
                potBulls++;
            } else if (possibleNumberArray.contains(guessArray.get(i))) {
                potCows++;
            }
        }
        if (this.bullsCount == 10 || (potBulls == this.bullsCount && potCows == this.cowsCount)) {
            return true;
        }
        return false;
    }


    public boolean repeatDigits(String strang){
        ArrayList<String> i = new ArrayList<>();
        for (int k = 0; k < strang.length(); k++) {
            i.add(String.valueOf(strang.charAt(k)));
        }
        for (int j = 0; j < i.size() - 1; j++) {
            ArrayList<String> m = new ArrayList<>(i);
            m.remove(j);
            if(m.contains(i.get(j))) {
                return true;
            }
        }return false;
    }
    public ArrayList<String> setPossibleAnswers(){
        ArrayList<String> possibleAnswerList = new ArrayList<>();

        for (int i = 0; i < 9999; i++) {
            String num = String.valueOf(i);
            if(num.length() == 3){
                num = "0" +num;
            }
            if (!repeatDigits(num) && num.length()==4){
                possibleAnswerList.add(num);
            }
        }
        return possibleAnswerList;
    }

    public ArrayList<String> convertToList(String num){
        ArrayList<String> tempNumberList = new ArrayList<>();
        for (int i = 0; i < num.length(); i++) {
            tempNumberList.add(String.valueOf(num.charAt(i)));
        }
        return tempNumberList;
    }

}
