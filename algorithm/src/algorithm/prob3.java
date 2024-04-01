package algorithm;

import java.util.Scanner;

public class prob3 {
    static int PATHWAY_COLOR = 0;
    static int BLOCKED_COLOR = 1;
    static int BOMB_COLOR = 2;
    static int PATH_COLOR = 3;
    static int count = 0;

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int maze[][] = new int[N][N];
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < N; j++) {
    			maze[i][j] = sc.nextInt();
    		}
    	}
    	int K = sc.nextInt();
        findMazePath(0, 0, N, maze, K);
        System.out.println(count);

    }

    public static void findMazePath(int x, int y, int N, int maze[][], int K) {
        if(x < 0 || y < 0 || x >= N || y >= N || maze[x][y] != PATHWAY_COLOR)
            return;
        else if(x == N - 1 && y == N - 1) {
        	int length = 0;
        	for(int i = 0; i < N; i++) {
        		for(int j = 0; j < N; j++){
    				if(maze[i][j] == PATH_COLOR) {
    					length++;
    				}
        		}
        	}
	        if(length <= K) {
	        	count++;
	        }
        }else {			
            maze[x][y] = PATH_COLOR;
            findMazePath(x - 1, y, N, maze, K);
            findMazePath(x, y + 1, N, maze, K);
            findMazePath(x + 1, y, N, maze, K);
            findMazePath(x, y - 1, N, maze, K);
            maze[x][y] = PATHWAY_COLOR;
        }
    }

}