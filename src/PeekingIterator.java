import java.util.*;
import java.util.LinkedList;

/**
 * Created by ashi on 9/2/17.
 * Create a PeekingIterator.
    Iterator should have 3 methods.
    T next()
    boolean hasNext()
    T peek()
 */
public class PeekingIterator {
    int maxCapacity = 10;
    int pointer = 0;
    int size = 0;
    int[] iterator = new int[maxCapacity];

    public void ensureCapacity(){
        if (size==maxCapacity){
            int[] newiterator = new int[maxCapacity*2];
            for (int i = 0; i < size ; i++) {
                newiterator[i] = iterator[i];
            }
            iterator = newiterator;
        }
    }

    public void add(int item){
        iterator[size] = item;
        size++;
    }

    public boolean hasNext(){
        if (pointer!=size){
            return true;
        } return false;
    }

    public int next(){
        return iterator[pointer++];
    }
    public int peek(){
        return iterator[size-1]; //size-1 becuase size is pointing to the location where the next number is to be added!

    }

    public static void main(String[] args) {
        PeekingIterator peekingIterator =  new PeekingIterator();
        peekingIterator.add(5);
        peekingIterator.add(6);
        peekingIterator.add(7);
        System.out.println(peekingIterator.peek());
        while (peekingIterator.hasNext()){
            System.out.println(peekingIterator.next());
        }
    }


}
