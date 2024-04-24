package first;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class prob8 {
	public static void main(String[] args) {
	    try {
	    	File file = new File("d:\\\\input.txt");
	    	Scanner sc = new Scanner(file);
	    	int N = sc.nextInt();
		    int W = sc.nextInt();
	    	int[] values = new int[N];
		    int[] weights = new int[N];
	    	for(int i = 0; i < N; i++) {	
	    		weights[i] = sc.nextInt();
	    	}	
	    	for(int i = 0; i < N; i++) {	
	    		values[i] = sc.nextInt();
	    	}
	    	int maxProfit = knapsack(weights, values, W);
	    	System.out.println(maxProfit);	            
	    	} catch (FileNotFoundException e) {
	    		e.printStackTrace();
	    	}          

	}
	    
	public static int knapsack(int[] weights, int[] values, int W) {
		int n = weights.length;
	    int[][] dp = new int[n + 1][W + 1];
	    for(int i = 1; i <= n; i++) {
	        for(int j = 1; j <= W; j++) {
	        	if (weights[i - 1] <= j) {
	        		dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]]);
	            }else {
	                dp[i][j] = dp[i-1][j];
	            }
	        }
	    }
	    return dp[n][W];
	}
}
