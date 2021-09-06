import java.util.Scanner;

public class Kadai08g {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] number = { 1, 2, 3, 4, 5 };
		int[] score = new int[5];
		int cnt = 0;
		int sum = 0;
		double average;
		int clear = 0;
		int lose = 0;

		for (int i = 0; i < 5; i++) {
			System.out.print("学生" + number[i] + "->");
			score[i] = sc.nextInt();
			sum += score[i];
			if (score[i] >= 0 && score[i] <= 100) {
				cnt++;
			}
		}
		for (int n = 0; n < 5; n++) {
			if (score[n] < 60 && score[n] >= 0) {
				lose++;
			} else if (score[n] >= 60) {
				clear++;
			}
		}
		average = (double) sum / cnt;
		System.out.println("合格者は" + clear + "です。");
		System.out.println("不合格者は" + lose + "です。");
		System.out.println("平均点は" + average + "です。");
	}
}
