package algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class prob10 {
	public static void main(String[] args) {
//	int N = 8;
//	int[][] infor = new int[N][3];
//	infor = new int[][] // 부피, 가격, 폐기비용 가격 - 폐기비용
//			{{3, 7, 9},
//			{5, 19, 8},
//			{8, 6, 1},
//			{13, 1, 9},
//			{1, 3, 8},
//			{7, 11, 7},
//			{4, 16, 1},
//			{11, 5, 6}};
//	int W = 35;

	try {
		File file = new File("d:\\\\input10.txt");
		Scanner sc = new Scanner(file);
		int N = sc.nextInt();
		int infor[][] = new int[N][3]; 
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				infor[i][j] = sc.nextInt();
			}
		}		
		while(sc.hasNextLine()){
			int W = sc.nextInt();
			

			int maxProfit = getMax(N, W, infor);
			System.out.println(maxProfit);
        }
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}          
}

	
	
	public static int getMax(int N, int W, int[][] infor) {
		 int[][] dp = new int[N + 1][W + 1];

		 for(int i = 1; i <= N; i++) {
	            int volume = infor[i - 1][0];
	            int value = infor[i - 1][1];
	            int gar = infor[i - 1][2];
	            for(int w = 0; w <= W; w++) {
	                if(volume <= w) {
	                    dp[i][w] = Math.max(dp[i - 1][w - volume] + value, dp[i - 1][w] - gar);
	                }else {
	                    dp[i][w] = dp[i - 1][w] - gar;
	                }
	            }
	        }
	        return dp[N][W];
    }
}
