package data_struct.stack;

import data_struct.array.DynamicArray;
import java.util.EmptyStackException;

public class StackDynamicArray<T extends Comparable<T>> {

    private final DynamicArray<T> stack;

    public StackDynamicArray(int capacity){
        this.stack = new DynamicArray<>(capacity);
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public int getSize(){
        return stack.getSize();
    }

    public void push(T newData){
        stack.insert(newData);
    }

    public T pop(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int top = stack.getSize() - 1;
        T removed = stack.get(top);
        stack.deleteByIndexSorted(top);
        return removed;
    }

    public T peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int top = stack.getSize() - 1;
        return stack.get(top);
    }

    public void clear(){
        while(!isEmpty()){
            pop();
        }
    }

}
