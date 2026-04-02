class Solution {
    public int[] dailyTemperatures(int[] t) {
        Stack<Integer> valStk = new Stack<>();
        Stack<Integer> idxStk = new Stack<>();

        int[] res = new int[t.length];

        for (int i=0; i<t.length; i++) {
            if(valStk.isEmpty()) {
                valStk.push(t[i]);
                idxStk.push(i);
            } else {
                int val = t[i];
                while (!valStk.isEmpty() && val > valStk.peek()) {
                    valStk.pop();
                    int idx = idxStk.pop();

                    res[idx] = i-idx;
                }

                valStk.push(val);
                idxStk.push(i);
            }
        }

        return res;
    }
}
