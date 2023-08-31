import java.util.ArrayList;

public class EasyAi implements Ai{
    @Override
    public String guessNumber(){
        ArrayList<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numberList.add(i);
        }
        int indexToPop = 0;
        String returnList = "";
        for (int i = 0; i < 4; i++) {
            indexToPop =(int) (Math.random() * numberList.size());
            returnList += numberList.get(indexToPop);
            numberList.remove(indexToPop);
        }
        return returnList;
    }
}
