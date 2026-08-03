package data_struct.priority_queue;

import data_struct.array.DynamicArray;
import java.util.List;
import java.util.Map;

public class MaxHeap<T> {

    private static class Node<E> implements Comparable<Node<E>>{
        E element;
        int priority;

        public Node(E element, int priority){
            this.element = element;
            this.priority = priority;
        }

        @Override
        public int compareTo(Node<E> otherNode){
            return Integer.compare(this.priority, otherNode.priority);
        }
    }

    private final DynamicArray<Node<T>> array;

    public MaxHeap(){
        this.array = new DynamicArray<>();
    }

    public MaxHeap(Map<T, Integer> elementosComPrioridade) {
        this.array = new DynamicArray<>();

        for (Map.Entry<T, Integer> entrada : elementosComPrioridade.entrySet()) {
            array.insert(new Node<>(entrada.getKey(), entrada.getValue()));
        }
        if (array.getSize() > 0) {
            this.heapify();
        }
    }

    private void heapify() {
        int lastInnerNodeIndex = firstLeafIndex() - 1;
        for(int i = lastInnerNodeIndex; i >= 0; i--) {
            heapfyDown(i);
        }
    }

    private int firstLeafIndex(){
        return array.getSize() / 2;
    }

    private boolean hasLowerPriority(Node<T> element1, Node<T> element2){
        return  element1.compareTo(element2) < 0;
    }

    private boolean hasHigherPriority(Node<T> element1, Node<T> element2){
        return element1.compareTo(element2) > 0;
    }

    private int getLeftChildIndex(int index){
        return index* 2 + 1;
    }

    private int getRightChildIndex(int index){
        return index* 2 + 2;
    }

    private int getParent(int index){
        return (index - 1) / 2;
    }

    public void insert(T element, int priority){
        Node<T> newNode = new Node<>(element, priority);
        array.insert(newNode);
        heapfyUp(array.getSize() - 1);
    }

    private void heapfyUp(int index){
        Node<T> node = array.get(index);

        while(index > 0){
            int parentIndex = getParent(index);
            Node<T> parent = array.get(parentIndex);
            if(hasHigherPriority(node, parent)){
                array.set(parent, index);
                index = parentIndex;
            }
            else{
                break;
            }
        }
        array.set(node, index);
    }

    public T top(){
        Node<T> removed;
        if(array.isEmpty()){
            throw new IllegalStateException("Heap vazio.");
        }
        if(array.getSize() == 1){
            removed = array.delete();
        }
        else{
            removed = array.deleteByIndexUnsorted(0);
            heapfyDown(0);
        }
        return removed.element;
    }

    private int highestPriorityChildIndex(int index){
        int leftChildIndex = getLeftChildIndex(index);
        if(leftChildIndex >= array.getSize()){
            return -1;
        }
        if(leftChildIndex + 1 >= array.getSize()){
            return leftChildIndex;
        }
        if(hasHigherPriority(array.get(leftChildIndex), array.get(leftChildIndex+1))){
            return leftChildIndex;
        }
        else{
            return leftChildIndex + 1;
        }
    }

    private void heapfyDown(int index){
        Node<T> element = array.get(index);
        int currentIndex = index;
        while (true){
            int childIndex = highestPriorityChildIndex(currentIndex);
            if(childIndex == -1){
                break;
            }
            Node<T> child = array.get(childIndex);
            if(hasLowerPriority(element, child)){
                array.set(child, currentIndex);
                currentIndex = childIndex;
            }
            else{
                break;
            }
        }
        array.set(element, currentIndex);
    }

}
