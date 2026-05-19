package data_struct.list;

public class DoublyLinkedList <T extends Comparable<T>>{

    private static class Node<T>{

        private T data;
        private Node<T> next;
        private Node<T> prev;

        //construtor de 2 argumentos
        Node(T data, Node<T> next, Node<T> prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
        //construtor de 1 argumento
        Node(T data){
            this(data, null, null);
        }
    }

    //classe principal

    //atributo
    Node<T> head;
    Node<T> tail;

    //construtor da lista (vazia)
    DoublyLinkedList(){
        this.head = null;
        this.tail = null;
    }

    //testa se a lista é vazia
    public boolean isEmpty(){
        return head == null;
    }

    //insere no início da lista
    public void insertInFront(T newData){
        Node<T> newNode = new Node<>(newData, head, null);
        if(isEmpty()){
            tail = newNode;
        }
        else{
            head.prev = newNode;
        }
        head = newNode;
    }

    //insere no final da lista
    public void insertToBack(T newData){
        if(isEmpty()){
            insertInFront(newData);
            return;
        }
        Node<T> newNode = new Node<>(newData, null, tail);
        tail.next = newNode;
        tail = newNode;
    }

    //insere no meio da lista - lista ordenada
    public void insetSorted(T newData){
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
        while(current != null){
            if(current.data.compareTo(newData) >= 0){
                Node<T> newNode = new Node<>(newData, current, current.prev);
                current.prev.next = newNode;
                current.prev = newNode;
                return;
            }
            current = current.next;
        }
        current.prev.next = new Node<>(newData);
    }

    //insere após um nó especificado
    public void insertAfterNode(Node<T> node, T newData){
        if(node == null) return;
        if(node == tail){
            insertToBack(newData);
            return;
        }
        Node<T> newNode = new Node<>(newData, node.next, node);
        node.next.prev = newNode;
        node.next = newNode;
    }

    //busca o elemento desejado(busca linear) retorna o nó correspondente
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

    public boolean deleteFromFront(T target){
        if(isEmpty()) return false;
        head = head.next;
        if(head != null){
            head.prev = null;
        }
        else{
            tail = null;
        }
        return true;
    }

    //remove o elemento desejado
    public boolean delete(T target){
        Node<T> node = search(target);
        if(node == null){
            return false;
        }
        if(node == head){
            return deleteFromFront(target);
        }
        if(node == tail){
            tail = node.prev;
            tail.next = null;
            return true;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return true;
    }

    //destroi a lista
    public void clear(){
        head = null;
        tail = null;
    }

}