class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndxMap = new HashMap<>();

        int[] output= {0,1};
        numIndxMap.put(nums[0], 0);
        for (int i=1; i<nums.length; i++) {
            int diff = target - nums[i];

            if(numIndxMap.containsKey(diff)) {
                output[0] = numIndxMap.get(diff);
                output[1] = i;
            }
            numIndxMap.put(nums[i], i);
        }

        return output;
    }
}
