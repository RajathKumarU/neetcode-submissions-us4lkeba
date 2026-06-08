class Solution {
    private Map<Integer, List<Integer>> preMap = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();
    private Set<Integer> cycle = new HashSet<>();
    private List<Integer> output = new ArrayList<>();

    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for(int i=0; i<numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        for(int[] prereq: prerequisites) {
            preMap.get(prereq[0]).add(prereq[1]);
        }

        for(int c=0; c<numCourses; c++) {
            if(!dfs(c)) {
                return new int[0];
            }
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = output.get(i);
        }
        return result;
    }

    private boolean dfs(int crs) {

        if(cycle.contains(crs)) {
            return false;
        }

        if(visited.contains(crs))
            return true;

        cycle.add(crs);

        for(int pre: preMap.get(crs)) {
            if(!dfs(pre)) {
                return false;
            }
        }

        cycle.remove(crs);
        visited.add(crs);
        output.add(crs);

        return true;

    }
}
