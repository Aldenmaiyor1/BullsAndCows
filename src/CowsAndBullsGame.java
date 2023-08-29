public class CowsAndBullsGame {

    public void start(){
        Number playersNumber = new PlayerNumber();
        Number computersNumber = new ComputerNumber();
        int playerBaseNumber = 0;
        while (!playersNumber.isValidNumber(playerBaseNumber)){
            playerBaseNumber = playersNumber.generateNumber();
        }
        playersNumber.number = playerBaseNumber;
        System.out.println(String.format("your code is %d", playersNumber.number));
        computersNumber.number = computersNumber.generateNumber();

        System.out.println(playersNumber.number);
        System.out.println(computersNumber.number);
    }
    public static void main(String[] args) {
        CowsAndBullsGame cowsAndBulls = new CowsAndBullsGame();
        cowsAndBulls.start();
    }
}
