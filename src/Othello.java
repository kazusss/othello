import java.util.Arrays;
import java.util.Scanner;

public class Othello {
	private static int[] board = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	private static void showBoard() {
		for (int i = 0; i < 10; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i = 0; i < 10; i++) {
			switch (board[i]) {
			case 0:
				System.out.print("・");
				break;
			case 1:
				System.out.print("●");
				break;
			case 2:
				System.out.print("〇");
				break;
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		showBoard();
		for (int i = 0; i < 10; i++) {
			int turn = (i % 2) + 1;
			if (turn == 1) {
				System.out.print("●の手番です->");
			} else {
				System.out.print("〇の手番です->");
			}

			int input = scanner.nextInt();
			board[input] = turn;

			checkLeft(turn, input, board);
			checkRight(turn, input, board);

			showBoard();
		}

		scanner.close();
		long blackcount = count(board, 1);
		long whitecount = count(board, 2);
		if (blackcount < whitecount) {
			System.out.println(whitecount + "対" + blackcount + "で白の勝ちです");
		} else if (whitecount < blackcount) {
			System.out.println(blackcount + "対" + whitecount + "黒の勝ちです");
		} else {
			System.out.println("引き分けです");
		}
	}

	private static long count(int[] board, int disc) {
		return Arrays.stream(board).filter(c -> c == disc).count();
	}

	private static void checkLeft(int turn, int input, int[] board) {
		boolean b = false;
		for (int j = input - 1; j >= 0; j--) {
			if (board[j] == 0) {
				break;
			}
			if (board[j] != turn) {
				b = true;
				continue;
			}
			if (board[j] == turn) {
				for (int k = j + 1; k < input; k++) {
					board[k] = turn;
				}
			}
		}
	}

	/**
	 * @param turn ターン 1( black) or 2(while)
	 * @param index 置いた場所
	 * @param board オセロ盤
	 */
	private static void checkRight(int turn, int index, int[] board) {
		boolean b = false;
		for (int j = index + 1; j < 10; j++) {
			if (board[j] == 0) {
				break;
			}
			if (board[j] != turn) {
				b = true;
				continue;
			}
			if (board[j] == turn) {
				for (int k = j - 1; k > index; k--) {
					board[k] = turn;
				}
			}
		}
	}
}
