package data_struct;

//lista simplesmente encadeada
public class SinglyLinkedList<T extends Comparable<T>> {

    //classe interna referênte aos nós
    private static class Node<T>{

        private T data;
        private Node<T> next;

        //construtor com 2 argumentos
        Node(T data, Node<T> nextNode){
            this.data = data;
            this.next = nextNode;
        }
        //construtor com 1 argumento
        Node(T data){
            this(data,null);
        }

        //testa se tem um próximo nó
        boolean hasNext(){
            if(this.next != null) return true;
            else return false;
        }
    }

    //classe principal

    //atributo
    private Node<T> head;

    //construtor da lista(vazia)
    public SinglyLinkedList(){
        this.head = null;
    }

    public T getHeadData(){
        if(isEmpty()) return null;
        return head.data;
    }

    //testa se a lista está vazia
    public boolean isEmpty(){
        return head == null;
    }

    //insere no início da lista
    public void insertInFront(T data){
       head = new Node<>(data, head);
    }

    //insere no final da lista
    public void insertToBack(T data){
        if(isEmpty()) {
            insertInFront(data);
            return;
        }
        Node<T> current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = new Node<>(data);
    }

    //insere no meio - lista ordenada
    public void insertSorted(T newData){
        if(isEmpty()){
            head = new Node<>(newData);
            return;
        }
        if(head.data.compareTo(newData) > 0){
            insertInFront(newData);
            return;
        }

        Node<T> current = head;
        Node<T> previous = null;
        while(current != null){
            if(current.data.compareTo(newData) > 0){
                previous.next = new Node<>(newData, current);
                return;
            }
            previous = current;
            current = current.next;
        }
        previous.next = new Node<>(newData);

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

    //deleta da frente(head)
    public boolean deleteFromFront(){
        if(isEmpty()) return false;
        head = head.next;
        return true;
    }

    //remove o elemento desejado
    public boolean delete(T target){
        if(isEmpty()) return false;

        if(head.data.equals(target)){
            return deleteFromFront();
        }

        Node<T> current = head;
        Node<T> previous = null;

        while(current != null){
            if(current.data.equals(target)){
                previous.next = current.next;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    //destroi a lista
    public void clear(){
        head = null;
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
