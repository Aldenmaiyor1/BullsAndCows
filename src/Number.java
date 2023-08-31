import java.util.ArrayList;

public abstract class Number {

    public String number;
    public int guessCount;
    public int bullsCount;

    public abstract String generateNumber();

    public abstract String guessNumber();

    public boolean isValidNumber(String checkedNumber) {
        ArrayList<String> tempNumberList = convertToList(checkedNumber);
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

    public boolean repeatDigits(ArrayList<String> i){
        for (int j = 0; j < i.size() - 1; j++) {
            ArrayList<String> m = new ArrayList<>(i);
            m.remove(j);
            if(m.contains(i.get(j))) {
                return true;
            }
        }return false;
    }

    public ArrayList<String> convertToList(String num){
        ArrayList<String> tempNumberList = new ArrayList<>();
        for (int i = 0; i < num.length(); i++) {
            tempNumberList.add(String.valueOf(num.charAt(i)));
        }
        return tempNumberList;
    }

    public void printCowsAndBulls(String guess){
        ArrayList<String> guessList = convertToList(guess);
        ArrayList<String> correctNumberList = convertToList(this.number);
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
