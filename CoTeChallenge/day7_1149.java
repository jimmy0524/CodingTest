import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class day7_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //집의 수
        int[][] arr = new int[N + 1][3 + 1];
        int[][] D = new int[N + 1][3 + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            D[i][1] = Math.min(D[i - 1][2], D[i - 1][3]) + arr[i][1];
            D[i][2] = Math.min(D[i - 1][1], D[i - 1][3]) + arr[i][2];
            D[i][3] = Math.min(D[i - 1][1], D[i - 1][2]) + arr[i][3];
        }

        int temp;
        temp = Math.min(D[N][1], D[N][2]);
        System.out.println(Math.min(temp, D[N][3]));
    }
}
