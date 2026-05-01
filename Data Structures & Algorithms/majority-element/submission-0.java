class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int res = 0, maxCount = 0;

        for(int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if(freq.get(num) > maxCount) {
                res = num;
                maxCount = freq.get(num);
            }
        }

        return res;
    }
}