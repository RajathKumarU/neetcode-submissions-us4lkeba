class Solution {
    public int longestConsecutive(int[] nums) {

        Arrays.sort(nums);

        int count = 0, max=0, found=0;
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i] == nums[i+1]) {
                continue;
            }
            if (nums[i] + 1 == nums[i+1]) {
                count++;
                found=1;
                if(count > max) 
                    max=count;
            } else {
                count = 0;
            }
        }

        return found==1? max+1:max;
    }
}
