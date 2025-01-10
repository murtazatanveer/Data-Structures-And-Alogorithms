package Lab_Final_PROJECT;

import java.util.Random;

import java.util.Scanner;

import java.util.*;


class MineSweeper {

    int totalRows;

    int totalColumns;

    int[][] gameGrid;

    boolean[][] revealedCells;

    int totalMines;

    int remainingCells;

    MineSweeper(int totalRows, int totalColumns, int totalMines) {

        this.totalRows = totalRows;

        this.totalColumns = totalColumns;

        this.totalMines = totalMines;

        this.gameGrid = new int[totalRows][totalColumns];

        this.revealedCells = new boolean[totalRows][totalColumns];

        this.remainingCells = totalRows * totalColumns - totalMines;

        placeMines();

    }

    void placeMines() {

        Random random = new Random();

        int placedMines = 0;

        while (placedMines < totalMines) {

            int row = random.nextInt(totalRows);

            int column = random.nextInt(totalColumns);

            if (gameGrid[row][column] == 0) {

                gameGrid[row][column] = -1;

                updateAdjacentCells(row, column);

                placedMines++;

            }

        }

    }

    void updateAdjacentCells(int row, int column) {

        int[] rowDirections = {-1, -1, -1, 0, 0, 1, 1, 1};

        int[] columnDirections = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {

            int newRow = row + rowDirections[i];

            int newColumn = column + columnDirections[i];

            if (isValidCell(newRow, newColumn) && gameGrid[newRow][newColumn] != -1) {

                gameGrid[newRow][newColumn]++;

            }

        }

    }

    boolean isValidCell(int row, int column) {

        return row >= 0 && row < totalRows && column >= 0 && column < totalColumns;

    }

    void revealCellsUsingBFS(int row, int column) {

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{row, column});

        while (!queue.isEmpty()) {

            int[] currentCell = queue.poll();

            int currentRow = currentCell[0], currentColumn = currentCell[1];

            if (!isValidCell(currentRow, currentColumn) || revealedCells[currentRow][currentColumn]) continue;

            revealedCells[currentRow][currentColumn] = true;

            remainingCells--;

            if (gameGrid[currentRow][currentColumn] == 0) {

                int[] rowDirections = {-1, -1, -1, 0, 0, 1, 1, 1};

                int[] columnDirections = {-1, 0, 1, -1, 1, -1, 0, 1};

                for (int i = 0; i < 8; i++) {

                    int newRow = currentRow + rowDirections[i];

                    int newColumn = currentColumn + columnDirections[i];

                    if (isValidCell(newRow, newColumn) && !revealedCells[newRow][newColumn]) {

                        queue.add(new int[]{newRow, newColumn});

                    }

                }

            }

        }

    }

    void displayBoard() {

        for (int row = 0; row < totalRows; row++) {

            for (int column = 0; column < totalColumns; column++) {

                if (revealedCells[row][column]) {

                    System.out.print((gameGrid[row][column] == -1 ? "M" : gameGrid[row][column]) + " ");

                } else {

                    System.out.print("# ");

                }

            }

            System.out.println();

        }

    }

    boolean isGameFinished() {

        return remainingCells == 0;

    }

    boolean isMine(int row, int column) {

        return gameGrid[row][column] == -1;

    }

    void start() {

        Scanner scanner = new Scanner(System.in);

        MineSweeper game = new MineSweeper(5, 5, 5);

        while (true) {

            game.displayBoard();

            System.out.print("Enter row and column to reveal (0-4): ");

            int row = scanner.nextInt();

            int column = scanner.nextInt();

            if (row < 0 || row >= game.totalRows || column < 0 || column >= game.totalColumns) {

                System.out.println("Invalid input! Please enter valid row and column.");

                continue;

            }

            if (game.isMine(row, column)) {

                System.out.println("Game Over! You stepped on a mine.");

                break;

            }

            game.revealCellsUsingBFS(row, column);

            if (game.isGameFinished()) {

                game.displayBoard();

                System.out.println("Congratulations! You revealed all safe cells. You win!");

                break;

            }

        }

        scanner.close();

    }

}



class TicTacToe {

    char[][] board;

    char player;

    boolean gameOver;

    Scanner scanner;

    TicTacToe() {

        board = new char[3][3];
        player = 'X';
        gameOver = false;
        scanner = new Scanner(System.in);

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }
    }

    void start() {
        while (!gameOver) {
            printBoard();
            System.out.println("Player " + player + ", enter your move (row and column): ");

            int row = -1;
            int col = -1;
            boolean validInput = false;

            while (!validInput) {
                try {
                    row = scanner.nextInt();
                    col = scanner.nextInt();

                    if (row < 0 || row >= 3 || col < 0 || col >= 3) {
                        System.out.println("Invalid input. Enter numbers between 0 and 2.");
                    } else if (board[row][col] != ' ') {
                        System.out.println("Invalid move. Cell already occupied!");
                    } else {
                        validInput = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Enter numeric values for row and column.");
                    scanner.next();
                }
            }

            board[row][col] = player;
            gameOver = bfsCheck(player);

            if (gameOver) {
                System.out.println("Player " + player + " has won!");
            } else {
                player = (player == 'X') ? 'O' : 'X';
            }
        }
        printBoard();
    }

    boolean bfsCheck(char player) {
        int n = board.length;

        for (int row = 0; row < n; row++) {
            boolean win = true;
            for (int col = 0; col < n; col++) {
                if (board[row][col] != player) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        for (int col = 0; col < n; col++) {
            boolean win = true;
            for (int row = 0; row < n; row++) {
                if (board[row][col] != player) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        boolean win = true;
        for (int i = 0; i < n; i++) {
            if (board[i][i] != player) {
                win = false;
                break;
            }
        }
        if (win) return true;

        win = true;
        for (int i = 0; i < n; i++) {
            if (board[i][n - 1 - i] != player) {
                win = false;
                break;
            }
        }
        return win;
    }

    void printBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }

  
}





class JokerGame {

    String player1, player2;

    char[][] grid = new char[6][6];

    char[] chars = {
        'A', 'a', 'B', 'b', 'C', 'c', 'D', 'd', 'E', 'e',
        'F', 'f', 'G', 'g', 'H', 'h', 'I', 'i', 'J', 'J',
        'K', 'k', 'L', 'l', 'M', 'm', 'N', 'n', 'O', 'o',
        'P', 'p', 'Q', 'q', 'R', 'r'
    };

    int score1 = 0, score2 = 0, charsUsed = 0;

    boolean isRetake = false;

    Scanner scanner = new Scanner(System.in);

    void start() {

        System.out.println("\n___________WELCOME TO JOKER GAME__________\n");

        System.out.print("\nEnter Player 1 Name: ");
        player1 = scanner.nextLine();

        System.out.print("\nEnter Player 2 Name: ");
        player2 = scanner.nextLine();

        shuffleCharacters();

        fillGrid();

        String pos1="", pos2="";

        do {

            boolean flag1 = false;

            while (!flag1 || isRetake) {

                System.out.println("\n______" + player1 + "'s TURN______\n");

                boolean flag = false;

                while (!flag) {

                    display();

                    System.out.print("\nEnter Position 1 (e.g., A1): ");
                    pos1 = scanner.nextLine();
                    flag = displayGrid(pos1);
                }

                flag = false;

                while (!flag) {

                    System.out.print("\nEnter Position 2 (e.g., A1): ");
                    pos2 = scanner.nextLine();
                    flag = displayGrid(pos2);
                }

                isRetake = false;
                flag1 = validatePositions(pos1, pos2, true);
            }

            boolean flag2 = false;

            while (!flag2 || isRetake) {

                System.out.println("\n_____" + player2 + "'s TURN_____\n");

                boolean flag = false;

                while (!flag) {

                    display();

                    System.out.print("\nEnter Position 1 (e.g., A1): ");
                    pos1 = scanner.nextLine();
                    flag = displayGrid(pos1);
                }

                flag = false;

                while (!flag) {

                    System.out.print("\nEnter Position 2 (e.g., A1): ");
                    pos2 = scanner.nextLine();
                    flag = displayGrid(pos2);
                }

                isRetake = false;
                flag2 = validatePositions(pos1, pos2, false);
            }

            if (charsUsed == 34 && !isLastTwoCardsMatched()) {
                break;
            }

        } while (charsUsed <= 36);

        System.out.println("\n\n********* Game Ended ***********\n");

        System.out.println("\n" + player1 + " Score: " + score1);
        System.out.println("\n" + player2 + " Score: " + score2);

        if (score1 > score2) {
            System.out.println("\n" + player1 + " Wins the Game with Score " + score1);
        } else if (score2 > score1) {
            System.out.println("\n" + player2 + " Wins the Game with Score " + score2);
        } else {
            System.out.println("\nScores are Level");
        }
    }

    boolean displayGrid(String pos) {

        if (!(pos.charAt(0) >= 'A' && pos.charAt(0) <= 'F' && pos.charAt(1) >= '1' && pos.charAt(1) <= '6')) {
            System.out.println("\nPlease Enter Correct Position (A1 to F6)\n");
            return false;
        }

        if (grid[pos.charAt(0) - 'A'][pos.charAt(1) - '1'] == '0') {
            System.out.println("\nPosition Already Scored.\n");
            return false;
        }

        System.out.println("\t1\t2\t3\t4\t5\t6\n");
        for (int i = 0; i < 6; i++) {
            System.out.print((char) ('A' + i));
            for (int j = 0; j < 6; j++) {
                if (pos.charAt(0) == 'A' + i && pos.charAt(1) - '0' == j + 1) {
                    System.out.print("\t" + grid[i][j]);
                } else if (grid[i][j] == '0') {
                    System.out.print("\t ");
                } else {
                    System.out.print("\t#");
                }
            }
            System.out.println();
        }
        return true;
    }

    void display() {
        System.out.println("\t1\t2\t3\t4\t5\t6\n");
        for (int i = 0; i < 6; i++) {
            System.out.print((char) ('A' + i));
            for (int j = 0; j < 6; j++) {
                if (grid[i][j] == '0') {
                    System.out.print("\t ");
                } else {
                    System.out.print("\t#");
                }
            }
            System.out.println();
        }
    }

    void shuffleCharacters() {
        Random rand = new Random();
        for (int i = chars.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }

    void fillGrid() {
        int index = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                grid[i][j] = chars[index++];
            }
        }
    }

    boolean validatePositions(String pos1, String pos2, boolean isPlayer1) {
        int row1 = pos1.charAt(0) - 'A';
        int col1 = pos1.charAt(1) - '1';
        int row2 = pos2.charAt(0) - 'A';
        int col2 = pos2.charAt(1) - '1';

        if (pos1.equals(pos2)) {
            System.out.println("\nBoth Positions are Same.\n");
            return false;
        }

        if (Character.toLowerCase(grid[row1][col1]) == Character.toLowerCase(grid[row2][col2])) {
            if (isPlayer1) {
                score1++;
            } else {
                score2++;
            }
            charsUsed += 2;
            grid[row1][col1] = '0';
            grid[row2][col2] = '0';
            System.out.println("\nCongratulations! Score UPDATED by +1\n");
        } else if (grid[row1][col1] == 'J' || grid[row2][col2] == 'J') {
            if (isPlayer1) {
                score1 += 2;
            } else {
                score2 += 2;
            }
            charsUsed += 2;
            grid[row1][col1] = '0';
            grid[row2][col2] = '0';
            isRetake = true;
            System.out.println("\nCongratulations! Score UPDATED by +2\n");
        } else {
            System.out.println("\nOOPS! Pair Do Not Match. Better Luck Next Time\n");
        }
        return true;
    }

    boolean isLastTwoCardsMatched() {
        char ch1 = 0, ch2 = 0;
        boolean flag = false;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (grid[i][j] != '0' && !flag) {
                    ch1 = grid[i][j];
                    flag = true;
                } else if (grid[i][j] != '0' && flag) {
                    ch2 = grid[i][j];
                    break;
                }
            }
        }
        return ch1 == ch2;
    }

    public static void main(String[] args) {
        JokerGame game = new JokerGame();
        game.start();
    }
}

public class gameingHub {

    public static void main(String[] args) {
       
        System.out.println("Welcome to Gaming Hub");

        System.out.println("\n1. Mine Sweeper\n2. Tic Tac Toe\n3. Joker Game");

        Scanner inp = new Scanner(System.in);
        System.out.print("\nEnter your Choice : ");
        int ch = inp.nextInt();

        if (ch==1) {
            
            MineSweeper ob = new MineSweeper(0, 0, 0);
            ob.start();

        }else if(ch==2){

            TicTacToe ob = new TicTacToe();
            ob.start();

        }else{

            JokerGame ob = new JokerGame();
            ob.start();

        }

        inp.close();

    }
    
}



