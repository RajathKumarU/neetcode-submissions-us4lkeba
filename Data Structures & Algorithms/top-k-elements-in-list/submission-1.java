class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numCountMap = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        int outCount = 0;

        for(int i=0; i<nums.length; i++) {
            numCountMap.put(nums[i], numCountMap.getOrDefault(nums[i],0)+1);
        }

        for(Integer num: numCountMap.keySet()) {
            freq[numCountMap.get(num)].add(num);
        }

        int res[] = new int[k];
        int index=0;
        for (int i = freq.length -1; i>0 && index<k;i--) {
            for (int n: freq[i]) {
                res[index++] = n;
                if(index==k) {
                    return res;
                }
            }
        }
        return res;
    }
}
