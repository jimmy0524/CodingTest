import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class day8_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] DMax = new int[N + 1][3 + 1];
        int[][] DMin = new int[N + 1][3 + 1];
        int[][] arr = new int[N + 1][3 + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            DMin[i][1] = Math.min(DMin[i - 1][1], DMin[i - 1][2]) + arr[i][1];
            DMin[i][2] = Math.min(DMin[i - 1][1], Math.min(DMin[i - 1][2], DMin[i - 1][3])) + arr[i][2];
            DMin[i][3] = Math.min(DMin[i - 1][2], DMin[i - 1][3]) + arr[i][3];

            DMax[i][1] = Math.max(DMax[i - 1][1], DMax[i - 1][2]) + arr[i][1];
            DMax[i][2] = Math.max(DMax[i - 1][1], Math.max(DMax[i - 1][2], DMax[i - 1][3])) + arr[i][2];
            DMax[i][3] = Math.max(DMax[i - 1][2], DMax[i - 1][3]) + arr[i][3];
        }

        int maxResult = Math.max(DMax[N][1], Math.max(DMax[N][2], DMax[N][3]));
        int minResult = Math.min(DMin[N][1], Math.min(DMin[N][2], DMin[N][3]));

        System.out.println(maxResult + " " + minResult);
    }
}
