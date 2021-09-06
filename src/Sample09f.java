public class Sample09f {

	public static void main(String[] args) {
		int[] data = { 62, 71, 87, 67, 100, 85, 69, 76, 72, 71 };
		int[] rank = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				if (data[i] < data[j]) {
					rank[i]++;
				}
			}
		}
		for (int i = 0; i < data.length; i++) {
			System.out.printf("%s (順位:%d 位)\n", data[i], rank[i] + 1);
		}
	}
}
