import java.io.*;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Wordle extends Number{

    public ArrayList<String> possibleAnswers;
    public String correctWord;
    public Wordle(){
        this.possibleAnswers = importWordsList();
    }

    public void setCorrectWord(){
        int guessedIndex = (int) (Math.random() * (this.possibleAnswers.size()));
        String guess = this.possibleAnswers.get(guessedIndex);
        this.correctWord = guess;
    }

    public ArrayList<String> importWordsList(){
        ArrayList<String> wordsList = new ArrayList<>();
        ArrayList<String> wordsListReturn = new ArrayList<>();
        String line ="";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("dictionary-v2.txt"));
            while ((line = reader.readLine()) != null) {
                wordsList.add(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("IO error");
        }
        for (int i = 0; i < wordsList.size(); i++) {
            if (wordsList.get(i).length()==5){
                wordsListReturn.add(wordsList.get(i));
            }
        }
        return wordsListReturn;
    }

    public boolean isDigit(String test){
        ArrayList<String> digit = new ArrayList<>();
        ArrayList<String> testList = convertToList(test);
        for (int i = 0; i < 10; i++) {
            digit.add(String.valueOf(i));
        }
        for (int i = 0; i < testList.size(); i++) {
            if(digit.contains(testList.get(i))){
                return true;
            }
        }
        return false;
    }
    public String guessNumber(){
        String guess = Keyboard.readInput();
        while(guess.length()!= 5){
            System.out.println("this is not the right length, please try again:");
            guess = Keyboard.readInput();
        }
        while (isDigit(guess)){
            System.out.println("Please do not include numbers");
            guess = Keyboard.readInput();
        }
        return guess;
    }

    public void start(){
        System.out.println("Welcome to Wordle!");
        System.out.println("try and guess a 5 letter word");
        setCorrectWord();
        System.out.println(correctWord);
        Map<String,ArrayList<String>> output = new HashMap<String,ArrayList<String>>();
        while(guessCount < 8){
            String x = String.valueOf(guessCount);
            output.put(x, new ArrayList<>());
            System.out.println("enter your guess here");
            String guess = guessNumber();
            int bulls = checkBulls(guess, this.correctWord);
            int cows = checkCows(guess, this.correctWord);
            System.out.println(String.format("you guessed %d bulls and %d cows", bulls, cows));

            output.get(x).add(guess);
            output.get(x).add(String.valueOf(bulls));
            output.get(x).add(String.valueOf(cows));

            if (bulls == 5){
                System.out.println("you guessed the right number!");
                System.out.println("you win!");
                return;
            }
            guessCount++;
        }
        System.out.println("you did not guess the right word :( you lose");
    }

    public void fileOutput(Map<String,ArrayList<String>> outputList, String correctWord){

        String yesOrNo = "";
        while (true) {
            System.out.println("do you want to save game? \n Y/N");
            yesOrNo = Keyboard.readInput();
            if (yesOrNo.equalsIgnoreCase("Y") || yesOrNo.equalsIgnoreCase("n")) {
                break;
            }
        }
        if (yesOrNo.equalsIgnoreCase("y")) {
            System.out.println("Please enter file name: ");
            String fileName = Keyboard.readInput();
            try {
                PrintWriter writer = new PrintWriter(new FileWriter(fileName));
                writer.println("Wordle game result.");
                writer.println(String.format("Correct word: %s", correctWord));
                for (Map.Entry<String, ArrayList<String>> element : outputList.entrySet()) {
                    writer.println("---");
                    writer.println("turn " + element.getKey());
                    ArrayList<String> elementList = element.getValue();
                    writer.println((String.format("You guessed %s, scoring %s bulls and %s cows", elementList.get(0), elementList.get(1), elementList.get(2))));
                }
                writer.close();
                System.out.println("File saved under \"" + fileName + "\"");
                System.out.println("Thanks for playing");
            } catch (IOException e) {
                System.out.println("IO error");
            }
        }else {
            System.out.println("Thanks for playing");
        }
    }

    public static void main(String[] args) {
        Wordle m = new Wordle();
        m.start();
    }
}
