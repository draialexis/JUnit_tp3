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
    void canBeCted() {
        assertInstanceOf(Game.class, game);
        assertEquals(3, game.getBoard().length); // rows
        assertEquals(3, game.getBoard()[0].length); // cols
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
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
        game.setBoard(new char[][]{{'_', '_', '_'}, {'_', '_', '_'}, {'_', '_', '_'}});
        String expected = """
                          _ _ _
                          _ _ _
                          _ _ _""";

        // Act
        String actual = game.display();

        // Assert
        assertEquals(expected, actual);
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
        game.setBoard(new char[][]{{'_', '_', '_'}, {'_', '_', '_'}, {'_', '_', '_'}});
        char expected = 'x';

        // Act
        char actual = game.nextPlayer();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void gameNextPlayerFoundMiddle() {
        // Arrange
        game.setBoard(new char[][]{{'_', '_', '_'}, {'_', 'x', 'o'}, {'_', '_', 'x'}});
        char expected = 'o';

        // Act
        char actual = game.nextPlayer();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void gameNextPlayerFoundEnd() {
        // Arrange
        game.setBoard(new char[][]{{'x', 'o', 'x'}, {'o', 'o', 'x'}, {'_', 'x', 'o'}});
        char expected = 'x';

        // Act
        char actual = game.nextPlayer();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void gameNextPlayerRdm() {

        for (int n = 0; n < 100; ++n) {
            // Arrange
            int nbX = rdm.nextInt(0, 6); // Max number of 'x' on grid, +1
            int nbO = nbX - rdm.nextInt(0, 2); // number of 'x' - 0 or - 1

            char expected;
            if (nbX == nbO) {
                expected = 'x';
            }
            else {
                if (nbX == nbO + 1) { // if 'x' has played 1 more than 'o', then it's 'o' 's turn
                    expected = 'o';
                }
                else {
                    throw new RuntimeException("this should never happen");
                }
            }

            int x, y, turn = 1;
            while (nbX > 0 && nbO > 0) { // randomly fill the grid

                x = rdm.nextInt(0, 3); // in grid ([0 ; 2])
                y = rdm.nextInt(0, 3);
                if (game.getBoard()[x][y] == '_') {
                    game.play(x, y);
                    if (turn % 2 == 1) { // 'x' 's turn
                        --nbX;
                    }
                    else { // 'o' 's turn'
                        --nbO;
                    }
                    turn++;
                }
            }

            // Act
            char actual = game.nextPlayer();

            // Assert
            assertEquals(expected, actual);
        }
    }

    @Test
    void gameIsOverRdm() {

        for (int n = 0; n < 100; ++n) {
            // Arrange
            int nbX = rdm.nextInt(4, 6); // Max number of 'x' on grid, + 1
            int nbO = nbX - rdm.nextInt(0, 2); // number of 'x' - 0 or - 1

            boolean expected = nbX == 5 && nbO == 4;

            int x, y, turn = 1;
            while (nbX > 0 && nbO > 0) { // randomly fill the grid

                x = rdm.nextInt(0, 3); // in grid ([0 ; 2])
                y = rdm.nextInt(0, 3);
                if (game.getBoard()[x][y] == '_') {
                    game.play(x, y);
                    if (turn % 2 == 1) { // 'x' 's turn
                        --nbX;
                    }
                    else { // 'o' 's turn'
                        --nbO;
                    }
                    turn++;
                }
            }

            char[][] board = game.getBoard();
            if (!expected) { // if not full, check for winner instead
                // only 8 ways to win this
                expected = ((board[0][0] == board[0][1] && board[0][1] == board[0][2]) ||
                            (board[1][0] == board[1][1] && board[1][1] == board[1][2]) ||
                            (board[2][0] == board[2][1] && board[2][1] == board[2][2])

                            || (board[0][0] == board[1][0] && board[1][0] == board[2][0]) ||
                            (board[0][1] == board[1][1] && board[1][1] == board[2][1]) ||
                            (board[0][2] == board[1][2] && board[1][2] == board[2][2])

                            || (board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
                            (board[0][2] == board[1][1] && board[1][1] == board[2][0]));
            }

            // Act
            boolean actual = game.isOver();

            // Assert
            assertEquals(expected, actual);
        }
    }
}
