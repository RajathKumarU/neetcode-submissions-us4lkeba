class Solution {
    public int[] replaceElements(int[] arr) {
        int res[] = new int[arr.length];
        res[arr.length-1] = -1;
        
        int max = -1;
        for(int i=arr.length-2; i>=0; i--) {
            max = Math.max(max, arr[i+1]);
            res[i] = max;
        }

        return res;
    }
}