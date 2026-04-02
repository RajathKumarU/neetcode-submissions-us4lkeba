class Solution {
    public int[] plusOne(int[] digits) {

        int add = 1;
        int[] res = new int[digits.length+1];
        for (int i=digits.length-1; i>=0;i--) {
            int dig = digits[i];

            if(dig == 9 && add==1) {
                res[i+1] = 0;
                add = 1;
            } else if (add==1) {
                res[i+1] = ++dig;
                add = 0;
            } else {
                res[i+1] = dig;
                add = 0;
            }
        }

        if(add > 0) {
            res[0] = add;
        }

        if(res[0] == 0 && res.length>1) {
            int[] res2 = new int[digits.length];
            for(int i = 1; i<res.length;i++) {
                res2[i-1] = res[i];
            }

            return res2;
        }

        return res;
        
    }
}
