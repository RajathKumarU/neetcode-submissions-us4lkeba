class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        int m = grid.length;
        int n = grid[0].length;

        int freshCount = 0;

        for (int i=0; i < m; i++) {
            for (int j=0; j < n; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if(grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if(q.size() == 0) return -1;

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        int mins = 0;
        while (freshCount > 0 && !q.isEmpty()) {

            for (int i = 0; i < q.size(); i++) {
                int[] val = q.poll();
                int r = val[0];
                int c = val[1];

                for(int[] dir: dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(nr < 0 || nr >= m || nc < 0 || nc >= n 
                            || grid[nr][nc] != 1) {
                        continue;
                    }

                    q.offer(new int[]{nr, nc});
                    grid[nr][nc] = 2;
                    freshCount--;
                }
            }

            mins++;
        }

        return freshCount == 0? mins: -1;
    }
}
