class Solution {
    public void islandsAndTreasure(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();

        int m = grid.length;
        int n = grid[0].length;

        for (int i=0; i < m; i++) {
            for (int j=0; j < n; j++) {
                if(grid[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }

        if(q.size() == 0) return;

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        while (!q.isEmpty()) {
            int[] val = q.poll();
            int r = val[0];
            int c = val[1];

            for(int[] dir: dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr < 0 || nr >= m || nc < 0 || nc >= n 
                        || grid[nr][nc] != Integer.MAX_VALUE) {
                    continue;
                }

                q.add(new int[]{nr, nc});

                grid[nr][nc] = grid[r][c] + 1;
            }
        }
    }
}
