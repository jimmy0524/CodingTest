package 정수론7.소수_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class sil1_1456 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int sqrtB = (int) Math.sqrt(B);
        long[] arr = new long[sqrtB + 1];
        ArrayList<Long> arrayList = new ArrayList<>();
        for (int i = 2; i <= sqrtB; i++) {
            arr[i] = i;
        }
        for (int i = 2; i <= sqrtB; i++) {
            if (arr[i] == 0) {
                continue;
            }
            for (int j = i * 2; j <= sqrtB; j += i) {
                arr[j] = 0;
            }
        }
        for (long i = 2; i <= sqrtB; i++) {
            if (arr[(int) i] != 0) {
                arrayList.add(arr[(int) i]); //2 ~ B의 제곱근까지 소수로만 이루어져있는 arrayList 만듦
            }
        }
        int count = 0;
        for (int i = 0 ; i < arrayList.size(); i++) {
            for (long j = arrayList.get(i) * arrayList.get(i); j <= B; j *= arrayList.get(i)) {
                if(j >= A) { // arrayList에 있는 값을 제곱하면서 A보다 클 때만 count ++
                    count ++;
                }
            }
        }
        System.out.println(count);
    }
} //나중에 고치기
