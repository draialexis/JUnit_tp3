package com.alexisdrai;

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
        assertInstanceOf(Game.class, new Game());
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
        game.setBoard(new char[][]{{'_', '_', '_'}, {'_', 'x', 'o'}, {'_', '_', 'x'}});
        String expected = """
                          _ _ _
                          _ x o
                          _ _ x""";

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
}
