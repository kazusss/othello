import java.util.Scanner;
public class Kadai08b {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] code = new int[5];
		System.out.print("整数値-->");
		code[0] = sc.nextInt();
		System.out.print("整数値-->");
		code[1] = sc.nextInt();
		System.out.print("整数値-->");
		code[2] = sc.nextInt();
		System.out.print("整数値-->");
		code[3] = sc.nextInt();
		System.out.print("整数値-->");
		code[4] = sc.nextInt();
		
		System.out.println(code[4]);
		System.out.println(code[3]);
		System.out.println(code[2]);
		System.out.println(code[1]);
		System.out.println(code[0]);
		for (int i = 4; i >= 0; i--) {
			System.out.println(code[i]);
			
		}
	}

}
