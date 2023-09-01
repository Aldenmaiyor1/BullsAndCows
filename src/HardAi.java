import java.lang.reflect.Array;
import java.util.ArrayList;


public class HardAi extends ComputerNumber implements Ai{
    public ArrayList<String> possibleAnswers;

    public HardAi(String number){
        this.possibleAnswers = setPossibleAnswers();
        this.number = number;
    }
    public String guessNumber(){
        int guessedIndex = (int) (Math.random() * (possibleAnswers.size() +1));
        String guess = possibleAnswers.get(guessedIndex);
        trimPossibleNumbers(guess);
        return guess;
    }


    public void trimPossibleNumbers(String guess){
        for (int i = 0; i < possibleAnswers.size(); i++) {
            if (!sameBullsAndCows(possibleAnswers.get(i), guess)){
                this.possibleAnswers.remove(i);
            }
        }
    }
   public boolean sameBullsAndCows(String possibleNumber, String guess){
        int potCows = 0;
        int potBulls = 0;
        ArrayList<String> possibleNumberArray = convertToList(possibleNumber);
        ArrayList<String> guessArray = convertToList(guess);
       for (int i = 0; i < possibleNumberArray.size(); i++) {
           if (possibleNumberArray.get(i).equals(guessArray.get(i))){
               potBulls ++;
           }
       }
       for (int i = 0; i < possibleNumberArray.size(); i++) {
           if (possibleNumberArray.contains(guessArray.get(i))){
               potCows++;
           }
       }
       potCows = potCows-potBulls;
       if (potBulls == this.bullsCount && potCows == this.cowsCount){
           return true;
       }
        return false;
   }

    public String generateNumber(){

        return "hello";
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

}
