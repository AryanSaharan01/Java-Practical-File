import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        int currentPlayer = 1;
        boolean gameWon = false;

        initializeBoard(board);

        while (!gameWon) {
            displayBoard(board);
            int row, col;
            do {
                System.out.print("Player " + currentPlayer + ", enter row (1-3) and column (1-3): ");
                row = getUserInput() - 1;
                col = getUserInput() - 1;
            } while (!isValidMove(board, row, col));

            char symbol = (currentPlayer == 1) ? 'X' : 'O';
            board[row][col] = symbol;

            if (checkWin(board, symbol)) {
                displayBoard(board);
                System.out.println("Player " + currentPlayer + " wins!");
                gameWon = true;
            } else if (isBoardFull(board)) {
                displayBoard(board);
                System.out.println("It's a draw!");
                gameWon = true;
            }

            currentPlayer = (currentPlayer == 1) ? 2 : 1;
        }
    }

    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public static void displayBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static boolean isValidMove(char[][] board, int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
            return true;
        }
        System.out.println("Invalid move. Try again.");
        return false;
    }

    public static boolean checkWin(char[][] board, char symbol) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true; // Row win
            }
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
                return true; // Column win
            }
        }
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true; // Diagonal win (top-left to bottom-right)
        }
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true; // Diagonal win (top-right to bottom-left)
        }
        return false;
    }

    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
