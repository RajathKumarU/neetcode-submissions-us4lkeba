class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;

        int l=0, r=heights.length-1;
        while (l<r) {
            int area = Math.min(heights[l], heights[r]) * (r-l);

            if(area > maxArea) {
                maxArea = area;
            }

            if(heights[l] > heights[r]) {
                r--;
            } else {
                l++;
            }
        }

        return maxArea;
    }
}
