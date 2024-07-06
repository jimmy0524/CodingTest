package 정렬4.버블_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class gol2_1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        mData[] A = new mData[N];

        for (int i = 0; i < N; i++) {
            A[i] = new mData(Integer.parseInt(br.readLine()), i);
        }

        //A배열 정렬
        Arrays.sort(A);

        //정렬 전 인덱스 - 정렬 수 인덱스
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < A[i].index - i) {
                max = A[i].index - i;
            }
        }
        System.out.println(max + 1);
    }
}

class mData implements Comparable<mData> {
    int value;
    int index;

    public mData(int value, int index) {
        this.value = value;
        this.index = index;
    }

    //sort 할 때 이 메서드가 사용 됨
    @Override
    public int compareTo(mData o) {
        return this.value - o.value;
    }
}
