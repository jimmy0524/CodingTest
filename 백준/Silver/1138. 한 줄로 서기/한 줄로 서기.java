import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int now = Integer.parseInt(st.nextToken());
            int count = 0;
            for (int j = 1; j <= N; j++) {
                if (count == now) {
                    if (answer[j] != 0) {
                        continue;
                    }
                    answer[j] = i;
                    break;
                }
                if (answer[j] == 0) {
                    count++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]);
            sb.append(" ");
        }
        System.out.print(sb.toString().trim());
    }
}
