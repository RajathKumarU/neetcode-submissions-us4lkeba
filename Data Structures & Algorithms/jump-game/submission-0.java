class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;

        int goal = nums[n-1];
        int tarIdx = n-1;
        for(int i=n-2; i>=0; i--) {
            if(nums[i] >= tarIdx-i) {
                tarIdx = i;
            }
        }

        return tarIdx == 0;
    }
}
