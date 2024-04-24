package first;

import java.util.Scanner;

public class prob7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		
		System.out.println(count(n));
				
	}public static int count(int n) {
        if(n == 1) {
            return 2;  
        }

        int end0 = 1;
        int end1 = 1;

        for(int i = 2; i <= n; i++) {
            int newEnd0 = end1;
            int newEnd1 = end0 + end1;

            end0 = newEnd0;
            end1 = newEnd1;
        }

        return end0 + end1;
    }
}
