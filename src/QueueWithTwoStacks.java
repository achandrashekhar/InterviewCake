import java.util.Stack;

/**
 * Created by ashi on 8/30/17.
 */
public class QueueWithTwoStacks<E> {
    Stack<E> stack1 = new Stack<E>();
    Stack<E> stack2 = new Stack<E>();

    public void enqueue(E item){
        stack1.push(item);
    }

    public E dequeue() {
        E item;
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        item = stack2.pop();
        return item;
    }

    public static void main(String[] args) {
        QueueWithTwoStacks queueWithTwoStacks = new QueueWithTwoStacks();
        queueWithTwoStacks.enqueue(1);
        queueWithTwoStacks.enqueue(2);
        queueWithTwoStacks.enqueue(3);
        System.out.println(queueWithTwoStacks.dequeue());
        System.out.println(queueWithTwoStacks.dequeue());
        System.out.println(queueWithTwoStacks.dequeue());
    }
}
