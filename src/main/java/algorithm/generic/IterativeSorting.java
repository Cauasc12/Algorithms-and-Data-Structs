package algorithm.generic;

//algorítmos de ordenação/classificação não recursivos
public class IterativeSorting<T extends Comparable<T>> {

    //bolha por seleção
    public static <T extends Comparable<T>> void exchangeSort(T[] array){
        T temp;
        for(int i = 0; i < array.length-1; i++){
            for(int j = i+1; j < array.length; j++){
                if(array[i].compareTo(array[j]) > 0){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    //bolha por troca
    public static <T extends Comparable<T>> void bubbleSort(T[] array){
        T temp;
        int size = array.length;
        boolean change;
        do{
            change = false;
            for(int i = 0; i < size-1; i++){
                if(array[i].compareTo(array[i+1]) > 0){
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    change = true;
                }
            }
            size--;
        }while(change && size > 1);
    }

    //seleção direta
    public static <T extends Comparable<T>> void selectionSort(T[] array){
        int menorIndex;
        T temp;
        for(int i = 0; i < array.length-1; i++){
            menorIndex = i;
            for(int j = i+1; j < array.length; j++){
                if(array[j].compareTo(array[menorIndex]) < 0){
                    menorIndex = j;
                }
            }
            if(i != menorIndex){
                temp = array[i];
                array[i] = array[menorIndex];
                array[menorIndex] = temp;
            }
        }
    }

    //inserção direta
    public static <T extends Comparable<T>> void insertionSort(T[] array){
        T temp;
        for(int i = 1; i < array.length; i++){
            int j = i;
            temp = array[i];
            while(j > 0 && temp.compareTo(array[j-1]) < 0){
                array[j] = array[j-1];
                j--;
            }
            array[j] = temp;
        }
    }
}
