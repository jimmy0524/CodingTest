package 정렬4.기수_정렬;

import java.io.*;
import java.util.Arrays;

public class sil5_10989 {
    public static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        radix(A);
//        Arrays.sort(A);
        for (int i = 0; i < N; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
    }
    public static void radix(int[] A) {
        int max = 5; //최대 자릿수 5로 정해짐
        int[] output = new int[A.length]; //임시 정렬을 위한 배열
        int jarisu = 1;
        int count = 0;
        while (count != max) {
            int[] bucket = new int[10]; //기수 정렬을 10개의 버킷을 필요로 한다.
            for (int i = 0; i < A.length; i++) {
                bucket[(A[i] / jarisu) % 10] ++; //일의 자리부터 시작
            }
            for (int i = 1; i < 10; i++) { //합 배열을 이용해서 index 계산
                bucket[i] += bucket[i - 1];
            }
            for (int i = A.length - 1; i >= 0; i--) { //현재 자릿수를 기준으로 정렬
                output[bucket[(A[i] / jarisu % 10)] - 1] = A[i];
                bucket[(A[i] / jarisu) % 10]--;
            }
            for (int i = 0; i < A.length; i++) {
                A[i] = output[i];
            }
            jarisu = jarisu * 10;
            count++;
        }
    }
}
