class Solution {
    public boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>();
        set.add(n);

        do {
            n = sumOfSq(n);
            System.out.println(n);

            if(set.contains(n))
                return false;
            else
                set.add(n);
        } while(n != 1);

        return true;
        
    }

    public int sumOfSq(int val) {
        if(val < 10) {
            return val * val;
        } else {
            int sumOfSq = 0;
            while (val > 9) {
                int rem = val%10;
                val = val /10;
                
                sumOfSq += rem * rem;
            }

            return sumOfSq;
        }
    }
}
