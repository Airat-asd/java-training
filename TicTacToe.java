/**
 * Java level 1. Lesson 4. Home work - Tic tac toe
 * @author Zagretdinov Airat
 * @version 1.0 date 10.02.2020
 */
import java.util.*;

class TicTacToe {

    final int SIZE = 3;
    final char DOT_X = 'x';
    final char DOT_O = 'o';
    final char DOT_EMPTY = '.';
    char[][] map = new char[SIZE][SIZE];
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    public static void main(String[] args) {
        new TicTacToe();
    }

    TicTacToe(){
        initMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("You won!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
            System.out.println("AI turn:");
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("AI won!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
        }
         System.out.println("Game over!");
    }

    void initMap() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                map[i][j] = DOT_EMPTY;
    }

    void humanTurn() {
        int x, y;
        do {
            System.out.println("Enter X and Y (1...3)");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[y][x] = DOT_O;
    }

    void printMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
               System.out.print(map[i][j] + " ");
            System.out.println();
        }
    }

    boolean checkWin(char dot) {
        //check horizontals
        int equalX, equalY, equalD1, equalD2;
        for (int i = 0; i < SIZE; i++) {
            equalX = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == dot) equalX++;
                //System.out.println("equalX = " + equalX);
            }
            if (equalX == SIZE)
                return true;
        }
        //check verticals
        for (int i = 0; i < SIZE; i++) {
            equalY = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == dot) equalY++;
                //System.out.println("equalY = " + equalY);
            }
            if (equalY == SIZE)
                return true;
        }
        //check diagonals
        equalD1 = equalD2 = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == dot) equalD1++;
            if (map[SIZE - 1 - i][SIZE - 1 - i] == dot) equalD2++;
        }
        if (equalD1 == SIZE || equalD2 == SIZE)
            return true;
        return false;
    }

    boolean isMapFull() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY)
                    return false;
            }
        return true;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE)
            return false;
        if (map[y][x] == DOT_EMPTY)
            return true;
        return false;
    }
}
