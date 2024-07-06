package 정렬4.선택_정렬;

import java.util.Scanner;

public class sil5_1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] A = sc.next().toCharArray();
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = A[i] - '0';
        }
        for (int i = 0; i < B.length; i++) {
            for (int j = i + 1; j < B.length; j++) {
                int max = i;
                if (B[j] > B[max]) {
                    max = j;
                }
                int temp = B[i];
                B[i] = B[max];
                B[max] = temp;
            }
        }
        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i]);
        }
    }
}
