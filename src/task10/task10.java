package task10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class task10 {
    static List<Integer> gen10 = new ArrayList<Integer>();
    static List<Integer> userGuess = new ArrayList<Integer>();
    static Integer arrayCursor = 0; //Tracker, if correct increase count
    static Integer currentGuess;


    public static void main(String[] args) {
        generateArray();

        System.out.println();
        System.out.printf("Generated Array : %s%n", gen10);
        System.out.println("---------------------------------------------");

        game();
    }

    private static void game() {

        boolean trap = false;
        //Show number
        showArray(arrayCursor);

        //Takes in the first guess
        while(!trap){
            System.out.printf("Enter your guess: ");
            String inputString = System.console().readLine();
            try {
                Integer toInteger = Integer.parseInt(inputString);
                currentGuess = toInteger;
                trap = true;
            } catch (NumberFormatException e){
                System.out.println("It is not a number. Please enter a number ranging 1 - 100.");
                System.out.println("----------------------------------------------------------");
            }
        }

        //Checks the guess
        gameCheck(currentGuess);
    }

    private static void gameCheck(Integer currentGuess){
        if (currentGuess < gen10.get(arrayCursor+1)){
            System.out.println("Next number is higher than your guess. Try again.");
            System.out.println("----------------------------------------------------------");
            game();
        } else if (currentGuess > gen10.get(arrayCursor+1)){
            System.out.println("Next number is lower than your guess. Try again.");
            System.out.println("----------------------------------------------------------");
            game();
        } else {
            System.out.println("Correct!, Moving on to the next number. ");
            arrayCursor++;

            if (arrayCursor == 9){
                System.out.println("Game ended, thank you for playing. Shutting down now...");
                System.exit(0);
            }

            game();
        }
    };

    private static void showArray(Integer arrayCursor) {
        Integer tempArrayCursor = arrayCursor;
        Integer howManyHigher = 0; 
        Integer howManyLower = 0;
        Integer howManyEqual = 0;

        while(tempArrayCursor < 9){
            for (Integer i = tempArrayCursor; i < gen10.size()-1; i++){
                if (gen10.get(arrayCursor) > gen10.get(tempArrayCursor+1)){
                    howManyLower++;
                    tempArrayCursor++;
                } else if (gen10.get(arrayCursor) < gen10.get(tempArrayCursor+1)){
                    howManyHigher++;
                    tempArrayCursor++;
                } else if (gen10.get(arrayCursor) == gen10.get(tempArrayCursor+1)){
                    howManyEqual++;
                    tempArrayCursor++;
                }
            }
        }


        System.out.printf("Current Number : %s. Guess the next number. Remaining numbers > [%d Higher, %d Lower,  %d Same]%n", gen10.get(arrayCursor), howManyHigher, howManyLower, howManyEqual);
    }

    private static void generateArray() {
        for (Integer i = 0; i < 10; i++) {
            gen10.add(generateNumber());
        }
    }

    private static Integer generateNumber() {
        Random ran = new Random();
        return ran.nextInt(99) + 1; // generate 0-99, so we add 1 to make it 1 - 100;
    }

}
