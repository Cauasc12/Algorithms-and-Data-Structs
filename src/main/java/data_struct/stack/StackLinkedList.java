package data_struct.stack;
import data_struct.list.SinglyLinkedList;

import java.util.EmptyStackException;

//faz composição com a classe SinglyLinkedList
public class StackLinkedList<T extends Comparable<T>> {

    private final SinglyLinkedList<T> internalList;

    //construtor que instacia a lista encadeada
    public StackLinkedList(){
        this.internalList = new SinglyLinkedList<>();
    }

    //testa se é vazia
    public boolean isEmpty(){
        return internalList.isEmpty();
    }

    //insere elemento no início da lista
    public void push(T newData){
        internalList.insertInFront(newData);
    }

    //remove elemento do início da lista
    public T pop(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        T removedData = (T) internalList.getHeadData();
        internalList.deleteFromFront();
        return removedData;
    }

    public T peek(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return internalList.getHeadData();
    }

    //destrói a lista
    public void clear(){
        internalList.clear();
    }

}
