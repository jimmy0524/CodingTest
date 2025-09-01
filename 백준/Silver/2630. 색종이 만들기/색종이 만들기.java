import java.util.*;
import java.io.*;

public class Main {
	static int area1 = 0;
	static int area0 = 0;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		//--------------솔루션 코드를 작성하세요.---------------------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		devide(0, 0, N);
		System.out.println(area0);
		System.out.println(area1);
	}
	
	public static void devide(int x, int y, int size) {
		int temp = arr[x][y];
		boolean check = true;
		here:
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (temp != arr[i][j]) {
					check = false;
					break here;
				}
			}
		}
		if (!check) {
			devide(x, y, size / 2);
			devide(x + size / 2, y, size / 2);
			devide(x, y + size / 2, size / 2);
			devide(x + size / 2, y + size / 2, size / 2);
		} else {
			if (temp == 1) {
				area1++;
			} else {
				area0++;
			}
		}
	}
}
