import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class day10_2503 {
    static int N;
    static int[][] arr;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][3];
        result = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); //숫자
            arr[i][1] = Integer.parseInt(st.nextToken()); //스트라이크
            arr[i][2] = Integer.parseInt(st.nextToken()); //볼
        }
        
        check();
        System.out.println(result);
    }

    private static void check() {
       for (int a = 1; a <= 9; a++) {
            for (int b = 1; b <= 9; b++) {
                for (int c = 1; c <= 9; c++) {
                    if (a != b && b != c && a != c) { //같은 숫자가 나오면 안됨
                        boolean possible = true;
                        for (int i = 0; i < N; i++) {
                            int strike = 0;
                            int ball = 0;
                            int first = arr[i][0] / 100;
                            int middle = (arr[i][0] % 100) / 10;
                            int last = arr[i][0] % 10;

                            if (a == first) {
                                strike++;
                            } else if (a == middle || a == last) {
                                ball++;
                            }
                            if (b == middle) {
                                strike++;
                            } else if (b == first || b == last) {
                                ball++;
                            }
                            if (c == last) {
                                strike++;
                            } else if (c == first || c == middle) {
                                ball++;
                            }
                            if(arr[i][1] != strike || arr[i][2] != ball) {
                                possible = false;
                            }
                        }
                        if (possible) {
                            result ++;
                        }
                    }
                }
            }
        }
    }
}
