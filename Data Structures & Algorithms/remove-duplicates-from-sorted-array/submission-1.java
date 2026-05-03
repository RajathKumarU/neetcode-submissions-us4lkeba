class Solution {
    public int removeDuplicates(int[] nums) {
        int l=0, r=0, n = nums.length;

        while(r<n) {
            nums[l] = nums[r];
            while(r < n && nums[l] == nums[r]) {
                r++;
            }
            l++;
        }

        return l;
        
    }
}