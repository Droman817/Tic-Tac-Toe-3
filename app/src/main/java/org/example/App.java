package org.example;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Tic-Tac-Toe!");

        while (true) {

            System.out.println("1. Human vs Human");
            System.out.println("2. Human vs Computer");
            System.out.println("3. Computer vs Human");

            String choice = input.nextLine();

            Board board = new Board();
            ComputerPlayer cpu = new ComputerPlayer();

            char current = 'X';

            board.display();

            while (true) {

                int move;

                if ((choice.equals("2") && current == 'O') ||
                    (choice.equals("3") && current == 'X')) {

                    move = cpu.chooseMove(board, current, current == 'X' ? 'O' : 'X');

                    System.out.println("Computer chooses: " + move);

                } else {

                    System.out.print("What is your move? ");

                    String text = input.nextLine();

                    try {
                        move = Integer.parseInt(text);
                    } catch (Exception e) {
                        System.out.println("That is not a valid move!");
                        continue;
                    }
                }

                if (!board.makeMove(move, current)) {
                    System.out.println("That is not a valid move!");
                    continue;
                }

                board.display();

                if (board.checkWinner(current)) {
                    System.out.println("Player " + current + " wins!");
                    break;
                }

                if (board.isFull()) {
                    System.out.println("Draw!");
                    break;
                }

                current = current == 'X' ? 'O' : 'X';
            }

            System.out.print("Play again? (yes/no): ");

            String again = input.nextLine();

            if (!again.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Goodbye!");
    }
}