package first;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//0 0 0 0 1 0 0 0
//0 1 1 0 1 0 1 0
//0 0 0 0 0 0 1 0
//0 1 0 1 1 0 1 1
//0 1 0 1 0 0 0 0
//0 1 0 1 0 0 1 0
//0 1 0 0 1 1 1 0
//0 0 0 0 0 0 0 0

public class prob5 {
	static int K = 0;
	static int N = 0;
    static int WALL = 1;
    static int[] DX = {0, 0, 1, -1};
    static int[] DY = {1, -1, 0, 0};
    static int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
    public static void main(String[] args) {
    	
		try {
			File file = new File("d:\\\\file.txt");
			Scanner sc = new Scanner(file);
			N = sc.nextInt();
			int maze[][] = new int[N][N]; 
			for(int i = 0; i < N; i++) {
				for(int j = 0; j <N; j++) {
					maze[i][j] = sc.nextInt();
				}
			}		
			while(sc.hasNextLine()){
				K = sc.nextInt();
				
			int minRest = find(maze);
			System.out.println(minRest);
            }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}          
    }
    
    public static int find(int[][] maze) {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, K});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int moved = current[2];
            int remainingMove = current[3];

            if(x == N - 1 && y == N - 1) {
                return moved;
            }

            for(int i = 0; i < 4; i++) {
                int nx = x + DX[i];
                int ny = y + DY[i];

                if(Va(nx, ny) && maze[nx][ny] == 0&& !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    int nextRest = remainingMove - 1;
                    if(nextRest >= 0)
                    	queue.offer(new int[]{nx, ny, moved + 1, nextRest});
                }
            }
        }

        return -1;
    }

    public static boolean Va(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}