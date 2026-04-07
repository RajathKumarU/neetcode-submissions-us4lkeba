class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int top=0, bot=matrix.length-1;

        while (top <= bot) {
            int mid = (top + bot) / 2;
            int val = matrix[mid][matrix[0].length - 1];
            System.out.println("RowVal: " + val + ", Row: " + mid);
            if (target > val) {
                top = mid + 1;
            } else if (target < val) {
                bot = mid - 1;
            } else {
                break;
            }
        }

        if(!(top <= bot))
            return false;

        int row = (top + bot) /2 ;
        int l = 0, r = matrix[0].length-1;
            while(l <= r) {
                int mid = (l+r)/2;
                int val = matrix[row][mid];
                System.out.println("ColVal: " + val + ", Col: " + mid);
                if(target > val) {
                    l = mid + 1;
                } else if (target < val) {
                    r = mid - 1;
                } else {
                    return true;
                }
            }

        return false;
        
    }
}
