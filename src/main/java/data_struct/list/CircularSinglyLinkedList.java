package data_struct.list;

public class CircularSinglyLinkedList<T extends Comparable<T>> {

    //classe interna referente ao nó
    private static class Node<T>{

        //atributos
        private T data;
        private Node<T> next;

        //construtor com 2 argumentos
        Node(T data, Node<T> next){
            this.data = data;
            this.next = next;
        }
        //construtor com 1 argumento
        Node(T data){
            this(data, null);
        }
    }

    //classe principal

    //atributos
    private Node<T> tail;
    private int size;

    //construtor - cria lista vazia
    public CircularSinglyLinkedList(){
        this.tail = null;
        this.size = 0;
    }

    //retorna a informação do head
    public T getHeadData(){
        if(isEmpty()) return null;
        return tail.next.data;
    }

    //retorna a informação do tail
    public T getTailData(){
        if(isEmpty()) return null;
        return tail.data;
    }

    public int getSize(){
        return this.size;
    }

    //teste se a lista está vaiz
    public boolean isEmpty(){
        return tail == null;
    }

    //insere na frente
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

    //insere no final
    public void insertToBack(T newData){
        if(isEmpty()){
            insertInFront(newData);
            return;
        }
        Node<T> newNode = new Node<>(newData, tail.next);
        tail.next = newNode;
        tail = newNode;
    }

    //insere no meio - lista ordenada
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

    //busca o elemento desejado(busca linear) retorna o nó correspondente
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

    //remove do início
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

    //remove o elemento desejado
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
