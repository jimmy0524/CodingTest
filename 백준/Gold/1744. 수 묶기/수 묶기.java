import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        PriorityQueue<Integer> negatives = new PriorityQueue<>();
        PriorityQueue<Integer> positives = new PriorityQueue<>(Collections.reverseOrder());
        boolean hasZero = false;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 1) {
                positives.add(num);
            } else if (num == 1) {
                result += 1;
            } else if (num == 0) {
                hasZero = true;
            } else {
                negatives.add(num);
            }
        }

        while (negatives.size() >= 2) {
            int num1 = negatives.poll();
            int num2 = negatives.poll();
            result += num1 * num2;
        }

        while (!negatives.isEmpty()) {
            if (hasZero) {
                negatives.poll();
            } else {
                result += negatives.poll();
            }
        }

        while (positives.size() >= 2) {
            int num1 = positives.poll();
            int num2 = positives.poll();
            result += num1 * num2;
        }

        while (!positives.isEmpty()) {
            result += positives.poll();
        }

        System.out.println(result);
    }
}