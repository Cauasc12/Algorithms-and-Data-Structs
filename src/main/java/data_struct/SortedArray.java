package data_struct;
import java.util.function.Consumer;

//utiliza como exemplo um array de inteiros

//arrays ordenados
public class SortedArray {
    private int[] array;
    private int size;

    public SortedArray(int maxSize){
        this.array = new int[maxSize];
        this.size = 0;
    }

    //inserção de um novo valor
    public void insert(int value){
        if(size >= array.length){
            throw new IllegalStateException("Capacidade máxima do array excedida.");
        }
        for(int i = size; i > 0; i--){
            if(array[i-1] <= value){
                array[i] = value;
                size++;
                return;
            }
            else array[i] = array[i-1];
        }
        array[0] = value;
        size++;
    }

    //deleção pelo valor do elemento
    public boolean deleteByValue(int value){
        int index = binarySearch(value);
        if(index == -1) return false;

        deleteByIndex(index);
        return true;
    }

    //deleção pelo index do elemento
    public void deleteByIndex(int index){
        for(int i = index; i < size-1; i++){
            array[i] = array[i+1];
        }
        size--;
    }

    //busca linear - retorna o indice do elemento
    public int linearSearch(int target){
        for(int i = 0; i < size; i++){
            if(array[i] == target) return i;
            else if(array[i] > target) return -1;
        }
        return -1;
    }

    //busca binaria - retorna o indice do elemento
    public int binarySearch(int target){
        int left = 0;
        int right = size - 1;
        while(left <= right){
            int midIndex = (left + right) / 2;
            if(array[midIndex] == target) return midIndex;
            else if(array[midIndex] > target) {
                right = midIndex - 1;
            }
            else if(array[midIndex] < target){
                left = midIndex + 1;
            }
        }
        return -1;
    }

    //busca binaria para elementos duplicados - retorna o indice do elemento
    public int duplicateBinarySearch(int target){
        int left = 0;
        int right = size - 1;
        int result = -1;

        while(left <= right){
            int midIndex = (left + right) / 2;
            if(array[midIndex] == target){
                result = midIndex;
                right = midIndex -1;
            }
            else if(array[midIndex] > target) {
                right = midIndex - 1;
            }
            else if(array[midIndex] < target){
                left = midIndex + 1;
            }
        }
        return result;

    }

    //varredura do array
    public void traverse(Consumer<Integer> action){
        for(int i = 0; i < size; i++){
            action.accept(array[i]);
        }
    }

}
