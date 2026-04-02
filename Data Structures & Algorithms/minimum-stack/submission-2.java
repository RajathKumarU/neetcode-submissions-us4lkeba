class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> min;
    private Stack<Integer> temp;

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
        temp = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(min.isEmpty() || val <= min.peek()) {
            min.push(val);
        }
    }
    
    public void pop() {
        int val = stack.pop();
        if(min.peek()==val)
            min.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
