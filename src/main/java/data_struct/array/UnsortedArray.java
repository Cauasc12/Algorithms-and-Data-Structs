package data_struct.array;
import java.util.function.Consumer;

//utiliza como exemplo um array de inteiros

//arrays não ordenados
public class UnsortedArray {
    private int[] array;
    private int size;

    public UnsortedArray(int maxSize){
        this.array = new int[maxSize];
        this.size = 0;
    }

    //inserção no final do array
    public void insert(int value){
        if(size >= array.length){
            throw new IllegalStateException("Capacidade máxima do array excedida.");
        }
        else{
            array[size] = value;
            size++;
        }
    }

    //deleção através do índice
    public void deleteByIndex(int index){
        if(size == 0){
            throw new IllegalStateException("Array vazio.");
        }
        else if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Índice fora dos limites do array.");
        }
        else{
            array[index] = array[size-1];
            size--;
        }
    }

    //deleção através do valor
    public boolean deleteByValue(int target){
        int index = find(target);
        if(index == -1) return false;

        deleteByIndex(index);
        return true;
    }

    //busca por valor específico (busca linear)
    public int find(int target){
        for(int i = 0; i < size; i++){
            if(array[i] == target){
                return i;
            }
        }
        return -1;
    }

    //varredura do array
    public void traverse(Consumer<Integer> action){
        for(int i = 0; i < size; i++){
            action.accept(array[i]);
        }
    }

    //maior valor do array
    public int maxInArray(){
        if(size == 0){
            throw new IllegalStateException("Array vazio.");
        }
        int max = array[0];
        for(int i = 1; i < size; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    //menor valor do array
    public int minInArray(){
        if(size == 0){
            throw new IllegalStateException("Array vazio.");
        }
        int min = array[0];
        for (int i = 1; i< size; i++){
            if (array[i] < min){
                min = array[i];
            }
        }
        return min;
    }
}
