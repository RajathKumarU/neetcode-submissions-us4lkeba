class Solution {
    public int calPoints(String[] operations) {

        Stack<Integer> stk = new Stack<>();

        for(String op: operations) {
            if("+".equals(op)) {
                int top1 = stk.pop();
                int top2 = stk.pop();

                stk.push(top2);
                stk.push(top1);
                stk.push(top2 + top1);
            } else if ("D".equals(op)) {
                int top1 = stk.pop();

                stk.push(top1);
                stk.push(2 * top1);
            } else if ("C".equals(op)) {
                if(!stk.isEmpty())
                    stk.pop();
            } else {
                stk.push(Integer.parseInt(op));
            }

            System.out.println(stk); 
        }

        int sum = 0;
        while(!stk.isEmpty()) {
            sum += stk.pop();
        }

        return sum;
        
    }
}