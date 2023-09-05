import java.security.Key;

public class Game {
    public static void main(String[] args) {
        System.out.println("welcome to AldenGamesInc");
        System.out.println("what game would you like to play?");
        System.out.println("1. Wordle");
        System.out.println("2. Bulls and Cows");
        System.out.println("3. Quit");

        String game = Keyboard.readInput().trim();
        if (game.equalsIgnoreCase("1") || game.equalsIgnoreCase("wordle")){
            Wordle m = new Wordle();
            m.start();
        } else if (game.equalsIgnoreCase("2") || game.equalsIgnoreCase("bulls") || game.equalsIgnoreCase("bulls and cows")|| game.equalsIgnoreCase("bullsandcows")) {
            CowsAndBullsGame m = new CowsAndBullsGame();
            m.start();
        } else if (game.equalsIgnoreCase("3") || game.equalsIgnoreCase("quit")) {
            System.out.println("thanks for playing! :)");
            return;
        }else {
            System.out.println("This is not a valid input");
        }

    }
}
