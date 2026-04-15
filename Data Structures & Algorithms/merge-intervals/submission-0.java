class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> 
            Integer.compare(a[0], b[0]));

        List<int[]> res = new LinkedList<>();
        res.add(intervals[0]);

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            int prevEnd = res.getLast()[1];

            if(start <= prevEnd) {
                res.getLast()[1] = Math.max(end, prevEnd);
            } else {
                res.addLast(new int[] {start, end});
            }
        }

        return res.toArray(new int[res.size()][]);
        
    }
}
