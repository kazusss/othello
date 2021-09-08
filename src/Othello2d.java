import java.util.Scanner;

public class Othello2d {
	private Scanner in = new Scanner(System.in);
	private String header = "  0 1 2 3 4 5 6 7";
	private String[] rowheader = { "0 ", "1 ", "2 ", "3 ", "4 ", "5 ", "6 ", "7 " };
	private boolean blackTurn = true;
	private final static int BLACK = 1;
	private final static int WHITE = 2;
	private final static int NONE = 0;

	private int[][] board = { //
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, //
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, //
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, //
			{ 0, 0, 0, 1, 2, 0, 0, 0 }, //
			{ 0, 0, 0, 2, 1, 0, 0, 0 }, //
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, //
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, //
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, };

	public static void main(String[] args) {
		Othello2d othello2d = new Othello2d();
		othello2d.start();
	}

	private void start() {
		this.showboard();
		for (int i = 0; i < 60; i++) {

			System.out.print("行 :");
			int y = in.nextInt();
			System.out.print("列 :");
			int x = in.nextInt();

			if (this.board[y][x] != NONE) {
				System.out.println("その場所には置けません");
				continue;
			}
			if (y < 0 || 7 < y) {
				System.out.println("その場所には置けません");
				continue;
			}
			if (x < 0 || 7 < x) {
				System.out.println("その場所には置けません");
				continue;
			}
			int discColor = this.blackTurn ? BLACK : WHITE;
			if (this.checkPut(discColor, x, y, board) == 0) {
				System.out.println("その場所には置けません");
				if (0 < i)
					i--;
				continue;
			}
			;
			this.board[y][x] = discColor;
			this.checkRight(discColor, x, y, board, false);
			this.checkLeft(discColor, x, y, board, false);
			this.checkDown(discColor, x, y, board, false);
			this.checkUp(discColor, x, y, board, false);
			this.checkLeftUpper(discColor, x, y, board, false);
			this.checkRightDown(discColor, x, y, board, false);
			this.checkRightUpper(discColor, x, y, board, false);
			this.checkLeftDown(discColor, x, y, board, false);
			this.showboard();
			this.blackTurn = !this.blackTurn;
		}
	}

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

	private int checkPut(int discColor, int x, int y, int[][] board) {
		int count = 0;
		count += this.checkRight(discColor, x, y, board, true);
		count += this.checkLeft(discColor, x, y, board, true);
		count += this.checkDown(discColor, x, y, board, true);
		count += this.checkUp(discColor, x, y, board, true);
		count += this.checkLeftUpper(discColor, x, y, board, true);
		count += this.checkRightDown(discColor, x, y, board, true);
		count += this.checkRightUpper(discColor, x, y, board, true);
		count += this.checkLeftDown(discColor, x, y, board, true);
		return count;
	}

	private int checkRight(int discColor, int x, int y, int[][] board, boolean checkOnly) {

		int reverseCount = 0;
		if (x == 7) {
			return reverseCount;
		}
		boolean b = false;
		for (int i = x + 1; i < 8; i++) {
			if (board[y][i] == 0) {
				return reverseCount;
			}
			if (board[y][i] != discColor) {
				b = true;
				continue;
			}
			if (board[y][i] == discColor && b) {
				for (int j = x + 1; j < i; j++) {
					if (!checkOnly) {
						board[y][j] = discColor == BLACK ? BLACK : WHITE;
					}
					reverseCount++;
				}
				return reverseCount;
			}
		}
		return reverseCount;
	}

	private int checkLeft(int discColor, int x, int y, int[][] board, boolean checkOnly) {

		int reverseCount = 0;
		if (x == 0) {
			return reverseCount;
		}
		boolean b = false;
		for (int i = x - 1; i >= 0; i--) {
			if (board[y][i] == 0) {
				return reverseCount;
			}
			if (board[y][i] != discColor) {
				b = true;
				continue;
			}
			if (board[y][i] == discColor && b) {
				for (int j = i + 1; j < x; j++) {
					if (!checkOnly) {
						board[y][j] = discColor == BLACK ? BLACK : WHITE;
					}
					reverseCount++;
				}
				return reverseCount;
			}
		}
		return reverseCount;
	}

	private int checkUp(int discColor, int x, int y, int[][] board, boolean checkOnly) {
		boolean b = false;
		int reverseCount = 0;
		if (y == 0) {
			return reverseCount;
		}
		for (int i = y - 1; i >= 0; i--) {
			if (board[i][x] == 0) {
				return reverseCount;
			}
			if (board[i][x] != discColor) {
				b = true;
				continue;
			}
			if (board[i][x] == discColor && b) {
				for (int j = i + 1; j < y; j++) {
					if (!checkOnly) {
						board[j][x] = discColor == BLACK ? BLACK : WHITE;
					}
					reverseCount++;
				}
				return reverseCount;
			}
		}
		return reverseCount;
	}

	private int checkDown(int discColor, int x, int y, int[][] board, boolean checkOnly) {
		boolean b = false;
		int reverseCount = 0;
		if (7 <= y) {
			return reverseCount;
		}
		for (int i = y + 1; i < 8; i++) {
			if (board[i][x] == 0) {
				return reverseCount;
			}
			if (board[i][x] != discColor) {
				b = true;
				continue;
			}
			if (board[i][x] == discColor && b) {
				for (int j = y + 1; j < i; j++) {
					if (!checkOnly) {
						board[j][x] = discColor == BLACK ? BLACK : WHITE;
					}
					reverseCount++;
				}
				return reverseCount;
			}
		}
		return reverseCount;
	}

	private int checkLeftUpper(int discColor, int x, int y, int[][] board, boolean checkOnly) {
		int reverseCount = 0;
		if (x == 0 || y == 0) {
			return reverseCount;
		}
		if (board[y - 1][x - 1] == 0 || board[y - 1][x - 1] == discColor) {
			return reverseCount;
		}
		int xx = x - 1;
		int yy = y - 1;
		while (0 <= xx && 0 <= yy) {
			if (board[yy][xx] == discColor) {
				int yyy = yy;
				int xxx = xx;
				while (yyy < y && xxx < x) {
					if (!checkOnly) {
						board[yyy][xxx] = discColor == BLACK ? BLACK : WHITE;
					}
					reverseCount++;
					yyy++;
					xxx++;
				}
				return reverseCount;
			}
			xx--;
			yy--;
		}
		return 0;
	}

	private int checkRightUpper(int discColor, int x, int y, int[][] board, boolean checkOnly) {
		int reverseCount = 0;
		if (x == 7 || y == 0) {
			return reverseCount;
		}
		if (board[y - 1][x + 1] == 0 || board[y - 1][x + 1] == discColor) {
			return reverseCount;
		}
		int xx = x + 1;
		int yy = y - 1;
		while (7 >= xx && 0 <= yy) {
			if (board[yy][xx] == discColor) {
				int yyy = y;
				int xxx = x;
				while (yyy > yy && xxx < xx) {
					if (!checkOnly) {
						board[yyy][xxx] = discColor == BLACK ? BLACK : WHITE;
					}
					reverseCount++;
					yyy--;
					xxx++;
				}
				return reverseCount;
			}
			xx++;
			yy--;
		}
		return reverseCount;
	}

	private int checkLeftDown(int discColor, int x, int y, int[][] board, boolean checkOnly) {
		int reverseCount = 0;
		if (x == 0 || y == 7) {
			return reverseCount;
		}
		if (board[y + 1][x - 1] == 0 || board[y + 1][x - 1] == discColor) {
			return reverseCount;
		}
		int xx = x - 1;
		int yy = y + 1;
		while (0 <= xx && 7 >= yy) {
			if (board[yy][xx] == discColor) {
				int yyy = yy;
				int xxx = xx;
				while (yyy > y && xxx < x) {
					if (!checkOnly) {
						board[yyy][xxx] = discColor == BLACK ? BLACK : WHITE;
					}
					reverseCount++;
					yyy--;
					xxx++;
				}
				return reverseCount;
			}
			xx--;
			yy++;
		}
		return 0;
	}

	private int checkRightDown(int discColor, int x, int y, int[][] board, boolean checkOnly) {
		int reverseCount = 0;
		if (x == 7 || y == 7) {
			return reverseCount;
		}
		if (board[y + 1][x + 1] == 0 || board[y + 1][x + 1] == discColor) {
			return reverseCount;
		}
		int xx = x + 1;
		int yy = y + 1;
		while (7 >= xx && 7 >= yy) {
			if (board[yy][xx] == discColor) {
				int yyy = y;
				int xxx = x;
				while (yyy < yy && xxx < xx) {
					if (!checkOnly) {
						board[yyy][xxx] = discColor == BLACK ? BLACK : WHITE;
					}
					reverseCount++;
					yyy++;
					xxx++;
				}
				return reverseCount;
			}
			xx++;
			yy++;
		}
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
