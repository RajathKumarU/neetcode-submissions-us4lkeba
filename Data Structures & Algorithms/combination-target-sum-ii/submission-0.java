class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
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
        backtrack(nums, i+1, cur, res, target, total + nums[i]);
        cur.removeLast();
        while(i < nums.length-1 && nums[i] == nums[i+1])
            i++;
        backtrack(nums, i+1, cur, res, target, total);
    }
}
