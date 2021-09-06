import java.util.Scanner;
public class Kadaai08a {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] num = new int[5];
		int code;
		
		for (code = 0; code < 5; code++) {
			System.out.print("整数値入力-->");
			num[code] = sc.nextInt();
		}
		for (code = 0; code < 5; code++) {
			System.out.println(num[code]);
		}
		
		
        
	}

}
