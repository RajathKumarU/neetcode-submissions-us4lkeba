class StockSpanner {

    Stack<Integer> stk;
    Stack<Integer> tmp;

    public StockSpanner() {
        stk = new Stack<>();
        tmp = new Stack<>();
    }
    
    public int next(int price) {
        int res = 1;

        while(!stk.isEmpty() && stk.peek() <= price) {
            res++;
            tmp.push(stk.pop());
        }

        while(!tmp.isEmpty()) {
            stk.push(tmp.pop());
        }

        stk.push(price);

        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */