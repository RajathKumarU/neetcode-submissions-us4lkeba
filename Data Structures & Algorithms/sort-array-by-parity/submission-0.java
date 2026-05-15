class Solution {
    public int[] sortArrayByParity(int[] nums) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for(int num: nums) {
            if(num % 2 == 0)
                even.add(num);
            else
                odd.add(num);
        }

        even.addAll(odd);
        
        return even.stream().mapToInt(Integer::intValue).toArray();
        
    }
}