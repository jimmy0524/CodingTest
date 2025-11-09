import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            double temp = Double.MAX_VALUE;
            int count = 0;
            for (int j = i - 1; j >= 0; j--) { //왼쪽
                double incline = (arr[i] - arr[j]) / (double) (i - j);
                if (temp == Double.MAX_VALUE) {
                    temp = incline;
                    count++;
                    continue;
                }
                if (temp <= incline) {
                    continue;
                }
                temp = incline;
                count++;
            }

            temp = Double.MAX_VALUE;

            for (int j = i + 1; j < N; j++) { //오른쪽
                double incline = (arr[j] - arr[i]) / (double) (j - i);
                if (temp == Double.MAX_VALUE) {
                    temp = incline;
                    count++;
                    continue;
                }
                if (temp >= incline) {
                    continue;
                }
                temp = incline;
                count++;
            }
            answer = Math.max(count, answer);
        }
        System.out.println(answer);
    }
}
