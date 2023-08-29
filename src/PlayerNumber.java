import java.util.ArrayList;

public class PlayerNumber extends Number{

    @Override
    public void generateNumber() {
        boolean valid = false;
        while (!valid) {
            try {
                this.number = Integer.parseInt(Keyboard.readInput().trim());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("this is not a number");
            }
        }
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
