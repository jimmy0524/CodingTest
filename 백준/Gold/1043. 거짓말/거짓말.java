import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static ArrayList<Integer>[] party;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //사람의 수
        int M = Integer.parseInt(st.nextToken()); //파티의 수
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int[] knowP = new int[num]; //진실을 아는 사람 배열
        for (int i = 0; i < num; i++) {
            knowP[i] = Integer.parseInt(st.nextToken());
        }

        //파티 데이터 저장
        party = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            party[i] = new ArrayList<Integer>();
            int size = Integer.parseInt(st.nextToken()); //각 파티에 참석하는 인원
            for (int j = 0; j < size; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        arr = new int[N + 1];
        //대표 노드를 자기 자신으로 초기화
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        //파티의 참석한 사람들 묶기(union)
        for (int i = 0; i < M; i++) {
            int firstPerson = party[i].get(0);
            for (int j = 1; j < party[i].size(); j++) {
                union(firstPerson, party[i].get(j));
            }
        }
        
        int result = 0;
        for (int i = 0; i < M; i++) {
            boolean possible = true;
            int cur = party[i].get(0);
            for (int j = 0; j < num; j++) {
                if(find(cur) == find(knowP[j])) {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                result ++;
            }
        }

        System.out.println(result);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            arr[b] = a;
        }
    }

    public static int find(int a) {
        if(a == arr[a]) {
            return a;
        } else {
            return arr[a] = find(arr[a]);
        }
    }
}
