import java.util.ArrayList;

public class PlayerNumber extends Number{

    @Override
    public void generateNumber(){
        boolean valid = false;
        boolean valid1 = false;
        int tempNumber = 0;
        while (valid == false) {
            System.out.println("please enter your secret code");
            valid1 = false;
            while (valid1 == false) {
                try {
                    tempNumber = Integer.parseInt(Keyboard.readInput());
                    valid1 = true;
                } catch (NumberFormatException e) {
                    System.out.println("this is not a number");
                }
            }
            ArrayList<Integer> tempNumberList = new ArrayList<>();
            int tempNumberWhile = tempNumber;
            while(tempNumberWhile>0){
                tempNumberList.add(tempNumberWhile%10);
                tempNumberWhile /= 10;
            }
            System.out.println(tempNumberList.size());
                if (tempNumberList.size() != 4) {
                    System.out.println("your input is not the right size, it has to be 4 digits long");
                } else if (repeatDigits(tempNumberList)) {
                    System.out.println("the digits have to be unique")  ;
                } else {
                    valid=true;
                }

        }
        this.number = Integer.toString(tempNumber);
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

    @Override
    public void guessNumber() {

    }

    public static void main(String[] args) {
        PlayerNumber m = new PlayerNumber();
        m.generateNumber();
        System.out.println(m.number);
    }
}
