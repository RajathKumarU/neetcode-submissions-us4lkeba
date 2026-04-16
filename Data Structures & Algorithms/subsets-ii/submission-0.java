class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, cur, res);
        return res;
    }

    public void backtrack(int[] nums, int i, List<Integer> cur, 
            List<List<Integer>> res) {
        if(i >= nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        cur.add(nums[i]);
        backtrack(nums, i+1, cur, res);
        cur.removeLast();
        while(i < nums.length-1 && nums[i] == nums[i+1])
            i++;
        backtrack(nums, i+1, cur, res);
    }
}
