package data_struct.list;

public class CircularSinglyLinkedList<T extends Comparable<T>> {

    private static class Node<T>{

        private T data;
        private Node<T> next;

        Node(T data, Node<T> next){
            this.data = data;
            this.next = next;
        }
        Node(T data){
            this(data, null);
        }
    }

    private Node<T> tail;
    private int size;

    public CircularSinglyLinkedList(){
        this.tail = null;
        this.size = 0;
    }

    public T getHeadData(){
        if(isEmpty()) return null;
        return tail.next.data;
    }

    public T getTailData(){
        if(isEmpty()) return null;
        return tail.data;
    }

    public int getSize(){
        return this.size;
    }

    public boolean isEmpty(){
        return tail == null;
    }

    public void insertInFront(T newData){
        Node<T> newNode = new Node<>(newData);
        if(isEmpty()){
            tail = newNode;
            tail.next = tail;
            size++;
            return;
        }
        newNode.next = tail.next;
        tail.next = newNode;
        size++;
    }

    public void insertToBack(T newData){
        if(isEmpty()){
            insertInFront(newData);
            return;
        }
        Node<T> newNode = new Node<>(newData, tail.next);
        tail.next = newNode;
        tail = newNode;
    }

    public void insertSorted(T newData){
        if(isEmpty()){
            insertInFront(newData);
            return;
        }
        if(tail.next.data.compareTo(newData) >= 0){
            insertInFront(newData);
            return;
        }
        if(tail.data.compareTo(newData) <= 0){
            insertToBack(newData);
            return;
        }

        Node<T> current = tail.next;
        Node<T> previous = tail;

        do{
            if(current.data.compareTo(newData) >= 0){
                previous.next = new Node<>(newData, current);
                size++;
                return;
            }
            previous = current;
            current = current.next;
        }while(current != tail.next);
    }

    private Node<T> search(T target){
        if(isEmpty()) return null;
        Node<T> current = tail.next;
        do{
            if(current.data.equals(target)){
                return current;
            }
            current = current.next;
        }while(current != tail.next);
        return null;
    }

    public boolean deleteFromFront(){
        if(isEmpty()) return false;
        if(tail.next == tail){
            tail = null;
            size--;
            return true;
        }
        tail.next = tail.next.next;
        size--;
        return true;
    }

    public boolean delete(T target){
        if(isEmpty()) return false;

        if(tail.next.data.equals(target)){
            return deleteFromFront();
        }

        Node<T> current = tail.next;
        Node<T> previous = tail;
        do{
            if(current.data.equals(target)){
                previous.next = current.next;
                if(current == tail){
                    tail = previous;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }while(current != tail.next);

        return false;
    }

    public void clear(){
        tail = null;
        size = 0;
    }

    public void print(){
        if(isEmpty()){
            System.out.println("Lista vazia.");
            return;
        }
        Node<T> current = tail.next;
        System.out.println("Estrutura da lista:");
        do{
            System.out.println("[" + current.data + "] ->");
            current = current.next;
        }while(current != tail.next);
    }

}
