import java.util.ArrayList;

public class PlayerNumber extends Number{

    @Override
    public int generateNumber() {
        boolean valid = false;
        int returnNumber=0;
        while (!valid) {
            try {
                returnNumber = Integer.parseInt(Keyboard.readInput().trim());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("this is not a number");
            }
        }
        return returnNumber;
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
