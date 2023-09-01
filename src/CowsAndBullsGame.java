public class CowsAndBullsGame {

    public void start(){
        PlayerNumber playersNumber = new PlayerNumber();
        ComputerNumber computersNumber = new ComputerNumber();

        computersNumber.setAiLevel();

        String playerBaseNumber = "";
        while (!playersNumber.isValidNumber(playerBaseNumber)){
            System.out.println("please enter your secret code:");
            playerBaseNumber = playersNumber.generateNumber();
        }
        playersNumber.number = playerBaseNumber;
        System.out.println(String.format("your code is %s", playersNumber.number));
        computersNumber.number = computersNumber.generateNumber();

//        System.out.println(playersNumber.number);
//        System.out.println(computersNumber.number);

        /*alter running code to include winning conditions based on turn, ie if i go first then i win*/
        int playerBulls = 0;
        int playerCows = 0;
        int computerBulls = 0;
        int computerCows = 0;

        while (playersNumber.guessCount < 7){
            System.out.printf("You guess:");
            String playerGuess = playersNumber.guessNumber();
            playerBulls = playersNumber.checkBulls(playerGuess, computersNumber.number);
            playerCows = playersNumber.checkCows(playerGuess, computersNumber.number);
            System.out.println(String.format("Result: %d bulls and %d cows", playerBulls, playerCows));
            if(playerBulls == 4){
                System.out.println("You win! :)");
                return;
            }

            String computerGuess = computersNumber.guessNumber();
            System.out.println(String.format("Computer Guess: %s", computerGuess));
            computerBulls = computersNumber.checkBulls(computerGuess, playersNumber.number);
            computerCows = computersNumber.checkCows(computerGuess, playersNumber.number);
            if(computersNumber.aiLevel instanceof HardAi){
                ((HardAi) computersNumber.aiLevel).setBullsAndCows(computerBulls, computerCows);
                ((HardAi) computersNumber.aiLevel).trimPossibleNumbers(computerGuess);
            }
            System.out.println(String.format("Result: %d bulls and %d cows", computerBulls, computerCows));
            System.out.println(((HardAi) computersNumber.aiLevel).possibleAnswers.size());
            System.out.println("-----------");

            if(computerBulls == 4){
                System.out.println(computersNumber.number);
                System.out.println("Computer wins! :)");
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
