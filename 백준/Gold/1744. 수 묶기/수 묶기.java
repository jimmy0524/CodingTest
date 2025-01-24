import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        int countMinus = 0;
        int countPlus = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr.add(num);
            if (num <= 0) {
                countMinus++;
            } if(num > 1) {
                countPlus++;
            }
        }
        Collections.sort(arr);
        // 음수가 2개 이상이면 1개 될 때까지 곱하기 + 0 (가장 작은 음수랑 곱하기)
        while (countMinus >= 2) {
            if (arr.size() == 2 && arr.contains(0)) {
                arr.remove((Integer) 0);
                arr.remove(0);
            } else {
                result += arr.get(0) * arr.get(1);
                arr.remove(0);
                arr.remove(0);
            }
            countMinus -= 2;
        }

        while (countPlus >= 2) {
            result += arr.get(arr.size() - 1) * arr.get(arr.size() - 2);
            arr.remove(arr.size() - 1);
            arr.remove(arr.size() - 1);
            countPlus -= 2;
        }

        for (int i : arr) {
            result += i;
        }

        System.out.println(result);
    }
}