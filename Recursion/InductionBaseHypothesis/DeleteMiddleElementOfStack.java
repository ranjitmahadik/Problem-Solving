package Recursion.InductionBaseHypothesis;

import java.util.Stack;

public class DeleteMiddleElementOfStack {

    private static int possibleMid = -1, elementCount = 0;

    private static void deleteMiddleElement(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            possibleMid = (elementCount / 2) + 1;
            return;
        }

        int currentElement = stack.pop();
        elementCount++;
        deleteMiddleElement(stack);
        if (possibleMid != elementCount) {
            stack.push(currentElement);
        }
        elementCount--;
    }

    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(1);                    //1
        stk.push(2);                    //2
        stk.push(3);//                  //3*
        stk.push(4);                    //4
        stk.push(5);                    //5

        deleteMiddleElement(stk);

        while (!stk.isEmpty()) {
            System.out.println(stk.pop() + " ");
        }
    }
}
