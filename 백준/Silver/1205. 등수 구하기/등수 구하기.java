import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();
        int answer = -1;

        if (N == 0) {
            System.out.println(1);
            return;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        breakpoint:
        if (arr.size() == P) { //꽉찼을때
            if (arr.get(arr.size() - 1) >= score) { // 들어가있는 값보다 작거나 같아서 들어가지 못함
                answer = -1;
            } else {
                for (int i = 0; i < arr.size(); i++) {
                    if (arr.get(i) <= score) { // 새로운 점수가 크거나 같다면
                        answer = i + 1;
                        break;
                    }
                }
            }
        } else { //꽉 안찼을때
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) <= score) { // 새로운 점수가 크거나 같다면
                    answer = i + 1;
                    break breakpoint;
                }
            }
            answer = arr.size() + 1;
        }

        System.out.println(answer);
    }
}
