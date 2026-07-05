import java.util.Stack;

public class sorting_stack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(3);
        stack.push(4);
        stack.push(2);

        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack: " + stack);

    }
    public static Stack<Integer> sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            sortStack(stack);
            InsertAtBottom(stack, top);
        }
        return stack;
    }
    public static void InsertAtBottom(Stack<Integer> stack, int item) {
        if (stack.isEmpty() || item > stack.peek()) {
            stack.push(item);
        } else {
            int top = stack.pop();
            InsertAtBottom(stack, item);
            stack.push(top);
        }
    }
}