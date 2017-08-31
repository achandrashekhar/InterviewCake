import java.util.Arrays;

/**
 * Created by ashi on 8/25/17.
 * This is a basic min heap with insert and delete operations
 */
public class MinIntHeap {
    private int capacity = 20;
    private int size = 0 ;
    int[] items = new int[capacity];

    //helper methods
    private int getLeftChildIndex(int parentIndex){return parentIndex*2+1;}
    private int getRightChildIndex(int parentIndex){return parentIndex*2+2;}
    private int getParentIndex(int childIndex){return (childIndex-1)/2;}

    private boolean hasLeftChild(int parentIndex){return getLeftChildIndex(parentIndex)<size;}
    private boolean hasRightchild(int parentIndex){return getRightChildIndex(parentIndex)<size;}
    private boolean hasParent(int childIndex){return getParentIndex(childIndex)>=0;}

    private int leftChild(int index){return items[getLeftChildIndex(index)];}
    private int rightChild(int index){return items[getRightChildIndex(index)];}
    private int parent(int index){return items[getParentIndex(index)];}

    private void swap(int indexOne,int indexTwo){
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void ensureExtraCapacity(){
        if(size==capacity){
            Arrays.copyOf(items,capacity*2);
        }
    }

    public int peek () {
        if(size==0) throw new IllegalStateException();
        return items[0];
    }

    public int poll(){
        if(size==0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return item;
    }

    private void heapifyDown(){
        int index = 0;
        while(hasLeftChild(index)){
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasRightchild(index) && rightChild(index)<leftChild(index)){
                smallerChildIndex = getRightChildIndex(index);
            }

            if(items[index]<items[smallerChildIndex]){
                break;
            } else {
                swap(index,smallerChildIndex);
            } index = smallerChildIndex;
        }
    }

    public void add(int item){
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp(){
        int index = size - 1;
        while(hasParent(index) && parent(index) > items[index]){
            swap(getParentIndex(index),index);
            index = getParentIndex(index);
        }
    }

    public void printHeap(){
        System.out.println("Your heap is");
        for(int i = 0;i<size;i++){
            System.out.println(items[i]);
        }
    }

    public static void main(String[] args) {
        MinIntHeap heap = new MinIntHeap();
        heap.add(5);
        heap.add(2);
        heap.add(3);
        heap.add(1);
        heap.add(6);
        heap.printHeap();
        heap.poll();
        heap.poll();
        heap.printHeap();
        heap.add(2);
        heap.printHeap();
    }
}
