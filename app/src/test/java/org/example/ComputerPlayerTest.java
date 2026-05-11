package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComputerPlayerTest {

    @Test
    void testComputerChoosesValidMove() {

        Board board = new Board();
        ComputerPlayer cpu = new ComputerPlayer();

        int move = cpu.chooseMove(board, 'X', 'O');

        assertTrue(move >= 1 && move <= 9);
    }
}