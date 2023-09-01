import java.security.Key;
import java.util.ArrayList;

public class PlayerNumber extends Number{

    @Override
    public String generateNumber() {
        boolean valid = false;
        int returnNumber=0;
        String returnNumberString= "";
        while (!valid) {
            try {
                returnNumber = Integer.parseInt(Keyboard.readInput().trim());
                returnNumberString = String.valueOf(returnNumber);
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("this is not a number");
            }
        }

        if (String.valueOf(returnNumber).length() == 3){
            returnNumberString = "0"+returnNumber;
        }
        return returnNumberString;
    }

    @Override
    public String guessNumber() {
        String playerGuess = "";

        while (!isValidNumber(playerGuess)) {
            playerGuess = Keyboard.readInput();
        }
        this.guessCount++;
        return playerGuess;
    }

    public static void main(String[] args) {
        PlayerNumber m = new PlayerNumber();
        m.generateNumber();
        System.out.println(m.number);
    }
}
