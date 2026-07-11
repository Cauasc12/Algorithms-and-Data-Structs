package data_struct.stack;

import java.util.EmptyStackException;

public class StackStaticArray<T> {

    private Object[] stack;
    private int top;
    private int capacity;

    public StackStaticArray(int capacity){
        this.capacity = capacity;
        stack = new Object[capacity];
        this.top = -1;
    }
    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == capacity-1;
    }

    public int getSize(){
        return top+1;
    }

    public void push(T newData){
        if(isFull()){
            throw new StackOverflowError("A pilha está cheia! Limite de " + capacity + " elementos atingido.");
        }
        top++;
        stack[top] = newData;
    }

    public T pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        T removed = (T) stack[top];
        stack[top] = null;
        top--;
        return removed;
    }

    public T peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return (T) stack[top];
    }

    public void clear(){
        while(!isEmpty()){
            pop();
        }
        top = -1;
    }
}
