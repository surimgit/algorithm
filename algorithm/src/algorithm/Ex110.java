package algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex110 {
	public static void main(String[] args) {
		
		try {
    		File file = new File("d:\\\\input9.txt");
    		Scanner sc = new Scanner(file);
    		int N = sc.nextInt();
    		System.out.println(N);
    		int[][] abl = new int[N][N];
    		for(int i = 0; i < N; i++) {	
    			for(int j = 0; j < N; j++) {	
    				abl[i][j] = sc.nextInt();
    				System.out.println(abl[i][j]);
    			}	
    		}
    		int k = sc.nextInt();
    		System.out.println(k);

    		
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	}          
		
		
		
	
	}
}
