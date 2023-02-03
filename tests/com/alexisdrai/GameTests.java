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
    void gameEmptyBoardGetsFilled(char[][] originalBoard, int x, int y, String expected) {
        // Arrange
        game.setBoard(originalBoard);

        // Act
        game.play(x, y);

        // Assert
        assertEquals(expected, game.getBoard().toString());
    }

}
