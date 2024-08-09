package 정수론7.유클리드_호제법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class gol2_1033 {
    static ArrayList<cNode>[] A; //인접 리스트
    static long lcm; //최소 공배수
    static boolean visited[]; //DFS를 탐색할 때 탐색 여부 저장 배열
    static long D[];//각 노드값 저장 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new ArrayList[N];// ArrayList를 저장할 배열 생성
        D = new long[N]; // 각 노드의 값을 저장할 배열 생성
        visited = new boolean[N];
        lcm = 1; // 최소 공배수 초기화 곱해나가야 하므로 1로 초기화
        // 각 인덱스에 대해 ArrayList<cNode> 인스턴스를 생성하여 할당 -> 이거 안해주면 NullPointerException 발생
        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<cNode>();
        }
        // 노드 간의 연결 및 비율 입력
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            // 인접 리스트에 노드와 비율 정보를 추가
            A[a].add(new cNode(b, p, q));// a에서 b로의 경로 추가
            A[b].add(new cNode(a, q, p));// b에서 a로의 경로 추가 (양방향)
            lcm *= (p * q / gcd(p, q)); //최소 공배수 = 두 수의 곱 / 최대 공약수
        }
        D[0] = lcm; //0번 노드에 최소 공배수 저장
        DFS(0); //0번 노드에서 DFS 시작
        long mgcd = D[0];
        //업데이트 된 D 배열의 값들의 최대 공약수 계산
        for (int i = 1; i < N; i++) {
            mgcd = gcd(mgcd, D[i]);
        }
        //D 배열의 각 값들을 최대 공약수로 나눠 정답 출력
        for (int i = 0; i < N; i++) {
            System.out.print(D[i] / mgcd + " ");
        }
    }
    //유클리드 호제법으로 최대 공약수 구하기
    public static long gcd(long a, long b) {
        if (b == 0){
            return a;
        }
        else {
            return gcd(b, a % b);
        }
    }
    public static void DFS(int Node) {
        visited[Node] = true; //현재 노드 방문 기록
        for (cNode i : A[Node]) { // 현재 노드의 인접 노드 탐색
            int next = i.getB(); // 다음 노드
            if (!visited[next]) { // 아직 방문하지 않은 노드라면
                D[next] = D[Node] * i.getQ() / i.getP(); //다음 노드의 값 = 현재 노드의 값 * 비율로 저장
                DFS(next); // 다음 노드로 DFS 진행
            }
        }
    }
}
//노드 클래스
class cNode {
    int b;
    int p;
    int q;
    public cNode(int b, int p, int q) {
        super();
        this.b = b;
        this.p = p;
        this.q = q;
    }
    public int getB() {
        return b;
    }
    public int getP() {
        return  p;
    }
    public int getQ() {
        return q;
    }
}
