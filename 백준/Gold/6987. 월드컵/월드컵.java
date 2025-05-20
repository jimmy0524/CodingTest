import java.util.*;
import java.io.*;

public class Main {
	static int[][] arr;
	static boolean check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		here:
		for (int T = 0; T < 4; T++) {
			arr = new int[6][3];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 18; i++) {
				arr[i / 3][i % 3] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < 6; i++) {
				if (arr[i][0] + arr[i][1] + arr[i][2] != 5) {
					System.out.print("0 ");
				    continue here;
				}
			}
			check = false;
			dfs(0, 1);
			if (!check) {
				System.out.print("0 ");
			} else {
				System.out.print("1 ");
			}
		}
	}
	public static void dfs(int index, int fight) {
		if (index == 5) {
			boolean temp = true;
			here:
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					if (arr[i][j] != 0) {
						temp = false;
						break here;
					}
				}
			}
			if (temp) {
				check = true;
			}
			return;
		}
		
		//승리
		if (arr[index][0] > 0 && arr[fight][2] > 0) {
			arr[index][0] --;
			arr[fight][2] --;
			if (fight == 5) {
				dfs (index + 1, index + 2);
			} else {
				dfs(index, fight + 1);
			}
			arr[index][0] ++;
			arr[fight][2] ++;
		}
		
		//무승부
		if (arr[index][1] > 0 && arr[fight][1] > 0) {
			arr[index][1] --;
			arr[fight][1] --;
			if (fight == 5) {
				dfs (index + 1, index + 2);
			} else {
				dfs(index, fight + 1);
			}
			arr[index][1] ++;
			arr[fight][1] ++;
		}
		
		//패배
		if (arr[index][2] > 0 && arr[fight][0] > 0) {
			arr[index][2] --;
			arr[fight][0] --;
			if (fight == 5) {
				dfs (index + 1, index + 2);
			} else {
				dfs(index, fight + 1);
			}
			arr[index][2] ++;
			arr[fight][0] ++;
		}
	}
}
