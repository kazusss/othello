public class Kadai08e {

	public static void main(String[] args) {
		int[] data = { 60, 80, 69, 72, 78, 95, 55, 54, 67, 70 };
		int max = 0;
		int min = 100;

		for (int i = 0; i < 10; i++) {
			if (max <= data[i]) {
				max = data[i];
			} else if (min >= data[i]) {
				min = data[i];
			}
		}
		System.out.println("最大値は" + max + "です。");
		System.out.print("最小値は" + min + "です。");
	}

}
