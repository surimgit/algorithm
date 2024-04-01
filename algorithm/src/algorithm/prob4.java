package algorithm;

import java.util.Scanner;

public class prob4 {
	static int[][] maze;
    static int N;
    static int K;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        maze = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        K = sc.nextInt();
        boolean result = findMaze(0, 0, 0);

        if (result) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
    
    public static boolean findMaze(int x, int y, int bomb) {
        if(x < 0 || y < 0 || x >= N || y >= N || maze[x][y] == 1 || visited[x][y]) {
            return false;
        }    
        if(maze[x][y] == 2) {
        	bomb++;
        }
        if(bomb > K) {
            return false;
        }
        if(x == N - 1 && y == N - 1) {
            return true;
        }
        visited[x][y] = true;
        return findMaze(x - 1, y, bomb) || findMaze(x + 1, y, bomb) ||
        		findMaze(x, y - 1, bomb) || findMaze(x, y + 1, bomb);
    }
}
