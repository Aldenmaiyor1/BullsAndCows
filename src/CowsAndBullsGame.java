public class CowsAndBullsGame {

    public void start(){
        PlayerNumber playersNumber = new PlayerNumber();
        ComputerNumber computersNumber = new ComputerNumber();

        playersNumber.setAiLevel();

        int playerBaseNumber = 0;
        while (!playersNumber.isValidNumber(playerBaseNumber)){
            System.out.println("please enter your secret code:");
            playerBaseNumber = playersNumber.generateNumber();
        }
        playersNumber.number = playerBaseNumber;
        System.out.println(String.format("your code is %d", playersNumber.number));
        computersNumber.number = computersNumber.generateNumber();

        System.out.println(playersNumber.number);
        System.out.println(computersNumber.number);

        /*alter running code to include winning conditions based on turn, ie if i go first then i win*/
        while (computersNumber.guessCount < 7){
            System.out.printf("You guess:");
            int playerGuess = computersNumber.guessNumber();
            computersNumber.printCowsAndBulls(playerGuess);
            int computerGuess = playersNumber.guessNumber();
            System.out.println(String.format("Computer Guess: %d", computerGuess));
            playersNumber.printCowsAndBulls(computerGuess);
            System.out.println("---");
            if(computersNumber.bullsCount == 4){
                System.out.println("You win! :)");
                return;
            }
        }
        System.out.println("you lose loser ");
    }
    public static void main(String[] args) {
        CowsAndBullsGame cowsAndBulls = new CowsAndBullsGame();
        cowsAndBulls.start();
    }
}
