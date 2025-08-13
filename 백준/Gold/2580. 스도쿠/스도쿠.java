import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Node> zeroList;
	static int[][] arr;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	zeroList = new ArrayList<>();
    	arr = new int[10][10];
    	for (int i = 1; i <= 9; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j = 1; j <= 9; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        		if (arr[i][j] == 0) {
        			zeroList.add(new Node(i, j));
        		}
        	}
    	}
    	sudoku(0);
    }
    
    public static void sudoku(int index) {
    	if (zeroList.size() == index) {
	       	 StringBuilder sb = new StringBuilder();
	         for (int i = 1; i <= 9; i++) {
	             for (int j = 1; j <= 9; j++) {
	                 sb.append(arr[i][j]).append(' ');
	             }
	             sb.append('\n');
	         }
	         System.out.print(sb);
	         System.exit(0);
    	}
    	
    	Node now = zeroList.get(index);
        int x = now.x;
        int y = now.y;

        for (int num = 1; num <= 9; num++) {
            if (check(index, num)) {
                arr[x][y] = num;
                sudoku(index + 1);
                arr[x][y] = 0;
            }
        }
    }
    
    
    public static boolean check(int index, int num) {
    	Node now = zeroList.get(index);
    	int nx = now.x;
    	int ny = now.y;
    	
    	for (int i = 1; i <= 9; i++) {
    		if (arr[nx][i] == num || arr[i][ny] == num) {
    			return false;
    		}
    	}
    	
    	int bx = ((nx - 1) / 3) * 3 + 1;
    	int by = ((ny - 1) / 3) * 3 + 1;
    	for (int i = bx; i < bx + 3; i++) {
    		for (int j = by; j < by + 3; j++) {
    			if (arr[i][j] == num) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    public static class Node {
    	int x, y;
    	Node(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    }
}