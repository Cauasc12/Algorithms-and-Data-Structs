package data_struct.array;
import java.util.function.Consumer;

//arrays dinamicos
public class DinamicArray<T extends Comparable<T>> {

    private T[] array;
    private int size;

    private DinamicArray(int maxsize){
        this.array = (T[]) new Comparable[maxsize];
        this.size = 0;
    }


}
