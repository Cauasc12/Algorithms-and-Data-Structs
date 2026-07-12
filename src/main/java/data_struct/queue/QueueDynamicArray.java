package data_struct.queue;

import java.util.NoSuchElementException;

public class QueueDynamicArray<T> {

    private Object[] queue;
    private int capacity;
    private int rear;
    private int front;
    private int size;

    public QueueDynamicArray(int capacity){
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

    private void doubleCapacity(){
        int newCapacity = capacity*2;
        Object[] newArray = new Object[newCapacity];

        for(int i = 0; i < size; i++){
            newArray[i] = this.queue[(front + i) % capacity];
        }
        this.queue = newArray;
        this.capacity = newCapacity;
        this.front = 0;
        this.rear = size;
    }

    public void enqueue(T newData){
        if(isFull()){
            doubleCapacity();
        }
        queue[rear] = newData;
        rear = (rear+1) % capacity;
        size++;
    }

    private void halveCapacity(){
        if(capacity > 1 && size < capacity/4){
            int newCapacity = capacity/2;
            Object[] newArray = new Object[newCapacity];

            for(int i = 0; i < size; i++){
                newArray[i] = queue[(front + i) % capacity];
            }

            this.queue = newArray;
            this.capacity = newCapacity;
            front = 0;
            rear = size;
        }
    }

    public T dequeue(){
        if(isEmpty()) {
            throw new NoSuchElementException("Erro: A fila está vazia.");
        }
        T removed = (T) queue[front];
        queue[front] = null;
        front = (front+1) % capacity;
        size--;
        halveCapacity();
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