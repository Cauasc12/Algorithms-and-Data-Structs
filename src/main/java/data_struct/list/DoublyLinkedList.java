package data_struct.list;

public class DoublyLinkedList <T extends Comparable<T>>{

    private static class Node<T>{

        private T data;
        private Node<T> next;
        private Node<T> prev;

        //construtor de 3 argumentos
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
    private Node<T> head;
    private Node<T> tail;
    private int size;

    //construtor da lista (vazia)
    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
    }

    //retorna a informação do head
    public T getHeadData(){
        if(isEmpty()) return null;
        return head.data;
    }

    //retorna a informação do tail
    public T getTailData(){
        if(isEmpty()) return null;
        return tail.data;
    }

    public int getSize(){
        return this.size;
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
        size++;
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
        size++;
    }

    //insere no meio da lista - lista ordenada
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
        while(current != null){
            if(current.data.compareTo(newData) >= 0){
                Node<T> newNode = new Node<>(newData, current, current.prev);
                current.prev.next = newNode;
                current.prev = newNode;
                size++;
                return;
            }
            current = current.next;
        }
    }

    //insere após um nó especificado
    public void insertAfterValue(T target, T newData){
        Node<T> node = search(target);
        if(node == null) return;
        if(node == tail){
            insertToBack(newData);
            return;
        }
        Node<T> newNode = new Node<>(newData, node.next, node);
        node.next.prev = newNode;
        node.next = newNode;
        size++;
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

    public boolean deleteFromFront(){
        if(isEmpty()) return false;
        head = head.next;
        if(head != null){
            head.prev = null;
        }
        else{
            tail = null;
        }
        size--;
        return true;
    }

    //remove o elemento desejado
    public boolean delete(T target){
        Node<T> node = search(target);
        if(node == null){
            return false;
        }
        if(node == head){
            return deleteFromFront();
        }
        if(node == tail){
            tail = node.prev;
            tail.next = null;
            size--;
            return true;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
        return true;
    }

    //destroi a lista
    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    //imprime os dados da lista
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