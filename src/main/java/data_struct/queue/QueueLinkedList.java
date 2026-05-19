package data_struct.queue;
import data_struct.list.SinglyLinkedList;

import java.util.NoSuchElementException;

public class QueueLinkedList<T extends Comparable<T>> {

    private final SinglyLinkedList<T> internalList;

    public QueueLinkedList(){
        internalList = new SinglyLinkedList<>();
    }

    public boolean isEmpty(){
        return internalList.isEmpty();
    }

    public void enqueue(T newData){
        internalList.insertToBack(newData);
    }

    public T dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("Erro: A fila está vazia.");
        }
        T removedData = internalList.getHeadData();
        internalList.deleteFromFront();
        return removedData;
    }

    public T peek(){
        if(isEmpty()){
            throw new NoSuchElementException("Erro: A fila está vazia.");
        }
        return internalList.getHeadData();
    }


}
