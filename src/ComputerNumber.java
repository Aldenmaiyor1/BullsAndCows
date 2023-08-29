import java.util.ArrayList;

public class ComputerNumber extends Number{

    public void generateNumber() {
        ArrayList<String> numberList = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            numberList.add(String.valueOf(i));
        }
        int indexToPop = 0;
        number = "";
        for (int i = 0; i < 4; i++) {
            indexToPop =(int) (Math.random() * numberList.size());
            number += numberList.get(indexToPop);
            numberList.remove(indexToPop);
        }
    }

    public String getNumber(){
        return number;
    }

    @Override
    public void guessNumber() {

    }

    public static void main(String[] args) {
        ComputerNumber m = new ComputerNumber();
        m.generateNumber();
        System.out.println(m.number);
    }
}
