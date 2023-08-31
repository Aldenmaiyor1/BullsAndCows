import java.security.Key;
import java.util.ArrayList;

public class PlayerNumber extends Number{

    public Ai aiLevel;
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
