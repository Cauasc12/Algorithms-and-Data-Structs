package data_struct.trees;

public class DynamicBinaryTree<T> {

    private static class Node<E>{

        private E data;
        private Node<E> leftChild;
        private Node<E> rightChild;
        private Node<E> parent;


        public Node(E data){
            this.data = data;
        }

        public Node(E data, Node<E> parent){
            this.data = data;
            this.parent = parent;
        }

        public Node<E> getParent(){
            return this.parent;
        }

        public Node<E> getLeftChild(){
            return this.leftChild;
        }

        public Node<E> getRightChild(){
            return this.rightChild;
        }

    }

    private Node<T> root;
    private int size;

    public DynamicBinaryTree(){
        this.root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public int getSize(){
        return this.size;
    }

    private boolean hasLeftChild(Node<T> node){
        return node.leftChild != null;
    }

    private boolean hasRightChild(Node<T> node){
        return node.rightChild != null;
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

    private Node<T> preOrderSearch(Node<T> currentNode, T target){
        if(currentNode == null){
            return null;
        }
        if(currentNode.data.equals(target)){
            return currentNode;
        }

        Node<T> leftResult = preOrderSearch(currentNode.leftChild, target);
        if(leftResult != null){
            return leftResult;
        }

        Node<T> rightResult = preOrderSearch(currentNode.rightChild, target);
        if(rightResult != null){
            return rightResult;
        }

        return null;
    }

    private Node<T> posOrderSearch(Node<T> currentNode, T target){
        if(currentNode == null){
            return null;
        }
        Node<T> leftResult = posOrderSearch(currentNode.leftChild, target);
        if(leftResult != null){
            return leftResult;
        }
        Node<T> rightResult = posOrderSearch(currentNode.rightChild, target);
        if(rightResult != null){
            return rightResult;
        }
        if(currentNode.data.equals(target)){
            return currentNode;
        }

        return null;
    }

    private Node<T> inOrder(Node<T> currentNode, T target){
        if(currentNode == null){
            return null;
        }
        Node<T> leftResult = inOrder(currentNode.leftChild, target);
        if(leftResult != null){
            return leftResult;
        }
        if(currentNode.data.equals(target)){
            return currentNode;
        }
        Node<T> rightResult = inOrder(currentNode.rightChild, target);
        if(rightResult != null){
            return rightResult;
        }

        return null;
    }

    public void insertRoot(T newData){
        if(isEmpty()){
            root = new Node<>(newData);
            size++;
        }
        else{
            throw new RuntimeException("Árvore já foi criada!!");
        }
    }

    public void insertLeft(T newData, T parentData){
        Node<T> parent = preOrderSearch(root, parentData);
        if(parent == null){
            throw new RuntimeException("Pai não existe!!");
        }

        if(hasLeftChild(parent)){
            throw new RuntimeException("Filho da esquerda já existe!!");
        }
        Node<T> newNode = new Node<>(newData, parent);
        parent.leftChild = newNode;
        size++;
    }

    public void insertRight(T newData, T parentData){
        Node<T> parent = preOrderSearch(root, parentData);
        if(parent == null){
            throw new RuntimeException("Pai não existe!!");
        }

        if(hasRightChild(parent)){
            throw new RuntimeException("Filho da direita já existe!!");
        }
        Node<T> newNode = new Node<>(newData, parent);
        parent.rightChild = newNode;
        size++;
    }

    public T delete(T target){
        if(isEmpty()){
            throw new RuntimeException("Árvore vazia!!");
        }

        Node<T> targetNode = preOrderSearch(root, target);
        if(targetNode == null){
            throw new RuntimeException("Elemento não encontrado na árvore!");
        }

        if(numberOfChildrens(targetNode) == 2){
            throw new RuntimeException("Nó com 2 filhos não pode ser deletado!!");
        }

        if(targetNode == root){
            if(isLeaf(root)){
                root = null;
            }
            else if(hasLeftChild(root)){
                root = root.leftChild;
                root.parent = null;
            }
            else{
                root = root.rightChild;
                root.parent = null;
            }
            size--;
            return target;
        }

        if(isLeaf(targetNode)){
            Node<T> parent = targetNode.getParent();
            if(parent.leftChild == targetNode){
                parent.leftChild = null;
            }
            else if(parent.rightChild == targetNode){
                parent.rightChild = null;
            }
            size--;
        }

        else if(numberOfChildrens(targetNode) == 1){
            Node<T> parent = targetNode.getParent();
            Node<T> childToKeep;

            if(hasLeftChild(targetNode)){
                childToKeep = targetNode.leftChild;
            }
            else{
                childToKeep = targetNode.rightChild;
            }

            if(parent.leftChild == targetNode){
                parent.leftChild = childToKeep;
            }
            else{
                parent.rightChild = childToKeep;
            }

            childToKeep.parent = parent;
            size--;
        }

        return targetNode.data;
    }

}
