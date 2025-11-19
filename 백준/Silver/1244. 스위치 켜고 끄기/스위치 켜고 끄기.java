import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N =  Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int studentNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < studentNum; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            changeByGender(gender, number);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(arr[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void changeByGender(int gender, int number) {
        switch (gender) {
            case 1: { //남학생
                for (int i = number; i <= N; i += number) {
                    changeSwitch(i);
                }
                break;
            }
            case 2: { //여학생
                changeSwitch(number);
                int left = number;
                int right = number;
                while (left > 0 && right <= N) {
                    left--;
                    right++;
                    if (left <= 0 || right > N) break;
                    if  (arr[left] != arr[right]) break;
                    changeSwitch(left);
                    arr[right] = arr[left];
                }
            }
        }
    }

    public static void changeSwitch(int index) {
        if (arr[index] == 1) arr[index] = 0;
        else arr[index] = 1;
    }
}
