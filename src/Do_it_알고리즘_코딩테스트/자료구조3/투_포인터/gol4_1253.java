package Do_it_알고리즘_코딩테스트.자료구조3.투_포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class gol4_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] A = new long[N];
        for(int i = 0; i < N; i++){
            A[i] = Long.parseLong((st.nextToken()));
        }
        Arrays.sort(A); //배열 정렬
        int count = 0;
        for(int i = 0; i < N; i++){
            long K = A[i];
            int start = 0;
            int end = N - 1;
            while(start < end){
                if(A[start] + A[end] > K){
                    end--;
                }
                else if(A[start] + A[end] < K){
                    start++;
                }
                else{ //A[start] + A[end] = k
                    if(start != i && end != i)
                    {
                        count++;
                        break;
                    }
                    else if (start == i){
                        start ++;
                    }
                    else{
                        end --;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
