package data_struct.queue;

import java.util.NoSuchElementException;

public class QueueStaticArray<T> {

    private Object[] queue;
    private int capacity;
    private int rear;
    private int front;
    private int size;

    public QueueStaticArray(int capacity){
        queue = new Object[capacity];
        this.capacity = capacity;
        this.rear = 0;
        this.front = 0;
        this.size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public int getSize(){
        return size;
    }

    public void enqueue(T newData){
        if(isFull()){
            throw new IllegalStateException("Fila cheia!");
        }
        queue[rear] = newData;
        rear = (rear+1) % capacity;
        size++;
    }

    public T dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("Erro: A fila está vazia.");

        }
        T removed = (T) queue[front];
        queue[front] = null;
        front = (front+1) % capacity;
        size--;
        return removed;
    }

    public T peek(){
        if(isEmpty()){
            throw new NoSuchElementException("Erro: A fila está vazia.");
        }
        return (T) queue[front];
    }

    public void clear(){
        Object[] newQueue = new Object[capacity];
        this.queue = newQueue;
        rear = 0;
        front = 0;
        size = 0;
    }

}
