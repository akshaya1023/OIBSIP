import java.util.Random;
import java.util.Scanner;

public class guess_Game {

    public static void main(String[] args) {
        final int max_rounds=3;
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------Game Started----------------- :)");
         System.out.println("Enter the minimum value of the range:");
        int min = scanner.nextInt();

        System.out.println("Enter the maximum value of the range:");
        int max = scanner.nextInt();
        
    
        int randomNumber = rand.nextInt(max - min + 1) + min;
        System.out.println("Random number is between " + min + " and " + max);
         System.out.println("Random number is " + randomNumber); 
    
        for (int j = 1; j <= max_rounds; j++) {
            System.out.println("...............Round " + j+".............. :)");
            
        int count = 0;
        for (int i = 0; i < 4; i++) {
            System.out.println("Enter your guess (1-100):");
            int userGuess = scanner.nextInt();
            count++;
            
            if (userGuess == randomNumber) {
                System.out.println("Correct! You won!");
                System.out.println("It took you " + count + " tries");
                int points = 0;
                switch (count) {
                    case 1:
                        points = 300;
                        break;
                    case 2:
                        points = 200;
                        break;
                    case 3:
                        points = 100;
                        break;
                    case 4:
                        points = 0;
                        break;
                    
                }
                System.out.println("!.........You won " + points + " points!");
                break;
            } else if (randomNumber > userGuess) {
                System.out.println("Nope! The number is higher. Guess again.");
            } else {
                System.out.println("Nope! The number is lower. Guess again.");
            }
        }
    }
        scanner.close();
    }
}
