package first;

import java.util.Scanner;
import java.util.Stack;

public class prob6 {
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		Stack<Integer> zeroPosition = new Stack<>();
		
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			if(arr[i] == 0) {
				zeroPosition.add(i);
			}
		}
		
		String answer = "";
		int i = 0;
		int flag = 0;
		int zeros = zeroPosition.size();
		
		System.out.println(zeroPosition);
		
		System.out.println(zeroPosition.peek());
		
		while(zeros > 0) {		
				if(zeroPosition.peek() - i >= arr[i]) {
					answer = "No";
				}else {
					answer = "Yes";
					break;
				}
				i++;
				if(i == zeroPosition.peek()) {
					zeros--;
					i = 0;
					zeroPosition.pop();
				}
		}
		
		System.out.println(answer);
	}
}
