import java.util.ArrayList;

public abstract class Number {

    public int number;
    public int guessCount;
    public int bullsCount;

    public abstract int generateNumber();

    public abstract int guessNumber();

    public boolean isValidNumber(int checkedNumber) {
        ArrayList<Integer> tempNumberList = convertToList(checkedNumber);
        if (!tempNumberList.isEmpty()) {
            if (tempNumberList.size() != 4) {
                System.out.println("your input is not the right size, it has to be 4 digits long");
                return false;
            } else if (repeatDigits(tempNumberList)) {
                System.out.println("the digits have to be unique");
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean repeatDigits(ArrayList<Integer> i){
        for (int j = 0; j < i.size() - 1; j++) {
            ArrayList<Integer> m = new ArrayList<>(i);
            m.remove(j);
            if(m.contains(i.get(j))) {
                return true;
            }
        }return false;
    }

    public ArrayList<Integer> convertToList(int num){
        ArrayList<Integer> tempNumberList = new ArrayList<>();
        int tempNumberWhile = num;
        while (tempNumberWhile > 0) {
            tempNumberList.add(tempNumberWhile % 10);
            tempNumberWhile /= 10;
        }
        return tempNumberList;
    }

    public void printCowsAndBulls(int guess){
        ArrayList<Integer> guessList = convertToList(guess);
        ArrayList<Integer> correctNumberList = convertToList(this.number);
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < guessList.size(); i++) {
            if(guessList.get(i) == correctNumberList.get(i)){
                bulls++;
            }
        }
        for (int i = 0; i < guessList.size(); i++) {
            if (correctNumberList.contains(guessList.get(i))){
                cows++;
            }
        }
        cows = cows - bulls;
        bullsCount = bulls;
        System.out.println(String.format("Result: %d bull and %d cows", bulls, cows));
    }

}
