import java.util.Scanner;

public class TicTacToe {
    static char[][] board = new char[3][3];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            initializeBoard();
            char currentPlayer = 'X';
            boolean gameWon = false;
            int moves = 0;

            while (!gameWon && moves < 9) {
                printBoard();
                System.out.println("Player " + currentPlayer + ", enter your row and column (0, 1, or 2): ");
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                if (isValidMove(row, col)) {
                    board[row][col] = currentPlayer;
                    moves++;

                    if (checkWinner(currentPlayer)) {
                        printBoard();
                        System.out.println("Player " + currentPlayer + " wins!");
                        gameWon = true;
                    } else {
                        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    }
                } else {
                    System.out.println("Invalid move! Try again.");
                }
            }

            if (!gameWon) {
                printBoard();
                System.out.println("It's a draw!");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        scanner.close();
    }

    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    static void printBoard() {
        System.out.println("Board:");
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
    }

    static boolean checkWinner(char player) {
        // Check rows, columns, diagonals
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||  // Row
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {  // Column
                return true;
            }
        }

        // Diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }

        return false;
    }
}
