class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            Set<Integer> visit = new HashSet<>();

            if (dfs(u, -1, visit, adj)) {
                return edge;
            }
        }

        return new int[0];
    }

    private boolean dfs(int node, int parent, Set<Integer> visit, 
            List<List<Integer>> adj) {
        
        if(visit.contains(node)) {
            return true;
        }

        visit.add(node);

        for(int nei: adj.get(node)) {
            if(nei == parent) {
                continue;
            }

            if(dfs(nei, node, visit, adj)) {
                return true;
            }
        }

        return false;
    }
}
