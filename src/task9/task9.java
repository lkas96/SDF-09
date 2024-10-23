import java.util.Random;

public class task9 {
    // Variables
    static Integer genNumber;
    static Integer playerGuess;
    static String temp;

    // Generate 6 digits random number
    /// Adds to temp as string
    // Later convert the string to Int and save it as genNumber

    public static void main(String[] args) {
        genNumber();

        //WELCOME MESSAGE
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Welcome to number guessing game. Random 6 digit number generated. Possible digits are 0-9.");
        System.out.println("Make your guess, well goodluck babes.");
        System.out.println("------------------------------------------------------------------------------------------");

        // Start game
        game();
    }

    private static void game() {
        // Takes in guess
        boolean isNumber = false;

        while (isNumber == false) {
            System.out.printf("Enter your guess: ");
            String inpuString = System.console().readLine();
            try {
                Integer toInteger = Integer.parseInt(inpuString);
                isNumber = true;
                playerGuess = toInteger;
            } catch (NumberFormatException e) {
                System.out.println("It is not a number. Please enter your 6 digits guess using numbers 0 - 9 only.");
                System.out.println("------------------------------------------------------------------------------");

            }

        }

        checkGuess(playerGuess);
    }

    private static void checkGuess(Integer playerGuess) {
        // Logic to check guess
        // Yes call another method print success message/continue/end/restart
        // If no, call the checkGuess method again or somehting
        if (playerGuess > genNumber) {
            System.out.println("Your guess is too high, guess a smaller number.");
            System.out.println("-----------------------------------------------");

            game();
            
        } else if (playerGuess < genNumber) {
            System.out.println("Your guess is too low, guess a higher number.");
            System.out.println("---------------------------------------------");

            game();

        } else {
            System.out.printf("Your guess is %d, and the generated number is %d%n", playerGuess, genNumber);
            System.out.println("YOU GOT IT SMARTASS.");
            System.out.println("Game end thank you for playing.");
            System.out.println("------------------------------------------------------------------------------------------");

            System.exit(0);
        }
    }

    private static void genNumber() {
        Random ran1 = new Random();
        temp = Integer.toString(ran1.nextInt(10));

        Random ran2 = new Random();
        temp = temp + Integer.toString(ran2.nextInt(10));

        Random ran3 = new Random();
        temp = temp + Integer.toString(ran3.nextInt(10));

        Random ran4 = new Random();
        temp = temp + Integer.toString(ran4.nextInt(10));

        Random ran5 = new Random();
        temp = temp + Integer.toString(ran5.nextInt(10));

        Random ran6 = new Random();
        temp = temp + Integer.toString(ran6.nextInt(10));

        genNumber = Integer.parseInt(temp);
        System.out.println(genNumber);
    }

}