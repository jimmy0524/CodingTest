import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static int[] arr;
	static int[] result;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		result = new int[7];
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dfs(0,0,0,new ArrayList<>());
		Arrays.sort(result);
		for (int i : result) {
			System.out.println(i);
		}
	}
	private static void dfs(int index, int count, int sum, ArrayList<Integer> tempArr) {
		if (count == 7) {
			if (sum == 100) {
				result = tempArr.stream().mapToInt(i -> i).toArray();
				return;
			}
		}
		for (int i = index; i < 9; i++) {
			tempArr.add(arr[i]);
			dfs(i + 1, count + 1, sum + arr[i], tempArr);
			tempArr.remove(tempArr.size() - 1);
		}
	}
}
