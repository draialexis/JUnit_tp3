package com.alexisdrai.tictactoe;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class GameTests {

    private static Random rdm;
    private Game game;

    @BeforeAll
    static void initAll() {
        rdm = new Random();
    }

    @BeforeEach
    void initEach() {
        game = new Game();
    }

    @Test
    void canBeConstructed() {
        assertInstanceOf(Game.class, game);
        assertEquals(Game.ROW_SIZE, game.getBoard().length); // rows
        assertEquals(Game.COLUMN_SIZE, game.getBoard()[0].length); // cols
        for (int i = 0; i < Game.ROW_SIZE; i++) {
            for (int j = 0; j < Game.COLUMN_SIZE; j++) {
                assertEquals('_', game.getBoard()[i][j]); // should be initialized empty
            }
        }
    }

    @ParameterizedTest
    @ArgumentsSource(gameFillBoardOkArgumentProvider.class)
    void gameBoardGetsFilled(char[][] originalBoard, int x, int y, char[][] expected) {
        // Arrange
        game.setBoard(originalBoard);
        boolean output;

        // Act
        output = game.play(x, y);

        // Assert
        assertTrue(output);
        assertArrayEquals(expected, game.getBoard());
    }

    @ParameterizedTest
    @ArgumentsSource(gameFillBoardKoArgumentProvider.class)
    void gameBoardDoesNotGetFilled(char[][] originalBoard, int x, int y, char[][] expected) {
        // Arrange
        game.setBoard(originalBoard);
        boolean output;

        // Act
        output = game.play(x, y);

        // Assert
        assertFalse(output);
        assertArrayEquals(expected, game.getBoard());
    }

    @Test
    void gamePlayerIsNotSkippedAfterMissing() {
        // Arrange
        game.setBoard(new char[][]{{'_', '_', '_'}, {'_', '_', 'x'}, {'_', '_', '_'}});
        boolean output;

        // Act
        output = game.play(1, 2);
        assertFalse(output);

        output = game.play(2, 1);

        // Assert
        assertTrue(output);
        assertArrayEquals(new char[][]{{'_', '_', '_'}, {'_', '_', 'x'}, {'_', 'o', '_'}}, game.getBoard());
    }

    @ParameterizedTest
    @ArgumentsSource(gameFinishArgumentProvider.class)
    void gameIsOverTrueWhenWonOrFull(char[][] originalBoard) {
        // Arrange
        game.setBoard(originalBoard);
        boolean isOver;

        // Act
        isOver = game.isOver();

        // Assert
        assertTrue(isOver);
    }

    @ParameterizedTest
    @ArgumentsSource(gameDoNotFinishArgumentProvider.class)
    void gameIsOverFalseWhenNeitherWonNorFull(char[][] originalBoard) {
        // Arrange
        game.setBoard(originalBoard);
        boolean isOver;

        // Act
        isOver = game.isOver();

        // Assert
        assertFalse(isOver);
    }

    @Test
    void gameBoardDisplayEmpty() {
        // Arrange
        resetBoard();
        String expected = """
                          _ _ _
                          _ _ _
                          _ _ _""";

        // Act
        String actual = game.display();

        // Assert
        assertEquals(expected, actual);
    }

    void resetBoard() {
        game.setBoard(new char[][]{{'_', '_', '_'}, {'_', '_', '_'}, {'_', '_', '_'}});
    }

    @Test
    void gameBoardDisplayNotEmpty() {
        // Arrange
        game.setBoard(new char[][]{{'_', '_', '_'}, {'_', 'x', '_'}, {'_', '_', '_'}});
        String expected = """
                          _ _ _
                          _ x _
                          _ _ _""";

        // Act
        String actual = game.display();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void gameBoardDisplayFull() {
        // Arrange
        game.setBoard(new char[][]{{'x', 'o', 'x'}, {'o', 'o', 'x'}, {'x', 'x', 'o'}});
        String expected = """
                          x o x
                          o o x
                          x x o""";

        // Act
        String actual = game.display();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void gameNextPlayerFoundStart() {
        // Arrange
        resetBoard();
        char expected = 'x';

        // Act
        char actual = game.getNextPlayer();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void gameNextPlayerFoundMiddle() {
        // Arrange
        game.play(2, 2); //x
        game.play(1, 2); //o
        game.play(1, 1); //x
        char expected = 'o';

        // Act
        char actual = game.getNextPlayer();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void gameNextPlayerFoundEnd() {
        // Arrange
        game.play(0, 0); //x
        game.play(0, 1); //o
        game.play(0, 2); //x
        game.play(1, 0); //o
        game.play(1, 2); //x
        game.play(1, 1); //o
        game.play(2, 1); //x
        game.play(2, 2); //o
        char expected = 'x';

        // Act
        char actual = game.getNextPlayer();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void gameNextPlayerRdm() {
        char expected = 'x';

        for (int i = 0; i < 100; i++) {
            int x = rdm.nextInt(Game.ROW_SIZE);
            int y = rdm.nextInt(Game.COLUMN_SIZE);

            assertEquals(expected, game.getNextPlayer());

            boolean wasValid = game.play(x, y);
            if (wasValid) { // if play is valid, next player
                expected = expected == 'x' ? 'o' : 'x';
            }
        }
    }

    @Test
    public void gamePlayRdm() {
        for (int i = 0; i < 100; ++i) {
            int x = rdm.nextInt(-10, 11);
            int y = rdm.nextInt(-10, 11);

            if (x < 0 || x > 2 || y < 0 || y > 2) {
                assertFalse(game.play(x, y));
            }
            else {
                boolean expected = game.getBoard()[x][y] == '_';
                boolean actual = game.play(x, y);

                assertEquals(expected, actual);
                assertTrue(game.getBoard()[x][y] == 'o' || game.getBoard()[x][y] == 'x');
            }
        }
    }

    @Test
    void gameIsOverRdm() {

        for (int n = 0; n < 100; ++n) {

            boolean expected;

            int validPlays = 0;
            for (int i = 0; i < rdm.nextInt(20); i++) { // might fill the board, might not
                if (game.play(rdm.nextInt(Game.ROW_SIZE), rdm.nextInt(Game.COLUMN_SIZE))) {
                    ++validPlays;
                }
            }

            char[][] board = game.getBoard();

            // only 8 ways to win this if not full
            expected = (validPlays == 9 ||

                        (board[0][0] != '_' && board[0][0] == board[0][1] && board[0][1] == board[0][2]) ||
                        (board[1][0] != '_' && board[1][0] == board[1][1] && board[1][1] == board[1][2]) ||
                        (board[2][0] != '_' && board[2][0] == board[2][1] && board[2][1] == board[2][2]) ||

                        (board[0][0] != '_' && board[0][0] == board[1][0] && board[1][0] == board[2][0]) ||
                        (board[0][1] != '_' && board[0][1] == board[1][1] && board[1][1] == board[2][1]) ||
                        (board[0][2] != '_' && board[0][2] == board[1][2] && board[1][2] == board[2][2]) ||

                        (board[0][0] != '_' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
                        (board[0][2] != '_' && board[0][2] == board[1][1] && board[1][1] == board[2][0]));

            // Act
            boolean actual = game.isOver();

            // Assert
            assertEquals(expected, actual);
        }
    }
}
