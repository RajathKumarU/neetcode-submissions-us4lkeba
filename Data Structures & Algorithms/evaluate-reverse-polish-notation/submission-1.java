class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();

        for(int i=0;i<tokens.length;i++) {
            String token = tokens[i];
            if(isInteger(token)) {
                s.push(Integer.parseInt(token));
            } else {
                int val2 = s.pop();
                int val1 = s.pop();

                int compVal = compute(val1, val2, token);

                s.push(compVal);
            }
        }

        return s.pop();
    }

    public static int compute(int val1, int val2, String operand) {
        if(operand.equals("+")) {
            return val1 + val2;
        } else if(operand.equals("-")) {
            return val1 - val2;
        } else if(operand.equals("*")) {
            return val1 * val2;
        } else {
            return val1 / val2;
        }
    }

    public static boolean isInteger(String str) {
        if (str == null) { // Check for null input first
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            // If an exception is thrown, it's not a valid integer
            return false;
        }
    }
}
