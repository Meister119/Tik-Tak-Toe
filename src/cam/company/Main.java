package cam.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        /* Hier wird der Spieler gespeichert, der gerade am Zug ist */
        int turn = 0;
        int winner = -1;
        int[] board = new int[9];
        Arrays.fill(board, -1);
        int number0 = 1;
        int number1 = 2;


        Player a = new Player(number0);
        Player b = new Player(number1);
        Player[] players = new Player[2];
        players[0] = a;
        players[1] = b;

        while (winner == -1) {
            printBoard(board);
            int turnField = players[turn].getTurn();
            if (players[turn].validateTurn(board, turnField)) {
                board[turnField] = players[turn].number;
                turn = (turn + 1) % 2;
            }
            winner = checkWinner(board);
        }
        System.out.println("Herzlichen Glückwunsch, Spieler  " + winner + " Du hast Gewonen ;)");
    }

    public static int checkWinner(int[] board) {
        int winner = -1;
        if (board[0] == board[1] && board[0] == board[2] && board[0] != -1) {
            winner = board[0];
        } else if (board[3] == board[4] && board[3] == board[5] && board[3] != -1) {
            winner = board[3];
        } else if (board[6] == board[7] && board[6] == board[8] && board[6] != -1) {
            winner = board[6];
        } else if (board[0] == board[4] && board[0] == board[8] && board[0] != -1) {
            winner = board[0];
        } else if (board[2] == board[4] && board[6] == board[2] && board[2] != -1) {
            winner = board[2];
        } else if (board[0] == board[3] && board[0] == board[6] && board[0] != -1) {
            winner = board[0];
        } else if (board[1] == board[4] && board[1] == board[7] && board[1] != -1) {
            winner = board[1];
        } else if (board[2] == board[5] && board[2] == board[8] && board[2] != -1) {
            winner = board[2];
        }

        return winner;
    }


    public static void printBoard(int[] meinBoard) {
        System.out.println(meinBoard[0] + " | " + meinBoard[1] + " | " + meinBoard[2]);
        System.out.println("_____________");
        System.out.println(meinBoard[3] + " | " + meinBoard[4] + " | " + meinBoard[5]);
        System.out.println("_____________");
        System.out.println(meinBoard[6] + " | " + meinBoard[7] + " | " + meinBoard[8]);
    }
}
