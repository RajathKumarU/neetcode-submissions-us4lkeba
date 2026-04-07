class Solution {
    public int findMin(int[] nums) {

        int l=0, r=nums.length-1;

        int lowest = nums[0];
        while (l<=r) {
            int mid = (l+r)/2;
            System.out.println(mid);

            if(mid < lowest)
                lowest = nums[mid];

            if(nums[mid] > nums[l]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return lowest;
    }
}
