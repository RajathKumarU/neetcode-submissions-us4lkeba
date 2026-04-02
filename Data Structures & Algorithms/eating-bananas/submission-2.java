class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();

        int finalSpeed = r;
        while (l<=r) {
            int mid = (l+r)/2;

            int totalHoursNeeded = 0;
            for(int p:piles) {
                totalHoursNeeded += Math.ceil((double)p/mid);
            }

            if (totalHoursNeeded <= h) {
                finalSpeed = mid;
                r = mid-1;
            } else {
                l = mid+1;
            }
        }

        return finalSpeed;
    }
}
