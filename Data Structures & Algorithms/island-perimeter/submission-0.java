class Solution {
    boolean[][] visited;

    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }

        return 0;
    }

    private int dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]==0) {
            return 1;
        }

        if(visited[i][j])
            return 0;
        
        visited[i][j] = true;

        return dfs(grid, i, j+1)
                + dfs(grid, i+1, j)
                + dfs(grid, i, j-1)
                + dfs(grid, i-1, j);
    }
}