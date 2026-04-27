class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1],b[1]));

        int prevEnd = intervals[0][1], res = 0, n = intervals.length;

        for(int i=1; i<n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(start < prevEnd) {
                res++;
            } else {
                prevEnd = end;
            }
        }

        return res;
    }
}
