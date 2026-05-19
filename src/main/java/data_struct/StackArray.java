package data_struct;
import java.util.EmptyStackException;

public class StackArray<T> {

    private Object[] stackArray;
    private int top;
    private int capacity;

    public StackArray(int capacity){
        this.capacity = capacity;
        stackArray = new Object[capacity];
        this.top = -1;
    }
    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == capacity-1;
    }

    public int size(){
        return top+1;
    }

    public void push(T newData){
        if(isFull()){
            throw new StackOverflowError("A pilha está cheia! Limite de " + capacity + " elementos atingido.");
        }
        stackArray[++top] = newData;
    }

    public T pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        T removedData = (T) stackArray[top];
        stackArray[top--] = null;
        return removedData;
    }

    public T peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return (T) stackArray[top];
    }

    public void clear(){
        for(int i = 0; i <= top; i++){
            stackArray[i] = null;
        }
        top = -1;
    }
}
