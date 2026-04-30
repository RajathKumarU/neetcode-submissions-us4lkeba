class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int fir = 0, sec = 0;

        int m=nums1.length, n=nums2.length, total = m+n;
        int median1 = 0, median2 = 0;

        for (int i=0; i<=total/2; i++) {
            median2 = median1;

            if(fir<m && sec<n) {
                if(nums1[fir] < nums2[sec]) {
                    median1 = nums1[fir];
                    fir++;
                } else {
                    median1 = nums2[sec];
                    sec++;
                }
            } else if(fir < m) {
                median1 = nums1[fir];
                fir++;
            } else {
                median1 = nums2[sec];
                sec++;
            }
        }

        if (total%2 == 0) {
            return (median1 + median2) / 2.0;
        } else {
            return (double) median1;
        }
        
    }
}
