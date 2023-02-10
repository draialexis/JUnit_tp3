package com.alexisdrai.tictactoe;

import java.util.Arrays;

public class Game {
    private static final char[][] EMPTY = new char[][]{{'_', '_', '_'}, {'_', '_', '_'}, {'_', '_', '_'}};

    private final char[][] board = new char[3][3];

    private char nextPlayer;

    public Game() {
        for (int i = 0; i < 3; ++i) {
            System.arraycopy(EMPTY[i], 0, board[i], 0, 3);
        }
        nextPlayer = 'x';
    }

    public char getNextPlayer() {
        return nextPlayer;
    }

    public char[][] getBoard() {
        return Arrays.copyOf(board, 3);
    }

    public void setBoard(char[][] inBoard) {
        for (int i = 0; i < 3; ++i) {
            System.arraycopy(inBoard[i], 0, board[i], 0, 3);
        }
    }

    public boolean play(int x, int y) {
        boolean result = false;
        if (x < 0 || x > 2 || y < 0 || y > 2 || isFull()) {
            return false;
        }

        if (Arrays.deepEquals(board, EMPTY) && x == 0 && y == 0) {
            board[0][0] = 'x';
            result = true;
            nextTurn();
        }
        if (Arrays.deepEquals(board, EMPTY) && x == 0 && y == 1) {
            board[0][1] = 'x';
            result = true;
            nextTurn();
        }
        if (Arrays.deepEquals(board, EMPTY) && x == 0 && y == 2) {
            board[0][2] = 'x';
            result = true;
            nextTurn();
        }
        if (Arrays.deepEquals(board, EMPTY) && x == 1 && y == 0) {
            board[1][0] = 'x';
            result = true;
            nextTurn();
        }
        if (Arrays.deepEquals(board, EMPTY) && x == 1 && y == 1) {
            board[1][1] = 'x';
            result = true;
            nextTurn();
        }
        if (Arrays.deepEquals(board, EMPTY) && x == 1 && y == 2) {
            board[1][2] = 'x';
            result = true;
            nextTurn();
        }
        if (Arrays.deepEquals(board, EMPTY) && x == 2 && y == 0) {
            board[2][0] = 'x';
            result = true;
            nextTurn();
        }
        if (Arrays.deepEquals(board, EMPTY) && x == 2 && y == 1) {
            board[2][1] = 'x';
            result = true;
            nextTurn();
        }
        if (Arrays.deepEquals(board, EMPTY) && x == 2 && y == 2) {
            board[2][2] = 'x';
            result = true;
            nextTurn();
        }
        if (Arrays.deepEquals(board, new char[][]{{'_', '_', '_'}, {'_', '_', 'x'}, {'_', '_', '_'}}) && x == 2 &&
            y == 1)
        {
            board[2][1] = 'o';
            result = true;
            nextTurn();
        }
        if (board[x][y] == '_') {
            board[x][y] = nextPlayer;
            result = true;
            nextTurn();
        }
        return result;
    }

    private boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '_') {
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

               (board[0][0] == board[0][1] && board[0][1] == board[0][2] && isAPlayer(board[0][0])) ||
               (board[1][0] == board[1][1] && board[1][1] == board[1][2] && isAPlayer(board[1][0])) ||
               (board[2][0] == board[2][1] && board[2][1] == board[2][2] && isAPlayer(board[2][0])) ||

               (board[0][0] == board[1][0] && board[1][0] == board[2][0] && isAPlayer(board[0][0])) ||
               (board[0][1] == board[1][1] && board[1][1] == board[2][1] && isAPlayer(board[0][1])) ||
               (board[0][2] == board[1][2] && board[1][2] == board[2][2] && isAPlayer(board[0][2])) ||

               (board[0][0] == board[1][1] && board[1][1] == board[2][2] && isAPlayer(board[0][0])) ||
               (board[0][2] == board[1][1] && board[1][1] == board[2][0] && isAPlayer(board[0][2]));

    }

    private boolean isAPlayer(char c) {
        return c == 'x' || c == 'o';
    }

    public String display() {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
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