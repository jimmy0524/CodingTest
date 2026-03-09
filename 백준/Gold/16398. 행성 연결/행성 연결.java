import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Node> arr = new ArrayList<>();
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            parent[i] = i;
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (i > j) {
                    arr.add(new Node(i, j, value));
                }
            }
        }

        arr.sort((a,b) -> a.value - b.value);

        long answer = 0;
        for (int i = 0; i < arr.size(); i++) {
            Node now = arr.get(i);
            if (find(now.start) != find(now.end)) {
                union(now.start, now.end);
                answer += now.value;
            }
        }

        System.out.println(answer);

    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (a < b) {
                parent[b] = a;
            } else {
                parent[a] = b;
            }
        }
    }

    public static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    public static class Node {
        int start, end, value;
        public Node (int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }
}
