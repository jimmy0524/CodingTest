import java.io.*;
import java.util.ArrayList;

class Main {
    static int N;
    static ArrayList<Integer> arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        isPrime();

        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;

        while (true) {
            if (sum >= N) {
                sum -= arr.get(start++);

            } else if (end == arr.size() - 1) {
                break;

            } else {
                sum += arr.get(end++);
            }

            if (sum == N) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static void isPrime() {
        boolean[] isPrime = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            isPrime[i] = true;
        }
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < N + 1; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 0; i < N + 1; i++) {
            if (isPrime[i]) {
                arr.add(i);
            }
        }
        arr.add(-1);
    }
}