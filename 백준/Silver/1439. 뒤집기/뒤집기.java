import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int length = s.length();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = s.charAt(i) - '0';
        }

        for (int i = 0; i < length; i++) {
            if (!(s.contains("0") && s.contains("1"))) {
                System.out.println(0);
                return;
            }
        }

        int result = 0;
        boolean meet = false;
        for (int i = 0; i < length; i++) {
            if (arr[i] == 0) {
                if (!meet) {
                    result++;
                    meet = true;
                }
            } else {
                meet = false;
            }
        }

        meet = false;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] == 1) {
                if (!meet) {
                    sum++;
                    meet = true;
                }
            } else {
                meet = false;
            }
        }
        result = Math.min(sum, result);

        for (int i = 0; i < length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }

        sum = 0;
        meet = false;
        for (int i = 0; i < length; i++) {
            if (arr[i] == 0) {
                if (!meet) {
                    sum++;
                    meet = true;
                }
            } else {
                meet = false;
            }
        }
        result = Math.min(sum, result);

        meet = false;
        sum = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] == 1) {
                if (!meet) {
                    sum++;
                    meet = true;
                }
            } else {
                meet = false;
            }
        }
        result = Math.min(sum, result);

        System.out.println(result);

    }
}