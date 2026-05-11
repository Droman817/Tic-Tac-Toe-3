package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    void testMoveWorks() {

        Board board = new Board();

        assertTrue(board.makeMove(1, 'X'));
    }

    @Test
    void testTakenSpaceFails() {

        Board board = new Board();

        board.makeMove(1, 'X');

        assertFalse(board.makeMove(1, 'O'));
    }

    @Test
    void testWinner() {

        Board board = new Board();

        board.makeMove(1, 'X');
        board.makeMove(2, 'X');
        board.makeMove(3, 'X');

        assertTrue(board.checkWinner('X'));
    }
}