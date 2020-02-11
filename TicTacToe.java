/**
 * Java level 1. Lesson 4. Home work - Tic tac toe
 * @author Zagretdinov Airat
 * @version 2.0 date 11.02.2020
 */
import java.util.*;

class TicTacToe {

    final int SIZE = 5;
    final int CHIPS = 4;
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
            System.out.println("Enter X and Y (1..." + SIZE + ")");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    void aiTurn() {
        int x, y, go, equalX, equalY, equalD1, equalD2;
        go = 0;

        //check diagonals
        equalD1 = equalD2 = 0;
        //left to rigth
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == DOT_X) {
                equalD1++;
                if (equalD1 == 2) {
                    if (i == 1) {
                        map[i + 1][i + 1] = DOT_O;
                        go = 1;
                    } else {
                        if (i == (SIZE - 1)) {
                            map[i - 2][i - 2] = DOT_O;
                            go = 1;
                        } else {
                            map[i + 1][i + 1] = DOT_O;
                            go = 1;
                        }
                    }
                }
            }
            //rigth to left
            if (map[i][SIZE - 1 - i] == DOT_X) {
                equalD2++;
                if (equalD2 == 2) {
                    if (i == 1) {
                        map[i + 1][SIZE - i - 2] = DOT_O;
                        go = 1;
                    } else {
                        if (i == (SIZE - 1)) {
                            map[i - 2][SIZE - i + 1] = DOT_O;
                            go = 1;
                        } else {
                            map[i + 1][SIZE - i - 1] = DOT_O;
                            go = 1;
                        }
                    }
                }

            }
        }
        //check horizontals
        for (int i = 0; i < SIZE; i++) {
            equalX = 0;
            for (int j = 0; j < SIZE; j++)
                if (map[i][j] == DOT_X) {
                    equalX++;
                    if (equalX == 2) {
                        if (j == 1) {
                            map[i][j + 1] = DOT_O;
                            go = 1;
                        } else {
                            if (j == (SIZE - 1)) {
                                map[i][j - 2] = DOT_O;
                                go = 1;
                            } else {
                                map[i][j + 1] = DOT_O;
                                go = 1;
                            }
                        }
                    }
                }
        }
        //check verticals
        for (int i = 0; i < SIZE; i++) {
            equalY = 0;
            for (int j = 0; j < SIZE; j++)
                if (map[j][i] == DOT_X) {
                    equalY++;
                    if (equalY == 2) {
                        if (j == 1) {
                            map[j + 1][i] = DOT_O;
                            go = 1;
                        } else {
                            if (j == (SIZE - 1)) {
                                map[j - 2][i] = DOT_O;
                                go = 1;
                            } else {
                                map[j + 1][i] = DOT_O;
                                go = 1;
                            }
                        }
                    }
                }
        }

        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        if (go == 0) map[y][x] = DOT_O;


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
            for (int j = 0; j < SIZE; j++)
                if (map[i][j] == dot) {
                    equalX++;
                    if (equalX >= CHIPS)
                        return true;
                } else equalX = 0;
        }
        //check verticals
        for (int i = 0; i < SIZE; i++) {
            equalY = 0;
            for (int j = 0; j < SIZE; j++)
                if (map[j][i] == dot) {
                    equalY++;
                    if (equalY >= CHIPS)
                        return true;
                } else equalY = 0;
        }
        //check diagonals
        equalD1 = equalD2 = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == dot) {
                equalD1++;
                if (equalD1 >= CHIPS)
                    return true;
            } else equalD1 = 0;
            if (map[i][SIZE - 1 - i] == dot) {
                equalD2++;
                if (equalD2 >= CHIPS)
                    return true;
            } else equalD2 = 0;
        }
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
