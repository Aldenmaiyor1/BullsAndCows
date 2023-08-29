public class CowsAndBullsGame {

    public void start(){
        Number playersNumber = new PlayerNumber();
        Number computersNumber = new ComputerNumber();

        while (!playersNumber.isValidNumber()){
            playersNumber.generateNumber();
        }
        computersNumber.generateNumber();

        System.out.println(playersNumber.number);
        System.out.println(computersNumber.number);
    }
    public static void main(String[] args) {
        CowsAndBullsGame cowsAndBulls = new CowsAndBullsGame();
        cowsAndBulls.start();
    }
}
