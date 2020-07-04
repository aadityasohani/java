package tictactoe;
import java.util.Scanner;
public class Main {
    static public int convert(int r) {
        if (r == 1) return 2;
        else if (r == 2) return 1;
        else if (r == 3) return 0;
        else return r;
    }

    static public void Print(char[][] arr) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static boolean check_row(char[][] arr, int i, int j, char x) {
        if (j > 0) return false;
        for (int d = j; d < 3; d++) {
            if (arr[i][d] != x) {
                return false;
            }
        }
        return true;
    }

    public static boolean check_column(char[][] arr, int i, int j, char x) {
        if (i > 0) return false;
        for (int d = i; d < 3; d++) {
            if (arr[d][j] != x) {
                return false;
            }
        }
        return true;
    }

    public static boolean check_right(char[][] arr, int i, int j, char x) {
        if (j > 0 || i > 0) return false;
        for (int d = i; d < 3; d++) {
            if (arr[d][d] != x) {
                return false;
            }
        }
        return true;
    }

    public static boolean check_left(char[][] arr, int i, int j, char x) {
        if (j < 2 || i > 0) return false;
        for (int d = i; d < 3; d++) {
            if (arr[d][2 - d] != x) {
                return false;
            }
        }
        return true;
    }

    public static int check_winner(char arr[][]) {
        boolean x = false;
        boolean o = false;
        boolean nf = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean a = false;
                boolean b = false;
                boolean c = false;
                boolean d = false;

                if (arr[i][j] == 'X') {
                    a = check_row(arr, i, j, 'X');
                    b = check_column(arr, i, j, 'X');
                    c = check_right(arr, i, j, 'X');
                    d = check_left(arr, i, j, 'X');
                    if (a || b || c || d) {
                        x = true;
                    }
                } else if (arr[i][j] == 'O') {
                    a = check_row(arr, i, j, 'O');
                    b = check_column(arr, i, j, 'O');
                    c = check_right(arr, i, j, 'O');
                    d = check_left(arr, i, j, 'O');
                    if (a || b || c || d) {
                        o = true;
                    }
                } else {
                    nf = true;
                }
            }
        }
        if (x) {
            return 1;
        } else if (o) {
            return 2;
        } else if (nf) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char arr[][] = new char[3][3];
        int X = 0, O = 0;
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = '_';
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
        int r, p;
        int t = -1;
        while (t == -1) {
            while (true) {
                try {
                    System.out.print("Enter the coordinates: ");
                    r = sc.nextInt();
                    p = sc.nextInt();
                    p = convert(p);
                    r -= 1;
                    if (r > 3 || p > 3) {
                        System.out.println("Coordinates should be from 1 to 3!");
                    } else if (arr[p][r] != '_') {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        if (X <= O) {
                            arr[p][r] = 'X';
                            X += 1;
                        } else {
                            arr[p][r] = 'O';
                            O += 1;
                        }
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("You should enter numbers!");
                    sc.next();
                }
            }
            Print(arr);
            t = check_winner(arr);
        }
        if (t == 0) {
            System.out.println("Draw");
        } else if (t == 1) {
            System.out.println("X wins");
        } else {
            System.out.println("O wins");
        }
    }
}

