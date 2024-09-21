package 트리9.이진_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sil1_1991 {
    static int[][] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new int[26][2];
        for (int i = 0; i < N; i++) {
            String[] temp =  br.readLine().split(" ");
            int node = temp[0].charAt(0) - 'A';
            char left = temp[1].charAt(0);
            char right = temp[2].charAt(0);

            if (left == '.') {
                tree[node][0] = -1;
            } else {
                tree[node][0] = left - 'A';
            }

            if (right == '.') {
                tree[node][1] = -1;
            } else {
                tree[node][1] = right - 'A';
            }
        }
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();
    }
    public static void preOrder(int i) {
        if (i == -1) {
            return;
        }
        System.out.print((char) (i + 'A'));
        preOrder(tree[i][0]);
        preOrder(tree[i][1]);
    }
    public static void inOrder(int i) {
        if (i == -1) {
            return;
        }
        inOrder(tree[i][0]);
        System.out.print((char) (i + 'A'));
        inOrder(tree[i][1]);
    }
    public static void postOrder(int i) {
        if (i == -1) {
            return;
        }
        postOrder(tree[i][0]);
        postOrder(tree[i][1]);
        System.out.print((char) (i + 'A'));
    }
}
