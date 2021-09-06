import java.util.Scanner;

public class Kadai04e {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score;

		score = 0;
		System.out.print("テストの点数->");
		score = sc.nextInt();

		if (score < 60) {
			System.out.println("C");
		} else if (score <= 90) {
			System.out.println("B");
		} else if (score <= 100) {
			System.out.println("A");
		} else {
			System.out.println("入力エラー");
		}
		sc.close();
	}

}
