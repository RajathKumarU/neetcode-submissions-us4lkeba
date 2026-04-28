class Solution {

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int maxArea = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                int[] area = new int[]{0};
                if(grid[r][c] == 1) {
                    bfs(grid, r, c, area);
                    maxArea = Math.max(maxArea, area[0]);
                }
            }
        }
        
        return maxArea;
    }

    private void bfs(int[][] grid, int r, int c, int[] area) {
        Queue<int[]> q = new LinkedList<>();
        grid[r][c] = 0;
        area[0]++;
        q.add(new int[]{r,c});

        while (!q.isEmpty()) {
            int[] node = q.poll();

            int row = node[0], col = node[1];

            for(int[] dir: directions) {
                int nr = row + dir[0], nc = col + dir[1];

                if(nr >= 0 && nc >= 0 && nr < grid.length 
                        && nc < grid[0].length && grid[nr][nc] == 1) {
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = 0;
                    area[0]++;
                }
            }
        }
    }
}
