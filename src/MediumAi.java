import java.util.ArrayList;

public class MediumAi implements Ai{

    public ArrayList<String> guessedNumbers = new ArrayList<>();

    public String guessNumber(){
        ArrayList<String> numberList = new ArrayList<>();
        String guessedNum = "";
        String returnList="";

        while(guessedNumbers.contains(guessedNum)) {
            numberList.clear();
            for (int i = 0; i < 10; i++) {
                numberList.add(String.valueOf(i));
            }
            int indexToPop = 0;
            returnList = "";
            for (int i = 0; i < 4; i++) {
                indexToPop = (int) (Math.random() * numberList.size());
                returnList += numberList.get(indexToPop);
                numberList.remove(indexToPop);
            }
            guessedNum = returnList;
        }
        this.guessedNumbers.add(guessedNum);
        return guessedNum;
    }
}
