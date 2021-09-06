import java.util.Scanner;

public class Kadai04f {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		int b;
		int c;

		System.out.print("整数値１->");
		a = sc.nextInt();
		System.out.print("整数値２->");
		b = sc.nextInt();
		System.out.print("整数値３->");
		c = sc.nextInt();

		if (a == b) {
			if (a == c) {
				System.out.print("３つの値は等しいです。");
			} else {
				System.out.print("２つの値は等しいです");
			}
		}
		else if(b == c){
			System.out.println("２つの値は等しいです");
		}
		else if (a == c) {
			System.out.print("２つの値は等しいです");
		}
		else {
			System.out.print("すべて異なります");
		}
	    sc.close();
	}

}
