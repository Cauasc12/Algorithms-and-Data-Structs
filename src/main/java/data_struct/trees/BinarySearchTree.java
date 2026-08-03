package data_struct.trees;

public class BinarySearchTree<T extends Comparable<T>> {

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

    public BinarySearchTree(){
        this.root = null;
    }

    public boolean isEmpty(){
        return root == null;
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


    private Node<T> search(T target){
        Node<T> node = root;
        while(node != null){
            T nodeData = node.data;
            if(nodeData.equals(target)){
                return node;
            }
            else if(target.compareTo(nodeData) < 0){
                node = node.leftChild;
            }
            else{
                node = node.rightChild;
            }
        }
        return null;
    }

    public void insert(T newData){
        Node<T> node = root;
        if(node == null){
            root = new Node<>(newData);
            return;
        }
        while(node != null){
            T nodeData = node.data;
            if(newData.compareTo(nodeData) <= 0){
                if(!hasLeftChild(node)){
                    node.leftChild = new Node<>(newData, node);
                    return;
                }
                node = node.leftChild;
            }
            else if(!hasRightChild(node)){
                node.rightChild = new Node<>(newData, node);
                return;
            }
            else{
                node = node.rightChild;
            }
        }
    }

    public void noDuplicatedInsert(T newData){
        Node<T> node = root;
        if(node == null){
            root = new Node<>(newData);
            return;
        }
        while(node != null){
            T nodeData = node.data;
            if(newData.equals(nodeData)){
                throw new RuntimeException("Inserção Proibida! Valor já existe na árvore!!");
            }
            if(newData.compareTo(nodeData) < 0){
                if(!hasLeftChild(node)){
                    node.leftChild = new Node<>(newData, node);
                    return;
                }
                node = node.leftChild;
            }
            else if(!hasRightChild(node)){
                node.rightChild = new Node<>(newData, node);
                return;
            }
            else{
                node = node.rightChild;
            }
        }
    }

    public T delete(T target){
        if(isEmpty()){
            throw new RuntimeException("Árvore vazia!!");
        }

        Node<T> targetNode = search(target);
        if(targetNode == null){
            throw new RuntimeException("Elemento não encontrado na árvore!");
        }
        if(numberOfChildrens(targetNode) == 2){
            Node<T> maxNode = targetNode.leftChild;
            while(hasRightChild(maxNode)){
                maxNode = maxNode.rightChild;
            }

            targetNode.data = maxNode.data;
            targetNode = maxNode;
        }

        Node<T> parent = targetNode.getParent();

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
            return target;
        }

        if(isLeaf(targetNode)){
            if(parent.leftChild == targetNode){
                parent.leftChild = null;
            }
            else if(parent.rightChild == targetNode){
                parent.rightChild = null;
            }
        }

        else if(numberOfChildrens(targetNode) == 1){
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
        }

        return target;
    }

    public T getMaxValue(){
        Node<T> node = root;
        if(isEmpty()){
            throw new RuntimeException("A árvore está vazia!");
        }
        while(hasRightChild(node)){
            node = node.rightChild;
        }

        return node.data;
    }

    public T getMinValue(){
        Node<T> node = root;
        if(isEmpty()){
            throw new RuntimeException("A árvore está vazia!");
        }
        while(hasLeftChild(node)){
            node = node.leftChild;
        }

        return node.data;
    }

}
