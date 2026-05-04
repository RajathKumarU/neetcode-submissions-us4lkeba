class Solution {
    public int calPoints(String[] operations) {

        Stack<Integer> stk = new Stack<>();
        int sum = 0;

        for(String op: operations) {
            if("+".equals(op)) {
                int top = stk.pop();
                int newTop = top + stk.peek();

                stk.push(top);
                stk.push(newTop);

                sum += newTop;
            } else if ("D".equals(op)) {
                stk.push(2 * stk.peek());
                sum += stk.peek();
            } else if ("C".equals(op)) {
                sum -= stk.pop();
            } else {
                stk.push(Integer.parseInt(op));
                sum += stk.peek();
            }
        }
        
        return sum;
    }
}