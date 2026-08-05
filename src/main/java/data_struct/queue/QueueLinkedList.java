package data_struct.queue;
import data_struct.list.SinglyLinkedList;

import java.util.NoSuchElementException;

public class QueueLinkedList<T extends Comparable<T>> {

    private final SinglyLinkedList<T> queue;

    public QueueLinkedList(){
        queue = new SinglyLinkedList<>();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public int getSize(){
        return queue.getSize();
    }

    public void enqueue(T newData){
        queue.insertToBack(newData);
    }

    public T dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("Erro: A fila está vazia.");
        }
        T removedData = queue.getHeadData();
        queue.deleteFromFront();
        return removedData;
    }

    public T peek(){
        if(isEmpty()){
            throw new NoSuchElementException("Erro: A fila está vazia.");
        }
        return queue.getHeadData();
    }

    public void clear(){
        queue.clear();
    }

}
