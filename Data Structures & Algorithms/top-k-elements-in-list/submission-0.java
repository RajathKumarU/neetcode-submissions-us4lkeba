class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numCountMap = new HashMap<>();
        List<Integer> output = new ArrayList<>();
        int outCount = 0;

        for(int i=0; i<nums.length; i++) {
            numCountMap.put(nums[i], numCountMap.getOrDefault(nums[i],0)+1);
        }

        for(Integer num: numCountMap.keySet()) {
            if(numCountMap.get(num) >= k) {
                output.add(num);
                outCount++;
            }
        }

        return output.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
