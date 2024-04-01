package algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class prob9 {
	public static void main(String[] args) {
		
		try {
    		File file = new File("d:\\\\input9.txt");
    		Scanner sc = new Scanner(file);
    		int N = sc.nextInt();
    		int[][] abl = new int[N][N];
    		for(int i = 0; i < N; i++) {	
    			for(int j = 0; j < N; j++) {	
    				abl[i][j] = sc.nextInt();
    			}	
    		}
    		int k = sc.nextInt();
    		int[] team = new int[k];
    	    int maxAbility = getMax(abl, N, k);
    	    System.out.println("팀의 최대 능력치: " + maxAbility);

    		
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	}          	
	}
	static int getMax(int[][] abl, int N, int k) {
	    	
	    int[][] max = new int[N][2];
	    int rmax = 0;
		int index[] = new int[k];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				max[i][0] += abl[j][i];
				max[i][1] = i;
			}
		}
			
		Arrays.sort(max, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
		             return o2[1] - o1[1];
				}else {
					return o2[0] - o1[0];
			    }
		     }
		});
	
		for(int i = 0; i < k; i++) {
			index[i] = max[i][1];
		}
		int answer = 0;
		for(int i = 0; i < k; i++) {
			for(int j = 0; j < k; j++) {
				answer += abl[index[i]][index[j]];
			}
		}
			
		return answer;		
	}
}
