package data_struct.stack;
import data_struct.list.SinglyLinkedList;

import java.util.EmptyStackException;

public class StackLinkedList<T extends Comparable<T>> {

    private final SinglyLinkedList<T> stack;

    public StackLinkedList(){
        this.stack = new SinglyLinkedList<>();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public int getSize(){
        return stack.getSize();
    }

    public void push(T newData){
        stack.insertInFront(newData);
    }

    public T pop(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        T removed = stack.getHeadData();
        stack.deleteFromFront();
        return removed;
    }

    public T peek(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.getHeadData();
    }

    public void clear(){
        stack.clear();
    }

}
