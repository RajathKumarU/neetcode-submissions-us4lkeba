class Solution {
    public int minOperations(String[] logs) {
        Stack<String> stk = new Stack<>();

        for(String log: logs) {
            if (log.equals("../")) {
                if(!stk.isEmpty())
                    stk.pop();
            } else if (!log.equals("./")) {
                stk.push(log);
            }
        }

        return stk.size();
    }
}