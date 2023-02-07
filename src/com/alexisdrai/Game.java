package com.alexisdrai;

public class Game {
    private final char[][] board;
    public Game() {
        board = new char[][]{{'_', '_', '_'}, {'_', '_', '_'}, {'_', '_', '_'}};
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] inBoard) {}

    public boolean play(int x, int y) {
        return false;
    }

    public boolean isOver() {
        return false;
    }

    public String display() {
        return null;
    }

    public char nextPlayer() {
        return 0;
    }

    public int[] input() {return new int[]{0, 0};}
    // will not be tested, uses Scanner and manual input, will be very simple
}
