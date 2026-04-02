class Solution {
    public int findMin(int[] nums) {

        int l=0, r=nums.length-1;

        int lowest = nums[0];
        while (l<=r) {
            if(nums[l] < nums[r]) {
                return Math.min(lowest, nums[l]);
            }

            int mid = (l+r)/2;
            System.out.println(mid);

            lowest = Math.min(lowest, nums[mid]);

            if(nums[mid] >= nums[l]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return lowest;
    }
}
