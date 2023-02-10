package com.alexisdrai.tictactoe;

import java.util.Arrays;

public class Game {
    private static final char[][] EMPTY = new char[][]{{'_', '_', '_'}, {'_', '_', '_'}, {'_', '_', '_'}};
    public static final int ROW_SIZE = 3;
    public static final int COLUMN_SIZE = 3;

    private final char[][] board = new char[ROW_SIZE][COLUMN_SIZE];

    private char nextPlayer;

    public Game() {
        for (int i = 0; i < ROW_SIZE; ++i) {
            System.arraycopy(EMPTY[i], 0, board[i], 0, COLUMN_SIZE);
        }
        nextPlayer = 'x';
    }

    public char getNextPlayer() {
        return nextPlayer;
    }

    public char[][] getBoard() {
        return Arrays.copyOf(board, ROW_SIZE);
    }

    public void setBoard(char[][] inBoard) {
        for (int i = 0; i < ROW_SIZE; ++i) {
            System.arraycopy(inBoard[i], 0, board[i], 0, COLUMN_SIZE);
        }
    }

    public boolean play(int x, int y) {
        boolean result = false;
        if (x < 0 || x >= ROW_SIZE || y < 0 || y >= COLUMN_SIZE || isFull()) {
            return false;
        }

        if (board[x][y] == '_') {
            board[x][y] = nextPlayer;
            result = true;
            nextTurn();
        }
        return result;
    }

    private boolean isFull() {
        for (int i = 0; i < ROW_SIZE; i++) {
            for (int j = 0; j < COLUMN_SIZE; j++) {
                char ch = board[i][j];
                if (ch != '_' && ch != 'o' && ch != 'x') {
                    throw new IllegalStateException("'" + ch + "' is not a valid tile");
                }
                if (ch == '_') {
                    return false;
                }
            }
        }
        return true;
    }

    private void nextTurn() {
        if (nextPlayer == 'x') {
            nextPlayer = 'o';
        }
        else {
            if (nextPlayer == 'o') {
                nextPlayer = 'x';
            }
        }
    }

    public boolean isOver() {
        if (Arrays.deepEquals(board, EMPTY)) {
            return false;
        }
        return isFull() ||

               (board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] != '_') ||
               (board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] != '_') ||
               (board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] != '_') ||

               (board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] != '_') ||
               (board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] != '_') ||
               (board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] != '_') ||

               (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '_') ||
               (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '_');

    }

    public String display() {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < ROW_SIZE; i++) {
            for (int j = 0; j < COLUMN_SIZE; j++) {
                result.append(board[i][j]);
                if (j < 2) {
                    result.append(" ");
                }
            }
            if (i < 2) {
                result.append('\n');
            }
        }

        return result.toString();
    }
}
