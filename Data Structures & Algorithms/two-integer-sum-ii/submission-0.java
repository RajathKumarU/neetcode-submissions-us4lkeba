class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] a = new int[2];
        int i=0, j=numbers.length-1;
        while(i<j) {
            if(numbers[i] + numbers[j] == target) {
                a[0] = numbers[i];
                a[1] = numbers[j];

                return a;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return a;
    }
}
