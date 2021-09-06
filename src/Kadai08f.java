
public class Kadai08f {

	public static void main(String[] args) {
		int[] data = { 50, 80, 0, 68, -1, -1, 100, 52, };
		double average;
		int n = 0;
		int sum = 0;
		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			sum += data[i];
			if (data[i] >= 0 && data[i] <= 100) {
				cnt++;
			}
		}
		average = (double) sum / cnt;
		System.out.println("受験者数は" + cnt + "です。");
		System.out.println("平均点は" + average + "です。");
	}

}
