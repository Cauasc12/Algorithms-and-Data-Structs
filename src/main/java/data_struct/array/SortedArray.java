package data_struct.array;
import java.util.function.Consumer;

//arrays ordenados
public class SortedArray<T extends Comparable<T>> {

    //ATRIBUTOS
    private T[] array;
    private int size;

    //CONSTRUTORES
    public SortedArray(int maxSize){
        this.array = (T[]) new Comparable[maxSize];
        this.size = 0;
    }

    //GETTERS
    public T get(int index){
        if(isEmpty()){
            throw new IllegalStateException("Array vazio.");
        }
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Índice fora dos limites do array.");
        }
        return array[index];
    }

    public int getSize(){
        return this.size;
    }

    //MÉTODOS
    public boolean isEmpty(){
        return this.size == 0;
    }

    //inserção de um novo valor
    public void insert(T newData){
        if(size >= array.length){
            throw new IllegalStateException("Capacidade máxima do array excedida.");
        }

        int i = size-1;
        while(i <= 0 && array[i].compareTo(newData) > 0){
            array[i+1] = array[i];
            i--;
        }
        array[i+1] = newData;
        size++;
    }

    //deleção pelo valor do elemento
    public boolean deleteByValue(T target){
        if(isEmpty()){
            throw new IllegalStateException("Array vazio.");
        }
        int index = binarySearch(target);
        if(index == -1){
            return false;
        }

        return deleteByIndex(index);
    }

    //deleção pelo index do elemento
    public boolean deleteByIndex(int index){
        if(isEmpty()){
            throw new IllegalStateException("Array vazio.");
        }
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fora dos limites do array.");
        }

        for(int i = index; i < size-1; i++){
            array[i] = array[i+1];
        }
        size--;
        array[size] = null;
        return true;
    }

    //busca linear - retorna o indice do elemento
    public int linearSearch(T target){
        for(int i = 0; i < size; i++){
            if(array[i].equals(target)) return i;
            else if(array[i].compareTo(target) > 0) return -1;
        }
        return -1;
    }

    //busca binaria - retorna o indice do elemento
    public int binarySearch(T target){
        int left = 0;
        int right = size - 1;
        while(left <= right){
            int midIndex = (left + right) / 2;
            if(array[midIndex].equals(target)) return midIndex;
            else if(array[midIndex].compareTo(target) > 0) {
                right = midIndex - 1;
            }
            else if(array[midIndex].compareTo(target) < 0){
                left = midIndex + 1;
            }
        }
        return -1;
    }

    //busca binaria para elementos duplicados - retorna o indice do elemento
    public int duplicateBinarySearch(T target){
        int left = 0;
        int right = size - 1;
        int result = -1;

        while(left <= right){
            int midIndex = (left + right) / 2;
            if(array[midIndex].equals(target)){
                result = midIndex;
                right = midIndex - 1;
            }
            else if(array[midIndex].compareTo(target) > 0) {
                right = midIndex - 1;
            }
            else if(array[midIndex].compareTo(target) < 0){
                left = midIndex + 1;
            }
        }
        return result;
    }

    //varredura do array
    public void traverse(Consumer<T> action){
        for(int i = 0; i < size; i++){
            action.accept(array[i]);
        }
    }

    //maior valor do array
    public T maxInArray(){
        if(isEmpty()){
            throw new IllegalStateException("Array vazio.");
        }
        return array[size - 1];
    }

    //menor valor do array
    public T minInArray(){
        if(isEmpty()){
            throw new IllegalStateException("Array vazio.");
        }
        return array[0];
    }

}
