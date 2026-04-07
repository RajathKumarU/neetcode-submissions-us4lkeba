class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> idxStk = new Stack<>();
        Stack<Integer> htStk = new Stack<>();
        int maxArea = 0;

        for (int i=0;i<heights.length;i++) {
            int height = heights[i];
            int start = i;
            
            while (!htStk.isEmpty() && height < htStk.peek()) {
                int popIdx = idxStk.pop();
                int popHt = htStk.pop();

                maxArea = Math.max(maxArea, height * (i-start));

                start = popIdx;
            }

            htStk.push(height);
            idxStk.push(start);
        }

        for(int i=0; i<htStk.size(); i++) {
            int popIdx = idxStk.pop();
            int popHt = htStk.pop();

            maxArea = Math.max(maxArea, popHt * (htStk.size()-popIdx));
        }

        return maxArea;
    }
}
