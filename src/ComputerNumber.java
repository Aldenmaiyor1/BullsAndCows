import java.util.ArrayList;

public class ComputerNumber extends Number{

    public Ai aiLevel;
    public int generateNumber() {
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
        return Integer.parseInt(returnList);
    }


    @Override
    public int guessNumber() {
        int playerGuess = 0;

        while(!isValidNumber(playerGuess)){
            playerGuess =Integer.parseInt(Keyboard.readInput());
        }
        this.guessCount++;
        return playerGuess;
    }

    public static void main(String[] args) {
        ComputerNumber m = new ComputerNumber();
        m.generateNumber();
        System.out.println(m.number);
    }
}
