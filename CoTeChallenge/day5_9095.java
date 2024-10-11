import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class day5_9095
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] D = new int[11];
        D[1] = 1;
        D[2] = 2;
        D[3] = 4;
        for (int i = 4; i < 11; i++) {
            D[i] = D[i - 1] + D[i - 2] + D[i - 3];
        }
        for (int i = 0; i < N; i++) {
            System.out.println(D[Integer.parseInt(br.readLine())]);
        }
    }
}
