import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class day11_2615 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr = new int[21][21];
        for (int i = 1; i <= 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        int ansX = 0;
        int ansY = 0;

        loop:
        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {
                if (arr[i][j] != 0) {
                    //오른쪽
                    if (j <= 15) {
                        if (arr[i][j] == arr[i][j + 1] && arr[i][j + 1] == arr[i][j + 2]
                                && arr[i][j + 2] == arr[i][j + 3] && arr[i][j + 3] == arr[i][j + 4]) {
                            if (arr[i][j] != arr[i][j - 1] && arr[i][j + 4] != arr[i][j + 5]) {
                                answer = arr[i][j];
                                ansX = i;
                                ansY = j;
                                break loop;
                            }
                        }
                    }
                    //왼쪽
                    if (j >= 5) {
                        if (arr[i][j] == arr[i][j - 1] && arr[i][j - 1] == arr[i][j - 2]
                                && arr[i][j - 2] == arr[i][j - 3] && arr[i][j - 3] == arr[i][j - 4]) {
                            if (arr[i][j] != arr[i][j + 1] && arr[i][j - 4] != arr[i][j - 5]) {
                                answer = arr[i][j];
                                ansX = i;
                                ansY = j - 4;
                                break loop;
                            }
                        }
                    }
                    //위
                    if (i >= 5) {
                        if (arr[i][j] == arr[i - 1][j] && arr[i - 1][j] == arr[i - 2][j]
                                && arr[i - 2][j] == arr[i - 3][j] && arr[i - 3][j] == arr[i - 4][j]) {
                            if (arr[i][j] != arr[i + 1][j] && arr[i - 4][j] != arr[i - 5][j]) {
                                answer = arr[i][j];
                                ansX = i - 4;
                                ansY = j;
                                break loop;
                            }
                        }
                    }
                    //아래
                    if (i <= 15) {
                        if (arr[i][j] == arr[i + 1][j] && arr[i + 1][j] == arr[i + 2][j]
                                && arr[i + 2][j] == arr[i + 3][j] && arr[i + 3][j] == arr[i + 4][j]) {
                            if (arr[i][j] != arr[i - 1][j] && arr[i + 4][j] != arr[i + 5][j]) {
                                answer = arr[i][j];
                                ansX = i;
                                ansY = j;
                                break loop;
                            }
                        }
                    }
                    //왼쪽 위 (대각선)
                    if (i >= 5 && j >= 5) {
                        if (arr[i][j] == arr[i - 1][j - 1] && arr[i - 1][j - 1] == arr[i - 2][j - 2]
                                && arr[i - 2][j - 2] == arr[i - 3][j - 3] && arr[i - 3][j - 3] == arr[i - 4][j - 4]) {
                            if (arr[i][j] != arr[i + 1][j + 1] && arr[i - 4][j - 4] != arr[i - 5][j - 5]) {
                                answer = arr[i][j];
                                ansX = i - 4;
                                ansY = j - 4;
                                break loop;
                            }
                        }
                    }
                    //왼쪽 아래 (대각선)
                    if (i <= 15 && j >= 5) {
                        if (arr[i][j] == arr[i + 1][j - 1] && arr[i + 1][j - 1] == arr[i + 2][j - 2]
                                && arr[i + 2][j - 2] == arr[i + 3][j - 3] && arr[i + 3][j - 3] == arr[i + 4][j - 4]) {
                            if (arr[i][j] != arr[i - 1][j + 1] && arr[i + 4][j - 4] != arr[i + 5][j - 5]) {
                                answer = arr[i][j];
                                ansX = i + 4;
                                ansY = j - 4;
                                break loop;
                            }
                        }
                    }
                    //오른쪽 위 (대각선)
                    if (i >= 5 && j <= 15) {
                        if (arr[i][j] == arr[i - 1][j + 1] && arr[i - 1][j + 1] == arr[i - 2][j + 2]
                                && arr[i - 2][j + 2] == arr[i - 3][j + 3] && arr[i - 3][j + 3] == arr[i - 4][j + 4]) {
                            if (arr[i][j] != arr[i + 1][j - 1] && arr[i - 4][j + 4] != arr[i - 5][j + 5]) {
                                answer = arr[i][j];
                                ansX = i;
                                ansY = j;
                                break loop;
                            }
                        }
                    }
                    //오른쪽 아래 (대각선)
                    if (i <= 15 && j <= 15) {
                        if (arr[i][j] == arr[i + 1][j + 1] && arr[i + 1][j + 1] == arr[i + 2][j + 2]
                                && arr[i + 2][j + 2] == arr[i + 3][j + 3] && arr[i + 3][j + 3] == arr[i + 4][j + 4]) {
                            if (arr[i][j] != arr[i - 1][j - 1] && arr[i + 4][j + 4] != arr[i + 5][j + 5]) {
                                answer = arr[i][j];
                                ansX = i;
                                ansY = j;
                                break loop;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
        if (answer != 0) {
            System.out.println(ansX + " " + ansY);
        }
    }
}
