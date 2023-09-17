import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CowsAndBullsGame{

    private int playerWin;

    public void start(){
        PlayerNumber playersNumber = new PlayerNumber();
        ComputerNumber computersNumber = new ComputerNumber();

        computersNumber.setAiLevel();

        String playerBaseNumber = "";
        while (!playersNumber.isValidNumber(playerBaseNumber)){
            System.out.println("please enter your secret code:");
            playerBaseNumber = playersNumber.generateNumber();
        }
        playersNumber.setNumber(playerBaseNumber);
        System.out.println(String.format("your code is %s", playersNumber.getNumber()));
        computersNumber.setNumber(computersNumber.generateNumber());
        System.out.println("computers code is " + computersNumber.getNumber());

        /*alter running code to include winning conditions based on turn, ie if i go first then i win*/
        int playerBulls = 0;
        int playerCows = 0;
        int computerBulls = 0;
        int computerCows = 0;

        Map<String,ArrayList<String>> output = new HashMap<String,ArrayList<String>>();

        while (playersNumber.guessCount < 8){
            String x = String.valueOf(playersNumber.guessCount);
            output.put(x, new ArrayList<>());
            System.out.printf("You guess:");
            String playerGuess = playersNumber.guessNumber();
            playerBulls = playersNumber.checkBulls(playerGuess, computersNumber.getNumber());
            playerCows = playersNumber.checkCows(playerGuess, computersNumber.getNumber());
            System.out.println(String.format("Result: %d bulls and %d cows", playerBulls, playerCows));

            output.get(x).add(playerGuess);
            output.get(x).add(String.valueOf(playerBulls));
            output.get(x).add(String.valueOf(playerCows));

            if(playerBulls == 4){
                System.out.println("Player doth win-eth! :)");
                this.playerWin = 1;
                fileOutput(output, playersNumber.getNumber(),computersNumber.getNumber());
                return;
            }

            String computerGuess = computersNumber.guessNumber();
            System.out.println(String.format("Computer Guess: %s", computerGuess));
            computerBulls = computersNumber.checkBulls(computerGuess, playersNumber.getNumber());
            computerCows = computersNumber.checkCows(computerGuess, playersNumber.getNumber());
            if(computersNumber.aiLevel instanceof HardAi){
                ((HardAi) computersNumber.aiLevel).setBullsAndCows(computerBulls, computerCows);
                ((HardAi) computersNumber.aiLevel).trimPossibleNumbers(computerGuess);
            }
            output.get(x).add(computerGuess);
            output.get(x).add(String.valueOf(computerBulls));
            output.get(x).add(String.valueOf(computerCows));
            System.out.println(String.format("Result: %d bulls and %d cows", computerBulls, computerCows));
            System.out.println("-----------");

            if(computerBulls == 4){
                System.out.println("Computer doth win-eth, thy suck-eth");
                this.playerWin = 2;
                fileOutput(output, playersNumber.getNumber(),computersNumber.getNumber());
                return;
            }
        }

        this.playerWin = 3;
        fileOutput(output, playersNumber.getNumber(),computersNumber.getNumber());
        System.out.println("Tis a draw-eth");
    }

    public void fileOutput(Map<String,ArrayList<String>> outputList,String playerNumber, String computerNumber){

        String yesOrNo = "";
        while (true) {
            System.out.println("do you want to save game? \n Y/N");
            yesOrNo = Keyboard.readInput();
            if (yesOrNo.equalsIgnoreCase("Y") || yesOrNo.equalsIgnoreCase("n")) {
                break;
            }
        }
        if (yesOrNo.equalsIgnoreCase("y")) {
            while(true) {
                System.out.println("Please enter file name: ");
                String fileName = Keyboard.readInput();
                try {
                    PrintWriter writer = new PrintWriter(new FileWriter(fileName));
                    writer.println("Bulls and Cows game result.");
                    writer.println(String.format("Your code: %s", playerNumber));
                    writer.println(String.format("Computer code: %s", computerNumber));
                    for (Map.Entry<String, ArrayList<String>> element : outputList.entrySet()) {
                        writer.println("---");
                        writer.println("turn " + element.getKey());
                        ArrayList<String> elementList = element.getValue();
                        writer.println((String.format("You guessed %s, scoring %s bulls and %s cows", elementList.get(0), elementList.get(1), elementList.get(2))));
                        if(elementList.size() > 3) {
                            writer.println((String.format("Computer guessed %s, scoring %s bulls and %s cows", elementList.get(3), elementList.get(4), elementList.get(5))));
                        }
                    }
                    if (this.playerWin == 1){
                        writer.println("Player doth win-eth! :)");
                    } else if (this.playerWin == 2) {
                        writer.println("Computer doth win-eth, thy suck-eth");
                    } else if(this.playerWin == 3){
                        writer.println("Tis a draw-eth");
                    }
                    writer.close();
                    System.out.println("File saved under \"" + fileName + "\"");
                    System.out.println("Thanks for playing");
                    return;
                } catch (IOException e) {
                    System.out.println("This is not a valid file name");
                }
            }
        }else {
            System.out.println("Thanks for playing");
        }
    }
}
