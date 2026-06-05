package data_struct.array;
import java.util.function.Consumer;

//arrays dinamicos(mantém a ordem de inserção)
public class DynamicArray<T extends Comparable<T>> {

    //ATRIBUTOS
    private T[] array;
    private int size;
    private int capacity;

    //CONSTRUTORES
    //construtor com a capacidade inicial informada
    public DynamicArray(int initialCapacity){
        this.array = (T[]) new Comparable[initialCapacity];
        this.capacity = initialCapacity;
        this.size = 0;
    }
    //construtor sem a capacidade inicial informada(padrão = 1)
    public DynamicArray(){
        this.array = (T[]) new Comparable[1];
        this.capacity = 1;
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

    public int getCapacity(){
        return this.capacity;
    }

    //MÉTODOS
    public boolean isEmpty(){
        return this.size == 0;
    }

    //dobra a capacidade do array
    private void doubleCapacity(){
        int newCapacity = capacity*2;
        T[] newArray = (T[]) new Comparable[newCapacity];

        for(int i = 0; i < size; i++){
            newArray[i] = this.array[i];
        }
        this.array = newArray;
        this.capacity = newCapacity;
    }

    //inserção
    public void insert(T newData){
        if(size >= capacity){
            doubleCapacity();
        }
        array[size] = newData;
        size++;
    }

    //reduz a capacidade do array na metade
    private void halveCapacity(){
        if(capacity > 1 && size < capacity/4){
            int newCapacity = capacity/2;
            T[] newArray = (T[]) new Comparable[newCapacity];

            for(int i = 0; i < size; i++){
                newArray[i] = array[i];
            }

            this.array = newArray;
            this.capacity = newCapacity;
        }
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

    //deleção pelo valor preservando a ordem da inserção
    public boolean deleteByValue(T target){
        if(isEmpty()){
            throw new IllegalStateException("Array vazio.");
        }
        int index = find(target);
        if(index == -1){
            return false;
        }
        return deleteByIndexSorted(index);
    }

    //deleção pelo indice preservando a ordem da inserção
    public boolean deleteByIndexSorted(int index){
        if(isEmpty()){
            throw new IllegalStateException("Array vazio.");
        }
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Índice fora dos limites do array.");
        }

        for(int i = index; i < size-1; i++){
            array[i] = array[i+1];
        }

        size--;
        array[size] = null;
        halveCapacity();
        return true;
    }

    //deleção pelo indice sem preservar a ordem da inserção
    public boolean deleteByIndexUnsorted(int index){
        if(isEmpty()){
            throw new IllegalStateException("Array vazio.");
        }
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Índice fora dos limites do array.");
        }
        array[index] = array[size-1];
        size--;
        array[size] = null;
        halveCapacity();
        return true;
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
