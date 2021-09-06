import java.util.Scanner;

public class Othello2d {
	private Scanner in = new Scanner(System.in);
	private String header = "  0 1 2 3 4 5 6 7";
	private String[] rowheader = { "0 ", "1 ", "2 ", "3 ", "4 ", "5 ", "6 ", "7 " };
	private boolean blackTurn = true;

	public static void main(String[] args) {
		Othello2d othello2d = new Othello2d();
		othello2d.start();
	}

	private void start() {
		this.showboard();
		for (int i = 0; i < 60; i++) {
			System.out.print("行 :");
			int row = in.nextInt();
			System.out.print("列 :");
			int col = in.nextInt();
			if (this.board[row][col] != 0) {
				System.out.println("その場所には置けません");
				continue;
			}
			this.board[row][col] = this.blackTurn ? 1 : 2;
			this.showboard();
			this.blackTurn = !this.blackTurn;
		}
	}

	private int[][] board = { //
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, //
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, //
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, //
			{ 0, 0, 0, 1, 2, 0, 0, 0 }, //
			{ 0, 0, 0, 2, 1, 0, 0, 0 }, //
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, //
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, //
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, };

	public void showboard() {
		System.out.println(this.header);
		for (int i = 0; i < board.length; i++) {
			System.out.print(this.rowheader[i]);
			int[] row = board[i];
			for (int j = 0; j < row.length; j++) {
				System.out.print(toDisc(row[j]));
			}
			System.out.println();
		}
	}

	private int checkRight() {

		return 0;
	}

	private int checkLeft() {
		return 0;
	}

	private int checkUp() {
		return 0;
	}

	private int checkDown() {
		return 0;
	}

	private int checkLeftUpeer() {
		return 0;
	}

	private int checkRightUpper() {
		return 0;
	}

	private int checkLeftDown() {
		return 0;
	}

	private int checkRightDown() {
		return 0;
	}

	public String toDisc(int i) {
		switch (i) {
			case 0:
				return "・";
			case 1:
				return "●";
			case 2:
				return "〇";
			default:
				return "・";
		}
	}
}
