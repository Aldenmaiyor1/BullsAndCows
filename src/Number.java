import java.util.ArrayList;

public abstract class Number {

    public int number;
    public int guessCount;

    public abstract void generateNumber();

    public abstract void guessNumber();

    public boolean isValidNumber() {
        ArrayList<Integer> tempNumberList = new ArrayList<>();
        int tempNumberWhile = this.number;
        while (tempNumberWhile > 0) {
            tempNumberList.add(tempNumberWhile % 10);
            tempNumberWhile /= 10;
        }
        if (!tempNumberList.isEmpty()) {
            if (tempNumberList.size() != 4) {
                System.out.println("your input is not the right size, it has to be 4 digits long");
                return false;
            } else if (repeatDigits(tempNumberList)) {
                System.out.println("the digits have to be unique");
                return false;
            }
            System.out.println(String.format("your code is %d", this.number));
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

}
