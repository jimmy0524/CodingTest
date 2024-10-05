package Do_it_알고리즘_코딩테스트.자료구조3.슬라이딩_윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sil5_12891 {
    static int[] checkArr; //부분 문자열에 포함돼야 할 A,C,G,T의 최소 개수
    static int[] nowArr;
    static int check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int DNASize = Integer.parseInt(st.nextToken()); //DNA 문자열의 길이
        int arrSize = Integer.parseInt(st.nextToken()); //부분 문자열의 길이
        char[] DNAArr = new char[DNASize]; //입력받은 DNA 문자열
        checkArr = new int[4]; //부분 문자열에 포함돼야 할 A,C,G,T의 최소 개수
        nowArr = new int[4]; //현재 상태 배열 (A,C,F,T 몇개 있는지)
        check = 0; // 4가 되면 4개 문자 조건 개수 만족
        int result = 0; // 좋은 수의 개수
        DNAArr = br.readLine().toCharArray(); //입력받은 DNA 문자열의 문자 각각을 배열에 저장
        st = new StringTokenizer(br.readLine());
        //checkArr에 입력받은 A(0),C(1),G(2),T(3)의 최소 개수 저장
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i] == 0) {
                check++;
            }
        }
        //초기 배열 (슬라이딩 하기 전)
        for (int i = 0; i < arrSize; i++) {
            add(DNAArr[i]);
        }
        if(check == 4) {
            result ++;
        }
        for (int i = arrSize; i < DNASize; i++) {
            int j = i - arrSize;
            add(DNAArr[i]);
            remove(DNAArr[j]);
            if(check == 4) {
                result++;
            }
        }
        System.out.println(result);
    }

    public static void add(char c){
        switch (c){
            case 'A':
                nowArr[0]++;
                if (nowArr[0] == checkArr[0]) {
                    check++;
                }
                break;
            case 'C':
                nowArr[1]++;
                if (nowArr[1] == checkArr[1]) {
                    check++;
                }
                break;
            case 'G':
                nowArr[2]++;
                if (nowArr[2] == checkArr[2]) {
                    check++;
                }
                break;
            case 'T':
                nowArr[3]++;
                if (nowArr[3] == checkArr[3]) {
                    check++;
                }
                break;
        }
    }

    public static void remove(char c){
        switch (c){
            case 'A':
                if (nowArr[0] == checkArr[0]) {
                    check--;
                }
                nowArr[0]--;
                break;
            case 'C':
                if (nowArr[1] == checkArr[1]) {
                    check--;
                }
                nowArr[1]--;
                break;
            case 'G':
                if (nowArr[2] == checkArr[2]) {
                    check--;
                }
                nowArr[2]--;
                break;
            case 'T':
                if (nowArr[3] == checkArr[3]) {
                    check--;
                }
                nowArr[3]--;
                break;
        }
    }
}
