package 자료구조3.투_포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sil5_2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Integer.parseInt(st.nextToken());
        long sum = 1;
        long start = 1;
        long end = 1;
        long count = 1;

        while(end != N){
            if(sum < N) {
                end++;
                sum  += end;
            }
            else if(sum > N){
                sum -= start;
                start ++;
            }
            else{
                count++;
                end++;
                sum += end;
            }
        }
        System.out.println(count);
    }
}
