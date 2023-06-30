import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class test5555 {
    private static final int BOARD_SIZE = 10;
    private static final int NUM_MINES = 10;
    private static final char MINE = '*';
    private static final char HIDDEN = '-';
    private static final char MARKED = 'X';

    private char[][] board;
    private boolean[][] revealed;
    private int numMinesLeft;

    public static void main(String[] args) {
        test5555 game = new test5555();
        game.initializeBoard();
        game.placeMines();
        game.playGame();
    }

    public void initializeBoard() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        revealed = new boolean[BOARD_SIZE][BOARD_SIZE];
        numMinesLeft = NUM_MINES;
        for (char[] row : board) {
            Arrays.fill(row, HIDDEN);
        }
    }

    public void placeMines() {
        Random random = new Random();
        int minesPlaced = 0;
        while (minesPlaced < NUM_MINES) {
            int row = random.nextInt(BOARD_SIZE);
            int col = random.nextInt(BOARD_SIZE);
            if (board[row][col] != MINE) {
                board[row][col] = MINE;
                minesPlaced++;
            }
        }
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;

        System.out.println("Welcome to Minesweeper!");
        System.out.println("Rules: You need to reveal all cells without hitting a mine.");
        System.out.println("Commands: 'row col' to reveal a cell, 'mark row col' to mark a cell.");
        System.out.println("Let's start!");

        while (!gameOver) {
            printBoard();

            System.out.print("Enter your move: ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            if (parts.length == 2) {
                int row = Integer.parseInt(parts[0]);
                int col = Integer.parseInt(parts[1]);
                if (isValidMove(row, col)) {
                    if (board[row][col] == MINE) {
                        gameOver = true;
                        System.out.println("Game Over! You hit a mine!");
                    } else {
                        revealCell(row, col);
                        if (isGameWon()) {
                            gameOver = true;
                            System.out.println("Congratulations! You won the game!");
                        }
                    }
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            } else if (parts.length == 3 && parts[0].equalsIgnoreCase("mark")) {
                int row = Integer.parseInt(parts[1]);
                int col = Integer.parseInt(parts[2]);
                if (isValidMove(row, col)) {
                    markCell(row, col);
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            } else {
                System.out.println("Invalid command. Try again.");
            }
        }
    }

    public void printBoard() {
        System.out.println("   " + getColumnNumbers());
        System.out.println("   " + getHorizontalLine());
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (revealed[i][j]) {
                    System.out.print(" " + board[i][j]);
                } else {
                    System.out.print(" " + HIDDEN);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public String getColumnNumbers() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < BOARD_SIZE; i++) {
            sb.append(" ").append(i);
        }
        return sb.toString();
    }

    public String getHorizontalLine() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < BOARD_SIZE; i++) {
            sb.append("+-");
        }
        sb.append("+");
        return sb.toString();
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE && !revealed[row][col];
    }

    public void revealCell(int row, int col) {
        revealed[row][col] = true;
        if (board[row][col] == '0') {
            revealAdjacentCells(row, col);
        }
    }

    public void revealAdjacentCells(int row, int col) {
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < BOARD_SIZE && j >= 0 && j < BOARD_SIZE && !revealed[i][j]) {
                    revealCell(i, j);
                }
            }
        }
    }

    public void markCell(int row, int col) {
        if (revealed[row][col]) {
            System.out.println("Cannot mark a revealed cell. Try again.");
        } else if (board[row][col] == MARKED) {
            board[row][col] = HIDDEN;
            numMinesLeft++;
        } else {
            board[row][col] = MARKED;
            numMinesLeft--;
        }
    }

    public boolean isGameWon() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (!revealed[i][j] && board[i][j] != MINE) {
                    return false;
                }
            }
        }
        return true;
    }
}
