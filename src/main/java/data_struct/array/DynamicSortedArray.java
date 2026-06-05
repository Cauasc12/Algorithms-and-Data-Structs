package data_struct.array;

import java.util.function.Consumer;

//arrays dinamicos(mantém ordem crescente)
public class DynamicSortedArray<T extends Comparable<T>> {

    //ATRIBUTOS
    private T[] array;
    private int size;
    private int capacity;

    //CONSTRUTORES
    //construtor com a capacidade inicial informada
    public DynamicSortedArray(int initialCapacity){
        this.array = (T[]) new Comparable[initialCapacity];
        this.capacity = initialCapacity;
        this.size = 0;
    }
    //construtor sem a capacidade inicial informada(padrão = 1)
    public DynamicSortedArray(){
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

    //iserção mantendo ordem crescente
    public void insert(T newData){
        if(size >= capacity){
            doubleCapacity();
        }

        int i = size-1;
        while(i >= 0 && array[i].compareTo(newData) > 0){
            array[i+1] = array[i];
            i--;
        }

        array[i+1] = newData;
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

    //busca por valor específico (busca binária)
    public int find(T target){
       int left = 0;
       int right = size-1;

       while(left <= right){
           int midIndex = (left + right) / 2;

           if(array[midIndex].equals(target)){
               return midIndex;
           }
           else if(array[midIndex].compareTo(target) > 0){
               right = midIndex - 1;
           }
           else if(array[midIndex].compareTo(target) < 0){
                left = midIndex + 1;
           }
        }
       return -1;
    }

    //deleção pelo indice
    public boolean deleteByIndex(int index){
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

    //deleção pelo valor
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
