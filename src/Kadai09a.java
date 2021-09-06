import java.util.Scanner;

public class Kadai09a {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] test = { 0, 0, 0, 0, 0, 0 };
		int n;

		for (int i = 1; i < 6; i++) {
			System.out.print("サイコロ" + i + "回目->");
			n = sc.nextInt() -1;
			test[n]++;
		}
		System.out.println("1が" + test[0] + "回出ました。");
		System.out.println("2が" + test[1] + "回出ました。");
		System.out.println("3が" + test[2] + "回出ました。");
		System.out.println("4が" + test[3] + "回出ました。");
		System.out.println("5が" + test[4] + "回出ました。");
		System.out.println("6が" + test[5] + "回出ました。");
	}

}
