import java.util.ArrayList;

public class MediumAi implements Ai{

    public ArrayList<Integer> guessedNumbers = new ArrayList<>();

    public int guessNumber(){
        ArrayList<Integer> numberList = new ArrayList<>();
        int guessedNum = 0;
        String returnList="";

        while(!guessedNumbers.contains(guessedNum)) {
            for (int i = 0; i < 10; i++) {
                numberList.add(i);
            }
            int indexToPop = 0;
            returnList = "";
            for (int i = 0; i < 4; i++) {
                indexToPop = (int) (Math.random() * numberList.size());
                returnList += numberList.get(indexToPop);
                numberList.remove(indexToPop);
            }
        }
        guessedNum = Integer.parseInt(returnList);
        this.guessedNumbers.add(guessedNum);
        return guessedNum;
    }
}
