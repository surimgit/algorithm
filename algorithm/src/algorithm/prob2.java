package algorithm;

import java.util.Scanner;
import java.util.Stack;

public class prob2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	    
		int N = scanner.nextInt();	       
	    int[] arr = new int[N];
	    for (int i = 0; i < N; i++) {
	    	arr[i] = scanner.nextInt();
	    }

	    int K = scanner.nextInt();
	    int nearest = Nearest(arr, K, 0, N - 1);

	    System.out.println(nearest);
	}

	public static int Nearest(int[] arr, int K, int left, int right) {
        if(left > right) {
            return arr[right];
        }
        
        int mid = left + (right - left) / 2;

        int nearest = arr[mid];
        if(mid - 1 >= left && Math.abs(arr[mid] - K) > Math.abs(Nearest(arr, K, left, mid - 1) - K)) {
            nearest = Nearest(arr, K, left, mid - 1);
        }
        if(mid + 1 <= right && Math.abs(arr[mid] - K) > Math.abs(Nearest(arr, K, mid + 1, right) - K)) {
            nearest = Nearest(arr, K, mid + 1, right);
        }

        return nearest;
    }
}