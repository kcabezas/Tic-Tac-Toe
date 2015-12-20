import java.util.Scanner;
/**
 * Program for tic-tac-toe game
 * @author Kathy Cabezas
 * @version 1.0
 */
public class TicTacToe {
	private String player1Mark;
	private String player2Mark;
	private String[][] board;
	
	public TicTacToe(String player1Mark) {
		this.player1Mark = player1Mark;
		if (player1Mark.equals("X")) {
			player2Mark = "O";
		} else {
			player2Mark = "X";
		}
		board = new String[3][3];
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				board[row][col] = " ";
			}
		}
	}
	
	public boolean checkTie() {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (board[row][col].equals(" ")) {
					return false;
				}
			}
		}
		if (checkWin()) {
			return false;
		}
		System.out.println("\n** IT'S A TIE. None of you guys won lol. **");
		printBoard();
		return true;
	}
	
	public boolean checkWin() {
		for (int row = 0; row < board.length; row++) {
			
		}
		return false;
	}
	
	public void player1Turn(Scanner in) {
		System.out.println("\n** Player 1's turn! **");
		printBoard();
		int row = 0;
		int col = 0;
		while ((row == 0 && col == 0) || !isEmptySpace(row - 1, col - 1)) {
			if (row != 0 && col != 0) {
				System.out.println("You can't place your mark there! Please try again.");
			}
			System.out.println("Which row would you like to place your mark?");
			row = in.nextInt();
			System.out.println("Which column would you like to place your mark?");
			col = in.nextInt();
		}
		board[row - 1][col - 1] = player1Mark;
	}
	
	public void player2Turn(Scanner in) {
		System.out.println("\n** Player 2's turn! **");
		printBoard();
		int row = 0;
		int col = 0;
		while ((row == 0 && col == 0) || !isEmptySpace(row - 1, col - 1)) {
			if (row != 0 && col != 0) {
				System.out.println("You can't place your mark there! Please try again.");
			}
			System.out.println("Which row would you like to place your mark?");
			row = in.nextInt();
			System.out.println("Which column would you like to place your mark?");
			col = in.nextInt();
		}
		board[row - 1][col - 1] = player2Mark;
	}
	
	public boolean isEmptySpace(int row, int col) {
		if (board[row][col].equals(" ")) {
			return true;
		}
		return false;
	}
	
	public void printBoard() {
		System.out.println("     1   2   3");
		System.out.println("   -------------");
		System.out.println(
				"1  | " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " |"
		);
		System.out.println("   -------------");
		System.out.println(
				"2  | " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " |"
		);
		System.out.println("   -------------");
		System.out.println(
				"3  | " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " |"
		);
		System.out.println("   -------------");
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Welcome to Two-Player Tic-Tac-Toe! Play against a friend!");
		System.out.print("Player 1, would you like to be X or O?\n[1] X\n[2] O\n[3] Exit game\nEnter 1, 2, or 3: ");
		int answer = in.nextInt();
		
		TicTacToe game;
		if (answer == 3) {
			game = null;
			System.out.println("Okay, bye!");
		} else {
			if (answer == 1) {
				game = new TicTacToe("X");
			} else if (answer == 2) {
				game = new TicTacToe("O");
			} else {
				throw new IllegalArgumentException("Did not enter 1, 2, or 3");
			}
			
			boolean win = game.checkWin();
			boolean tie = game.checkTie();
			while (!win && !tie) {
				game.player1Turn(in);
				win = game.checkWin();
				tie = game.checkTie();
				if (!win && !tie) {
					game.player2Turn(in);
				}
			}
			System.out.println("\nThanks for playing!");
		}
	}
}
