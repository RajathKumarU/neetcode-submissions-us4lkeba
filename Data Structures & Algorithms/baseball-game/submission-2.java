class Solution {
    public int calPoints(String[] operations) {

        Stack<Integer> stk = new Stack<>();

        for(String op: operations) {
            if("+".equals(op)) {
                int top = stk.pop();
                int newTop = top + stk.peek();

                stk.push(top);
                stk.push(newTop);
            } else if ("D".equals(op)) {
                stk.push(2 * stk.peek());
            } else if ("C".equals(op)) {
                stk.pop();
            } else {
                stk.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        for(int score: stk) {
            sum += score;
        }

        return sum;
        
    }
}