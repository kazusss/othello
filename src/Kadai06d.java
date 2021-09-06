import java.util.Scanner;

public class Kadai06d {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score = 0;
		double sum = 0;
		int number = 0;
		double average = 0;

		for (int i = 0; i < 6; i++) {
			System.out.print("テストの点数-->");
			score = sc.nextInt();
			if (score >= 0 && score <= 100) {
				number++;
				sum = score + sum;
			}
		}
		average = sum / number;
		System.out.println("平均点は" + average + "です。");
	}

}
