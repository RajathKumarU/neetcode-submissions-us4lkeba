class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        int[] nums2 = new int[n];

        for(int i=0; i<nums.length; i++) {
            nums2[(i+k) % n] = nums[i];
        }

        for(int i=0; i<nums2.length; i++) {
            nums[i] = nums2[i];
        }
        
    }
}