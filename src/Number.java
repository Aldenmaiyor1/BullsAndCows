import java.util.ArrayList;

public abstract class Number {
    public Ai aiLevel;
    public String number;
    public int guessCount;
    public int bullsCount;
    public int cowsCount;

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

    public int checkBulls(String guess, String correctNumber){
        ArrayList<String> guessList = convertToList(guess);
        ArrayList<String> correctNumberList = convertToList(correctNumber);
        int bulls = 0;
        for (int i = 0; i < guessList.size(); i++) {
            if(guessList.get(i).equals(correctNumberList.get(i))){
                bulls++;
            }
        }

        return bulls;
    }

    public int checkCows(String guess, String correctNumber){
        ArrayList<String> guessList = convertToList(guess);
        ArrayList<String> correctNumberList = convertToList(correctNumber);

        int cows = 0;
        for (int i = 0; i < guessList.size(); i++) {
            if (correctNumberList.contains(guessList.get(i))){
                cows++;
            }
        }
        cows = cows - checkBulls(guess, correctNumber);
        return cows;
    }

    public void setAiLevel(){
        System.out.println("please enter a difficulty");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");

        String difficulty = Keyboard.readInput().trim();

        if (difficulty.equalsIgnoreCase("easy")){
            System.out.println("you chose the easy ai");
            aiLevel = new EasyAi();
        } else if (difficulty.equalsIgnoreCase("medium")) {
            System.out.println("you chose the medium ai");
            aiLevel = new MediumAi();
        } else if (difficulty.equalsIgnoreCase("hard")) {
            System.out.println("you chose the hard ai");
            aiLevel = new HardAi();
        } else{
            System.out.println("you didnt chose any ai");
            return;
        }
    }

}
