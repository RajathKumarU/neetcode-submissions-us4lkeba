class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>( (a,b) -> b-a);
        for(int wt: stones) {
            maxHeap.offer(wt);
        }

        while (maxHeap.size() > 1) {
            int h1 = maxHeap.poll();
            int h2 = maxHeap.poll();
            int diff = Math.abs(h1 - h2);

            if (diff != 0) {
                maxHeap.offer(diff);
            }
        }
        
        maxHeap.offer(0);

        return maxHeap.peek();
        
    }
}
