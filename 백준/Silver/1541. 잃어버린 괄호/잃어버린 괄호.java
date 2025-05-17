import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		boolean first = false;
		int sum = 0;
		for (String temp : s.split("\\-")) {
			int tempSum = 0;
			for (String temp2 : temp.split("\\+")) {
				tempSum += Integer.parseInt(temp2);
			}
			if (!first) {
				first = true;
				sum = tempSum;
			} else {
				sum -= tempSum;
			}
		}
		
		System.out.println(sum);
	}
}
