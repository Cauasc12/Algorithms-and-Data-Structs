package data_struct.list;

public class SinglyLinkedList<T extends Comparable<T>> {

    private static class Node<T>{

        private T data;
        private Node<T> next;

        Node(T data, Node<T> nextNode){
            this.data = data;
            this.next = nextNode;
        }
        Node(T data){
            this(data,null);
        }
    }


    private Node<T> head;
    private Node<T> tail;
    private int size;

    public SinglyLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public T getHeadData(){
        if(isEmpty()) return null;
        return head.data;
    }

    public T getTailData(){
        if(isEmpty()) return null;
        return tail.data;
    }

    public int getSize(){
        return this.size;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void insertInFront(T newData){
       head = new Node<>(newData, head);
       if(tail == null){
           tail = head;
       }
       size++;
    }

    public void insertToBack(T newData){
        if(isEmpty()) {
            insertInFront(newData);
            return;
        }
        Node<T> newNode = new Node<>(newData, null);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void insertSorted(T newData){
        if(isEmpty()){
            insertInFront(newData);
            return;
        }
        if(head.data.compareTo(newData) >= 0){
            insertInFront(newData);
            return;
        }
        if(tail.data.compareTo(newData) <= 0){
            insertToBack(newData);
            return;
        }

        Node<T> current = head;
        Node<T> previous = null;
        while(current != null){
            if(current.data.compareTo(newData) >= 0){
                previous.next = new Node<>(newData, current);
                size++;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    private Node<T> search(T target){
        Node<T> current = head;
        while(current != null){
            if(current.data.equals(target)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public boolean deleteFromFront(){
        if(isEmpty()) return false;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return true;
    }

    public boolean delete(T target){
        if(isEmpty()) return false;

        if(head.data.equals(target)){
            return deleteFromFront();
        }

        Node<T> current = head;
        Node<T> previous = null;

        while(current != null) {
            if (current.data.equals(target)) {
                previous.next = current.next;
                if (current == tail) {
                    tail = previous;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    public void print(){
        if(isEmpty()){
            System.out.println("Lista vazia!");
            return;
        }
        Node<T> current = head;
        System.out.println("Estrutura da lista:");
        while(current != null){
            System.out.println("[" + current.data + "] ->");
            current = current.next;
        }
        System.out.println("null");
    }

}
