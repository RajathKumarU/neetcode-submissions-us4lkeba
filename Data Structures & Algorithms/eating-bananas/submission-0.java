class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = 0;

        for(int i=0; i<piles.length;i++) {
            if(piles[i] > max) {
                max = piles[i];
            }
        }
        
        int perHourRate = h/piles.length;

        return max/perHourRate;
    }
}
