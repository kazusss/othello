import java.util.Scanner;

public class Kadai08d {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] number = new int[5];
		double average;
		int n = 0;
		int sum = 0;

		for (int i = 0; i < 5; i++) {
			System.out.print("整数値->");
			number[i] = sc.nextInt();
			sum += number[i];
			n++;
		}
       average = (double)sum / n;
       System.out.print("平均値は" + average + "です。");
	}

}
