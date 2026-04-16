class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(nums, 0, cur, res, target, 0);
        return res;
    }

    public void backtrack(int[] nums, int i, List<Integer> cur, 
            List<List<Integer>> res, int target, int total) {
        if(total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if(i >= nums.length || total > target)
            return;
        
        cur.add(nums[i]);
        backtrack(nums, i, cur, res, target, total + nums[i]);
        cur.removeLast();
        backtrack(nums, i+1, cur, res, target, total);
    }
}
