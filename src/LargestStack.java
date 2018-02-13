import java.util.Stack;

/**
 * Created by ashi on 9/1/17.
 */
public class LargestStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> maxStack = new Stack<Integer>();

    public void push(int item){
        int currentMax = Integer.MIN_VALUE;

        if(!maxStack.isEmpty()) {
            currentMax = maxStack.peek();
        }

        if(maxStack.isEmpty()||item>currentMax){
            maxStack.push(item);
        } else {
            maxStack.push(currentMax);
        }

        stack.push(item);
    }

    public int pop(){
        maxStack.pop();
        return stack.pop();
    }

    public int getMax(){
        return maxStack.peek();
    }

    public static void main(String[] args) {
        LargestStack largestStack = new LargestStack();
        largestStack.push(0);
        largestStack.push(1);
        largestStack.push(2);
        largestStack.push(-1);
        largestStack.pop();

        System.out.println("largest is "+largestStack.getMax());
        largestStack.push(2);
        largestStack.push(3);
        System.out.println("largest is "+largestStack.getMax());
        largestStack.pop();
        System.out.println("largest is "+largestStack.getMax());
    }
}
