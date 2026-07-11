package data_struct.queue;

import data_struct.array.DynamicArray;

public class QueueDynamicArray<T extends Comparable<T>> {

    private final DynamicArray queue;
    private int capacity;
    private int rear;
    private int front;
    private int size;

    public QueueDynamicArray(int capacity){
        queue = new DynamicArray(capacity);
        this.capacity = capacity;
        this.rear = 0;
        this.front = 0;
        this.size = 0;
    }

    public boolean isEmpty(){
        return queue.getSize() == capacity;
    }

    public boolean isFull() {
        return queue.getSize() == capacity;
    }

    public int getSize(){
        return size;
    }

    public void enqueu(T newData){
        if(isFull()){
        }
    }

}
