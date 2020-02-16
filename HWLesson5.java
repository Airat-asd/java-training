/**
 * Java level 1. Lesson 5. Home work - Tic tac toe object
 * @author Zagretdinov Airat
 * @version 3.0 date 16.02.2020
 */

class HWLesson5 {
    final static int CHIPS = 4;
    final static int SIZE = 5;
    final static char DOT_X = 'x';
    final static char DOT_O = 'o';
    final static char DOT_EMPTY = '.';    

    public static void main(String[] args) {
        TicTacToe2 instance1 = new TicTacToe2(SIZE, CHIPS, DOT_X, DOT_O, DOT_EMPTY);
        instance1.initMap();        
        while (true) {
            instance1.humanTurn();
            instance1.printMap();
            if (instance1.checkWin(DOT_X)) {
                System.out.println("You won!");
                break;
            }
            if (instance1.isMapFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
            System.out.println("AI turn:");
            instance1.aiTurn();
            instance1.printMap();
            if (instance1.checkWin(DOT_O)) {
                System.out.println("AI won!");
                break;
            }
            if (instance1.isMapFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
        }
         System.out.println("Game over!");     
    }    
}