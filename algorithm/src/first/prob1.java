package first;

import java.security.DrbgParameters.NextBytes;
import java.util.Scanner;
import java.util.Stack;

public class prob1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < N; i++) {
			stack.add(scanner.nextInt());
		}
		int K = scanner.nextInt();
		
		
		System.out.println(peek(stack, K, 1));	
	}	
	
	public static int peek(Stack<Integer> stack, int K, int answer) {
		if(stack.isEmpty()) {
			return answer;
		}else{
			if(stack.pop() < K) answer++;
			return peek(stack, K, answer);
		}

	}
}

