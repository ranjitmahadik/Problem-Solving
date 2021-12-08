package Recursion.InductionBaseHypothesis;

import java.util.Stack;

public class sortStack {

    private static void sort(Stack<Integer> stack) {
        if (stack.size() <= 1) return;

        int elementToBeInsertedAtCorrectPosition = stack.pop();
        sort(stack); // 3 2

        insertElementAtCorrectPosition(stack, elementToBeInsertedAtCorrectPosition);
    }

    // 3 2 1 5
    private static void insertElementAtCorrectPosition(Stack<Integer> stack, int elementToBeInsertedAtCorrectPosition) {
        if (stack.size() == 0 || stack.peek() < elementToBeInsertedAtCorrectPosition) {
            stack.push(elementToBeInsertedAtCorrectPosition);
            return;
        }

        int currentElement = stack.pop();
        insertElementAtCorrectPosition(stack, elementToBeInsertedAtCorrectPosition);

        stack.push(currentElement);
    }

    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(3);
        stk.push(2);
        stk.push(1);
        stk.push(5);
        sort(stk);

        while (!stk.isEmpty()) {
            System.out.print(stk.pop() + " ");
        }
    }
}
