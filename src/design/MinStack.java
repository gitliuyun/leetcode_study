package design;

import java.util.Stack;

public class MinStack {
    Stack<Node> stack;
    public class Node{
        int val;
        int min;
        public void Node(Node node) {
            this.val = node.val;
            this.min = node.min;
        }
    }
    public MinStack(){
        stack  = new Stack();
    }
    public void push(int x) {
        Node node = new Node();
        node.val = x;
        if (stack.isEmpty()) {
            node.min = x;
        } else {
            node.min = Math.min(stack.peek().min, x);
        }
        stack.push(node);
    }
    public void pop() {
        stack.pop();
    }
    public int top() {
        return stack.isEmpty() ? null : stack.peek().val;
    }
    public int getMin() {
        return stack.isEmpty() ? null : stack.peek().min;
    }
}
