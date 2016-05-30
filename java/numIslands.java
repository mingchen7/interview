// 2-dimension
public class Solution {
    public int numIslands(char[][] grid) {        
        // DFS to find the connected '1's as one island
        // using a boolean[][] visited map to avoid duplicate check
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, grid, visited);
                    total++;
                }
            }
        }
        return total;
    }

    private void dfs(int i, int j, char[][] grid, boolean[][] visited) {
        visited[i][j] = true;
        int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int m = 0; m < moves.length; m++) {
            int iPrime = i + moves[m][0];
            int jPrime = j + moves[m][1];
            if (iPrime >= 0 && iPrime < grid.length 
                && jPrime >= 0 && jPrime < grid[0].length
                && grid[iPrime][jPrime] == '1' 
                && !visited[iPrime][jPrime]) {
                dfs(iPrime, jPrime, grid, visited);
            }
        }
    }
}

//1-dimension
public class Solution {
    public int numIslands(char[] grid) {        
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int total = 0;
        boolean newIsland = true;
        for(int i = 0; i < grid.length; i++){
            if(grid[i] == '1'){
                if(newIsland){
                    total++;
                    newIsland = false;        
                }
            }
            else{
                newIsland = true;
            }            
        }
        
        return total;
    }    
}

