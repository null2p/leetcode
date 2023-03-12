class MinStack {
    List<Integer> minStack;
    List<Integer> stack;
    public MinStack() {
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
    }
    
    public void push(int val) {
        stack.add(val);
        updateMin(val);
    }
    
    public void pop() {
        Integer topVal = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        minStack.remove(topVal);
        // for(int i = 0 ; i < minStack.size() ; i ++){
        //     System.out.println(minStack.get(i));
        // }
    }
    
    public int top() {
        return stack.get(stack.size()-1);
    }
    
    public int getMin() {
        return minStack.get(0);
    }

    private void updateMin(int val){
        for(int i = 0 ; i < minStack.size(); i++){
            int tmp = minStack.get(i);
            if(val <= tmp){
                minStack.add(i,val);
                return ;
            }
        }
        minStack.add(val);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
