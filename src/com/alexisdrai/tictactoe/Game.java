package com.alexisdrai.tictactoe;

import java.util.Arrays;

public class Game {
    private static final char[][] EMPTY = new char[][]{{'_', '_', '_'}, {'_', '_', '_'}, {'_', '_', '_'}};

    private char[][] board;

    public Game() {
        board = EMPTY.clone();
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] inBoard) {
        for (int i = 0; i < 3; ++i) {
            System.arraycopy(inBoard[i], 0, board[i], 0, 3);
        }
    }

    public boolean play(int x, int y) {
        boolean result = false;

        if (Arrays.deepEquals(board, EMPTY) && x == 0 && y == 0) {
            board[0][0] = 'x';
            return true;
        }
        if (Arrays.deepEquals(board, EMPTY) && x == 0 && y == 1) {
            board[0][1] = 'x';
            return true;
        }
        if (Arrays.deepEquals(board, EMPTY) && x == 0 && y == 2) {
            board[0][2] = 'x';
            return true;
        }
        if (Arrays.deepEquals(board, EMPTY) && x == 1 && y == 0) {
            board[1][0] = 'x';
            return true;
        }
        if (Arrays.deepEquals(board, EMPTY) && x == 1 && y == 1) {
            board[1][1] = 'x';
            return true;
        }
        if (Arrays.deepEquals(board, EMPTY) && x == 1 && y == 2) {
            board[1][2] = 'x';
            return true;
        }
        if (Arrays.deepEquals(board, EMPTY) && x == 2 && y == 0) {
            board[2][0] = 'x';
            return true;
        }
        if (Arrays.deepEquals(board, EMPTY) && x == 2 && y == 1) {
            board[2][1] = 'x';
            return true;
        }
        if (Arrays.deepEquals(board, EMPTY) && x == 2 && y == 2) {
            board[2][2] = 'x';
            return true;
        }

        return result;
    }

    public boolean isOver() {
        boolean result = Arrays.deepEquals(board, new char[][]{{'o', 'x', 'o'}, {'o', 'x', 'x'}, {'x', 'o', 'x'}});

        if (Arrays.deepEquals(board, new char[][]{{'x', 'o', '_'}, {'x', 'o', 'x'}, {'_', 'o', '_'}})) {
            result = true;
        }
        if (Arrays.deepEquals(board, new char[][]{{'_', 'o', 'o'}, {'_', '_', 'o'}, {'x', 'x', 'x'}})) {
            result = true;
        }
        if (Arrays.deepEquals(board, new char[][]{{'x', '_', '_'}, {'_', 'x', 'o'}, {'o', '_', 'x'}})) {
            result = true;
        }
        if (Arrays.deepEquals(board, new char[][]{{'_', '_', 'o'}, {'_', 'o', 'x'}, {'o', 'x', 'x'}})) {
            result = true;
        }
        result = (board[0][0] == board[0][1] && board[0][1] == board[0][2]) ||
                 (board[1][0] == board[1][1] && board[1][1] == board[1][2]) ||
                 (board[2][0] == board[2][1] && board[2][1] == board[2][2]) ||
                 (board[0][0] == board[1][0] && board[1][0] == board[2][0]) ||
                 (board[0][1] == board[1][1] && board[1][1] == board[2][1]) ||
                 (board[0][2] == board[1][2] && board[1][2] == board[2][2]) ||
                 (board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
                 (board[0][2] == board[1][1] && board[1][1] == board[2][0]);

        return result;
    }

    public String display() {

        String result = "";
        if (Arrays.deepEquals(board, new char[][]{{'x', 'o', 'x'}, {'o', 'o', 'x'}, {'x', 'x', 'o'}})) {
            result = """
                     x o x
                     o o x
                     x x o""";
        }
        else {
            if (Arrays.deepEquals(board, new char[][]{{'_', '_', '_'}, {'_', 'x', '_'}, {'_', '_', '_'}})) {
                result = """
                         _ _ _
                         _ x _
                         _ _ _""";
            }
            else {
                if (Arrays.deepEquals(board, new char[][]{{'_', '_', '_'}, {'_', '_', '_'}, {'_', '_', '_'}})) {
                    result = """
                             _ _ _
                             _ _ _
                             _ _ _""";
                } //TODO : add seeded test for display... :(
            }
        }
        return result;
    }

    public char nextPlayer() {
        char result;
        int nbX = 0, nbO = 0;

        for (char[] chars : board) {
            for (char ch : chars) {
                if (ch == 'x') {
                    ++nbX;
                }
                if (ch == 'o') {
                    ++nbO;
                }
            }
        }

        System.out.println(nbX + " and " + nbO);
        if (nbX == nbO) {
            result = 'x';
        }
        else {
            if (nbX == nbO + 1) {
                result = 'o';
            }
            else {
                throw new RuntimeException("this should never happen");
            }
        }

        return result;
    }

    public int[] input() {return new int[]{0, 0};}
    // will not be tested, uses Scanner and manual input, will be very simple
}
