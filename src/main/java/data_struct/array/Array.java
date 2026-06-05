package data_struct.array;
import java.util.function.Consumer;

//arrays não ordenados
public class Array<T extends Comparable<T>> {

    //ATRIBUTOS
    private T[] array;
    private int size;

    //CONSTRUTORES
    public Array(int maxSize){
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

    //inserção no final do array
    public void insert(T newData){
        if(size >= array.length){
            throw new IllegalStateException("Capacidade máxima do array excedida.");
        }
        else{
            array[size] = newData;
            size++;
        }
    }

    //deleção através do índice
    public boolean deleteByIndex(int index){
        if(isEmpty()){
            throw new IllegalStateException("Array vazio.");
        }
        else if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Índice fora dos limites do array.");
        }
        else{
            array[index] = array[size-1];
            size--;
            array[size] = null;
            return true;
        }
    }

    //deleção através do valor
    public boolean deleteByValue(T target){
        if(isEmpty()){
            throw new IllegalStateException("Array vazio.");
        }
        int index = find(target);
        if(index == -1){
            return false;
        }

        return deleteByIndex(index);
    }

    //busca por valor específico (busca linear)
    public int find(T target){
        for(int i = 0; i < size; i++){
            if(array[i].equals(target)){
                return i;
            }
        }
        return -1;
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
        T max = array[0];
        for(int i = 1; i < size; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }

    //menor valor do array
    public T minInArray(){
        if(isEmpty()){
            throw new IllegalStateException("Array vazio.");
        }
        T min = array[0];
        for (int i = 1; i< size; i++){
            if (array[i].compareTo(min) < 0){
                min = array[i];
            }
        }
        return min;
    }

}
