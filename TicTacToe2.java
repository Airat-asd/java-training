import java.util.*;

class TicTacToe2 {
    private int size;
    private int chips;
    private char dot_x;
    private char dot_o;
    private char dot_empty;
    private char[][] map;
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    TicTacToe2(int size, int chips, char dot_x, char dot_o, char dot_empty) {
        this.size = size;
        this.chips = chips;
        this.dot_x = dot_x;
        this.dot_o = dot_o;
        this.dot_empty = dot_empty;
        map = new char[size][size];
    }

    void initMap() {        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = dot_empty;                
            }         
        }
    }

    void humanTurn() {
        int x, y;
        do {
            System.out.println("Enter X and Y (1..." + size + ")");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;            
        } while (!isCellValid(x, y));        
        map[y][x] = dot_x;
    }

    void aiTurn() {
        int x, y, go, equalX, equalY, equalD1, equalD2;
        go = 0;

        //check diagonals
        equalD1 = equalD2 = 0;
        //left to rigth
        for (int i = 0; i < size; i++) {
            if (map[i][i] == dot_x) {
                equalD1++;
                if (equalD1 == 2) {
                    if (i == 1) {
                        map[i + 1][i + 1] = dot_o;
                        go = 1;
                    } else {
                        if (i == (size - 1)) {
                            map[i - 2][i - 2] = dot_o;
                            go = 1;
                        } else {
                            map[i + 1][i + 1] = dot_o;
                            go = 1;
                        }
                    }
                }
            }
            //rigth to left
            if (map[i][size - 1 - i] == dot_x) {
                equalD2++;
                if (equalD2 == 2) {
                    if (i == 1) {
                        map[i + 1][size - i - 2] = dot_o;
                        go = 1;
                    } else {
                        if (i == (size - 1)) {
                            map[i - 2][size - i + 1] = dot_o;
                            go = 1;
                        } else {
                            map[i + 1][size - i - 1] = dot_o;
                            go = 1;
                        }
                    }
                }

            }
        }
        //check horizontals
        for (int i = 0; i < size; i++) {
            equalX = 0;
            for (int j = 0; j < size; j++)
                if (map[i][j] == dot_x) {
                    equalX++;
                    if (equalX == 2) {
                        if (j == 1) {
                            map[i][j + 1] = dot_o;
                            go = 1;
                        } else {
                            if (j == (size - 1)) {
                                map[i][j - 2] = dot_o;
                                go = 1;
                            } else {
                                map[i][j + 1] = dot_o;
                                go = 1;
                            }
                        }
                    }
                }
        }
        //check verticals
        for (int i = 0; i < size; i++) {
            equalY = 0;
            for (int j = 0; j < size; j++)
                if (map[j][i] == dot_x) {
                    equalY++;
                    if (equalY == 2) {
                        if (j == 1) {
                            map[j + 1][i] = dot_o;
                            go = 1;
                        } else {
                            if (j == (size - 1)) {
                                map[j - 2][i] = dot_o;
                                go = 1;
                            } else {
                                map[j + 1][i] = dot_o;
                                go = 1;
                            }
                        }
                    }
                }
        }

        do {
            x = rand.nextInt(size);
            y = rand.nextInt(size);
        } while (!isCellValid(x, y));
        if (go == 0) map[y][x] = dot_o;


    }

    void printMap() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
               System.out.print(map[i][j] + " ");
            System.out.println();
        }
    }

    boolean checkWin(char dot) {
        //check horizontals
        int equalX, equalY, equalD1, equalD2;
        for (int i = 0; i < size; i++) {
            equalX = 0;
            for (int j = 0; j < size; j++)
                if (map[i][j] == dot) {
                    equalX++;
                    if (equalX >= chips) {
                        sc.close();
                        return true;
                    }
                } else equalX = 0;
        }
        //check verticals
        for (int i = 0; i < size; i++) {
            equalY = 0;
            for (int j = 0; j < size; j++)
                if (map[j][i] == dot) {
                    equalY++;
                    if (equalY >= chips) {
                        sc.close();
                        return true;
                    }
                } else equalY = 0;
        }
        //check diagonals
        equalD1 = equalD2 = 0;
        for (int i = 0; i < size; i++) {
            if (map[i][i] == dot) {
                equalD1++;
                if (equalD1 >= chips) {
                    sc.close();
                    return true;
                }
            } else equalD1 = 0;
            if (map[i][size - 1 - i] == dot) {
                equalD2++;
                if (equalD2 >= chips) {
                    sc.close();
                    return true;
                }
            } else equalD2 = 0;
        }
        return false;
    }

    boolean isMapFull() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                if (map[i][j] == dot_empty)
                    return false;
            }
        return true;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= size || y >= size)
            return false;
        if (map[y][x] == dot_empty)
            return true;
        return false;
    }
}
