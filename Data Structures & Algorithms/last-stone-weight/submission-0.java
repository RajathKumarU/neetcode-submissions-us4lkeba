class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int wt: stones) {
            minHeap.offer(-1 * wt);
        }

        while (minHeap.size() > 1) {
            int h1 = minHeap.poll();
            int h2 = minHeap.poll();
            int diff = Math.abs((-1 * h1) - (-1 * h2));

            if (diff > 0) {
                minHeap.offer(-1 * diff);
            }
        }

        if(minHeap.size() > 0) {
            return -1 * minHeap.peek();
        } else {
            return 0;
        }
        
    }
}
