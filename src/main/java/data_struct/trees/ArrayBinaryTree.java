package data_struct.trees;

public class ArrayBinaryTree<T> {

    private static class Node<E>{

        private E data;

        public Node(E data){
            this.data = data;
        }

        public void setData(E data){
            this.data = data;
        }
        public E getData(){
            return data;
        }

    }

    Node<T>[] array;
    int capacity;
    int size;

    public ArrayBinaryTree(int capacity){
        this.array = new Node[capacity];
        this.capacity = capacity;
        size = 0;
    }

    public int getSize(){
        return this.size;
    }
    public int getCapacity(){
        return this.capacity;
    }

    public boolean isEmpty(){
        return array[0] == null;
    }

    private boolean hasLeftChild(Node<T> node){
        int index = breadthFirstSearch(node.getData());
        int childIndex = 2*index + 1;
        if(childIndex >= capacity){
            return false;
        }
        return array[childIndex] == null;
    }

    private boolean hasRightChild(Node<T> node){
        int index = breadthFirstSearch(node.getData());
        int childIndex = 2*index + 2;
        if(childIndex >= capacity){
            return false;
        }
        return array[childIndex] == null;
    }

    public boolean isLeaf(Node<T> node){
        return (!hasRightChild(node) && !hasLeftChild(node));
    }

    private int numberOfChildrens(Node<T> node){
        int count = 0;
        if(hasLeftChild(node)){
            count++;
        }
        if(hasRightChild(node)){
            count++;
        }
        return count;
    }

    private int preOrderSearch(int currentIndex, T target){
        if(currentIndex >= capacity || array[currentIndex] == null){
            return -1;
        }
        if(array[currentIndex].getData().equals(target)){
            return currentIndex;
        }

        int leftResult = preOrderSearch(2*currentIndex+1, target);
        if(leftResult != -1){
            return leftResult;
        }

        int rightResult = preOrderSearch(2*currentIndex+2, target);
        if(rightResult != -1){
            return rightResult;
        }

        return -1;
    }

    private int posOrderSearch(int currentIndex, T target){
        if(currentIndex >= capacity || array[currentIndex] == null){
            return -1;
        }

        int leftResult = posOrderSearch(2*currentIndex+1, target);
        if(leftResult != -1){
            return leftResult;
        }

        int rightResult = posOrderSearch(2*currentIndex+2, target);
        if(rightResult != -1){
            return rightResult;
        }

        if(array[currentIndex].getData().equals(target)){
            return currentIndex;
        }

        return -1;
    }

    private int inOrder(int currentIndex, T target){
        if(currentIndex >= capacity || array[currentIndex] == null){
            return -1;
        }

        int leftResult = inOrder(2*currentIndex+1, target);
        if(leftResult != -1){
            return leftResult;
        }

        if(array[currentIndex].getData().equals(target)){
            return currentIndex;
        }

        int rightResult = inOrder(2*currentIndex+2, target);
        if(rightResult != -1){
            return rightResult;
        }


        return -1;

    }

    private int breadthFirstSearch(T target){
        int index = -1;
        for(int i = 0; i < capacity; i++){
            if(array[i] != null && array[i].getData().equals(target)){
                index = i;
                break;
            }
        }
        return index;
    }

    public void insertRoot(T newData){
        if(isEmpty()){
            array[0] = new Node<>(newData);
            size++;
        }
        else{
            throw new RuntimeException("Árvore já foi criada!!");
        }
    }

    private void doubleCapacity(int childIndex){
        int newCapacity;
        if(childIndex + 1 > capacity){
            newCapacity = childIndex*2;
        }
        else{
            newCapacity = capacity*2;
        }
        Node<T>[] newArray = new Node[newCapacity];

        for(int i = 0; i < capacity; i++){
            newArray[i] = this.array[i];
        }
        this.array = newArray;
        this.capacity = newCapacity;
    }

    public void insertLeft(T newData, T parentData){
        int parentIndex = breadthFirstSearch(parentData);
        if(parentIndex == -1){
            throw new RuntimeException("Pai não existe!");
        }
        int childIndex = 2 * parentIndex + 1;
        if(childIndex >= capacity) {
            doubleCapacity(childIndex);
        }
        if(array[childIndex] != null){
            throw new RuntimeException("Filho esquerdo já existe!");
        }
        array[childIndex] = new Node(newData);
        size++;
    }

    public void insertRight(T newData, T parentData){
        int parentIndex = breadthFirstSearch(parentData);
        if(parentIndex == -1){
            throw new RuntimeException("Pai não existe!");
        }
        int childIndex = 2 * parentIndex + 2;
        if(childIndex >= capacity) {
            doubleCapacity(childIndex);
        }
        if(array[childIndex] != null){
            throw new RuntimeException("Filho direitro já existe!");
        }
        array[childIndex] = new Node(newData);
        size++;
    }

    public T delete(T target){
        if(isEmpty()){
            throw new RuntimeException("Árvore vazia!");
        }
        int index = breadthFirstSearch(target);
        if(index == -1){
            throw new RuntimeException("Elemento não encontrado na árvore!");
        }

        if(numberOfChildrens(array[index]) == 2){
            throw new RuntimeException("Nó com 2 filhos não pode ser deletado!!");
        }

        if(isLeaf(array[index])){
            array[index] = null;
            size--;
        }

        if(numberOfChildrens(array[index]) == 1){
            if(hasLeftChild(array[index])){

            }
        }

        return target;
    }

}
