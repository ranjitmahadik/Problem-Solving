package Recursion.InductionBaseHypothesis;

import java.util.Stack;

public class ReverseStack {

    /**
     * 5
     * 4
     * 3
     * 2
     * 1
     */

    private static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty() || stack.size() == 1) return;
        int currentElement = stack.pop();
        reverseStack(stack);

        insertCurrentElementAtLast(stack, currentElement);
    }

    private static void insertCurrentElementAtLast(Stack<Integer> stack, int currentElement) {
        if (stack.isEmpty()) {
            stack.push(currentElement);
            return;
        }

        int element = stack.pop();

        insertCurrentElementAtLast(stack, currentElement);
        stack.push(element);

    }

    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(3);
        stk.push(2);
        stk.push(1);
        stk.push(5);
        //5 1 2 3
//        while (!stk.isEmpty()) {
//            System.out.print(stk.pop() + " ");
//        }

        reverseStack(stk);
        //3 2 1 5
        while (!stk.isEmpty()) {
            System.out.print(stk.pop() + " ");
        }

    }
}
