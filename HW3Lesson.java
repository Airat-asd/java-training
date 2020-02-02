/**
 * Java level 1. Lesson 3. Home work
 * @author Zagretdinov Airat
 * @version date 01.02.2020
 */
import java.util.*;

public class HW3Lesson {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int replayGame = 0;
        do {
            int selectionOfGames = numberEntered("What should we play? Press \"1\" if in \"Guess the number\", press \"2\" if in \"Guess the word\":", 1, 2);
            if (selectionOfGames == 1) gameGuessNumber();
            if (selectionOfGames == 2) gamesGuessWord();
            replayGame = numberEntered("What play to again? Press \"1\" if \"Yes\", press \"0\" if \"No\":", 0, 1);
        } while (replayGame == 1);
        System.out.println("Goodbye!");
        sc.close();
    }

    static void gameGuessNumber() {
        Random rand = new Random();
        int hiddenNumber = rand.nextInt(9);
        System.out.println(hiddenNumber);
        boolean win = false;    //win status
        int repeat = 1;         //the number of attempts
        int numberEntered;
        do {
            numberEntered = numberEntered("Enter the hidden number from 0 to 9:", 0, 9);
            if (numberEntered == hiddenNumber) {
                win = true;     // User won
                break;
            } else {
                if (repeat < 3) {
                System.out.print("Attemp #" + repeat + " was unsuccessful. ");
                if (numberEntered > hiddenNumber)
                    System.out.println("Hidden number is less. Try again.");
                else
                    System.out.println("Hidden number is greater. Try again.");
                } else System.out.print("The hidden number was" + hiddenNumber + ". ");  //user lost
              }
            repeat++;
        } while (repeat < 4);
        if (win)
            System.out.println("You won!");
        else
            System.out.println("You lost!");
    }

    static void gamesGuessWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random rand = new Random();
        int numberHiddenWord = rand.nextInt(words.length-1);
        String[] guessedLetters = {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"};      // unraveled characters
        System.out.println("Guess what`s the word I was thinking of.");
        for (;;) {
            String wordEntered = wordEntered("Enter a word, all letters must be lowercase:");
            String[] wordEnteredAray = wordEntered.split("");   //array of entered word
            String[] wordHiddenAray = words[numberHiddenWord].split("");    //array of hidden word
            if (wordEntered.equals(words[numberHiddenWord])) {
                System.out.println("You won!");
                break;
            } else {
                int wordLength;    //the length of the shortest word
                int howManyLettersGuessed = 0;    //how many letters guessed
                if ((wordEntered.length() - words[numberHiddenWord].length()) < 0) {
                    wordLength = wordEntered.length() - 1;
                } else wordLength = words[numberHiddenWord].length() - 1;
                for (int i = 0; i < wordLength; i++) {    //looking for matching characters
                    if (wordHiddenAray[i].equals(wordEnteredAray[i])) {
                        guessedLetters[i] = wordHiddenAray[i];
                        howManyLettersGuessed++;
                    } else break;
                }
                if (howManyLettersGuessed > 0) {
                    System.out.println("You guessed " + howManyLettersGuessed + " letters!");
                    for (int i = 0; i < 14; i++) System.out.print(guessedLetters[i]);
                    System.out.println();
                } else {
                    if (numberEntered("You guessed nothing. Will you try again? Press \"1\" if \"Yes\", press \"0\" if \"No\":", 0, 1) == 0) break;
                }
            }
        }
    }

    static int numberEntered(String message, int min, int max) {     //entering a number by the user using keyboard from minimum to maxmimum
        int numberEntered;
        do {
            System.out.println(message);
            try {
                numberEntered = sc.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("\tInvalid input type (must be an integer)");
                sc.nextLine();  // Clear invalid input from scanner buffer.
            }
        } while (numberEntered < min || numberEntered > max);
        return numberEntered;
    }

    static String wordEntered(String message) {     //entering a word by the user using keyboard
        String wordEntered, wordEnteredLower;
        do {
            System.out.println(message);
            wordEntered = sc.next();
            wordEnteredLower = wordEntered.toLowerCase();
        } while (!wordEntered.equals(wordEnteredLower));
        return wordEntered;
    }
}