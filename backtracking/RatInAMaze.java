package backtracking;

import java.util.ArrayList;

public class RatInAMaze {
    static int[][] directions = {
        {1, 0}, {0, -1}, {0, 1}, {-1, 0}
    };

    static char dirCh[] = {'D', 'L', 'R', 'U'};
    public static ArrayList<String> ratInMaze(int[][] maze){
        ArrayList<String> res = new ArrayList<>();
        int n = maze.length;

        if(maze[0][0] == 0 || maze[n-1][n-1] == 0)
            return res;

        boolean vis[][] = new boolean[n][n];
        backtrack(maze, n, 0, 0, res, new StringBuilder(), vis);

        return res;
    }
    private static void backtrack(int[][] maze, int n, int row, int col, 
        ArrayList<String> res, StringBuilder sb, boolean[][] vis
    ){
        if(row == n-1 && col == n-1){
            res.add(sb.toString());
            return ;
        }

        vis[row][col] = true;

        for(int i=0; i<4; i++){
            int new_row = row + directions[i][0];
            int new_col = col + directions[i][1];

            if(isValid(n, n, new_row, new_col)
            && !vis[new_row][new_col]
            && maze[new_row][new_col] == 1){
                sb.append(dirCh[i]);
                backtrack(maze, n, new_row, new_col, res, sb, vis);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        vis[row][col] = false;
    }
    private static boolean isValid(int m, int n, int row, int col){
        if(row<0 || row>=m || col<0 || col>=n)
            return false;

        return true;
    }
    public static void main(String[] args) {
        int maze[][] = {
            {1, 0, 0, 0}, 
            {1, 1, 0, 1}, 
            {1, 1, 0, 0}, 
            {0, 1, 1, 1}
        };
        
        System.out.println(ratInMaze(maze));
    }
}
