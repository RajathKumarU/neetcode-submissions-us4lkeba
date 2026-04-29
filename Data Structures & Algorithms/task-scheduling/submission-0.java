class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> taskFreq = new HashMap<>();
        for(char t: tasks) {
            taskFreq.put(t, taskFreq.getOrDefault(t, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap 
            = new PriorityQueue<>(Collections.reverseOrder());
        
        for(char t: taskFreq.keySet()) {
            maxHeap.add(taskFreq.get(t));
        }

        int time=0;
        Queue<int[]> q = new LinkedList<>();

        while(!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;

            if(maxHeap.isEmpty()) {
                time = q.peek()[1];
            } else {
                int cnt = maxHeap.poll()-1;
                if(cnt > 0) {
                    q.add(new int[] {cnt, time + n});
                }
            }

            if(!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.add(q.poll()[0]);
            }
        }

        return time;
        
    }
}
