package group;

public class Ex104 {
    static int PATHWAY_COLOUR = 0;
    static int WALL_COLOUR = 1;
    static int BOMB_COLOUR = 2;
    static int PATH_COLOUR = 3;
    static int BOMB_COUNT = 0;
    static int maze[][] = {
            {0, 2, 2, 0},
            {2, 2, 2, 2},
            {2, 2, 2, 2},
            {0, 2, 2, 0}
    };
    static int N=4;
    static int count = 0;

    public static void main(String[] args) {
        findMazePath(0, 0);
        System.out.println("갯수: " + count);
    }

    public static void findMazePath(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N || maze[x][y] == WALL_COLOUR)
            return;
        else if (x == N - 1 && y == N - 1) {
        	count++;
        	printMaze();
            return;
        } else {  
        	if (maze[x][y] == BOMB_COLOUR) {
        		BOMB_COUNT++;
            }
            maze[x][y] = PATH_COLOUR;
            findMazePath(x - 1, y);
            findMazePath(x, y + 1);
            findMazePath(x + 1, y);
            findMazePath(x, y - 1);
        }
    }
    public static void printMaze() {
        System.out.println("경로 " + count + ": ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}