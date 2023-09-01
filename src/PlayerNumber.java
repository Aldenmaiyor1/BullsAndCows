import java.security.Key;
import java.util.ArrayList;

public class PlayerNumber extends Number{

    @Override
    public String generateNumber() {
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
        return String.valueOf(returnNumber);
    }

    @Override
    public String guessNumber() {
        return aiLevel.guessNumber();
    }

    public static void main(String[] args) {
        PlayerNumber m = new PlayerNumber();
        m.generateNumber();
        System.out.println(m.number);
    }
}
