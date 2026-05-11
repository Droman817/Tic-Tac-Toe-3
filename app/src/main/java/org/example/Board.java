package org.example;

public class Board {

    private char[] cells;

    public Board() {
        cells = new char[]{'1','2','3','4','5','6','7','8','9'};
    }

    public void display() {
        System.out.println();

        System.out.println(" " + cells[0] + " | " + cells[1] + " | " + cells[2]);
        System.out.println("---+---+---");
        System.out.println(" " + cells[3] + " | " + cells[4] + " | " + cells[5]);
        System.out.println("---+---+---");
        System.out.println(" " + cells[6] + " | " + cells[7] + " | " + cells[8]);

        System.out.println();
    }

    public boolean makeMove(int position, char symbol) {

        if (position < 1 || position > 9) {
            return false;
        }

        if (cells[position - 1] == 'X' || cells[position - 1] == 'O') {
            return false;
        }

        cells[position - 1] = symbol;
        return true;
    }

    public boolean isFull() {

        for (char cell : cells) {
            if (cell != 'X' && cell != 'O') {
                return false;
            }
        }

        return true;
    }

    public boolean checkWinner(char symbol) {

        int[][] wins = {
                {0,1,2},
                {3,4,5},
                {6,7,8},
                {0,3,6},
                {1,4,7},
                {2,5,8},
                {0,4,8},
                {2,4,6}
        };

        for (int[] combo : wins) {

            if (cells[combo[0]] == symbol &&
                cells[combo[1]] == symbol &&
                cells[combo[2]] == symbol) {

                return true;
            }
        }

        return false;
    }

    public char[] getCells() {
        return cells;
    }
}