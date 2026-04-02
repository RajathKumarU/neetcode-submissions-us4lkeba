class Solution {
    public int search(int[] nums, int target) {

        int l=0, r=nums.length-1;

        int res=-1;
        while (l<=r) {
            int mid = (l+r)/2;

            System.out.println("l:"+l+" r:" + r +" m:"+ mid);

            if(target == nums[mid])
                return mid;

            // Left Sorted Array
            if (nums[l] <= nums[mid]) {
                if(target > nums[mid] || target < nums[l])
                    l = mid+1;
                else
                    r = mid-1;
            }
            // Right Sorted Array
            else {
                if(target < nums[mid] || target > nums[r])
                    r = mid-1;
                else
                    l = mid+1;
            }
        }

        return res;

    }
}
