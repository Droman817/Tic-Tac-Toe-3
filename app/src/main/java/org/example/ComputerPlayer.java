package org.example;

import java.util.Random;

public class ComputerPlayer {

    public int chooseMove(Board board, char computer, char human) {

        char[] cells = board.getCells();

        if (isBoardEmpty(cells)) {
            int[] corners = {1, 3, 7, 9};
            return corners[new Random().nextInt(4)];
        }

        if (isSecondMove(cells) && cells[4] != 'X' && cells[4] != 'O') {
            return 5;
        }

        int winningMove = findWinningMove(board, computer);

        if (winningMove != -1) {
            return winningMove;
        }

        int blockingMove = findWinningMove(board, human);

        if (blockingMove != -1) {
            return blockingMove;
        }

        return randomMove(cells);
    }

    private boolean isBoardEmpty(char[] cells) {

        for (char cell : cells) {
            if (cell == 'X' || cell == 'O') {
                return false;
            }
        }

        return true;
    }

    private boolean isSecondMove(char[] cells) {

        int moves = 0;

        for (char cell : cells) {
            if (cell == 'X' || cell == 'O') {
                moves++;
            }
        }

        return moves == 1;
    }

    private int findWinningMove(Board board, char symbol) {

        for (int i = 1; i <= 9; i++) {

            Board temp = copyBoard(board);

            if (temp.makeMove(i, symbol)) {

                if (temp.checkWinner(symbol)) {
                    return i;
                }
            }
        }

        return -1;
    }

    private int randomMove(char[] cells) {

        Random random = new Random();

        while (true) {

            int move = random.nextInt(9) + 1;

            if (cells[move - 1] != 'X' && cells[move - 1] != 'O') {
                return move;
            }
        }
    }

    private Board copyBoard(Board original) {

        Board copy = new Board();

        char[] originalCells = original.getCells();
        char[] copyCells = copy.getCells();

        for (int i = 0; i < 9; i++) {
            copyCells[i] = originalCells[i];
        }

        return copy;
    }
}