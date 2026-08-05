package algorithm;

//utilizou-se arrays de inteiro para fins de exemplo

//algorítmos de ordenação/classificação não recursivos
public class IterativeSorting {

    //bolha por seleção
    public static void exchangeSort(int[] array){
        int temp;
        for(int i = 0; i < array.length-1; i++){
            for(int j = i+1; j < array.length; j++){
                if(array[i] > array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    //bolha por troca
    public static void bubbleSort(int[] array){
        int temp;
        int size = array.length;
        boolean change;
        do{
            change = false;
            for(int i = 0; i < size-1; i++){
                if(array[i] > array[i+1]){
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
    public static void selectionSort(int[] array){
        int menorIndex, temp;
        for(int i = 0; i < array.length-1; i++){
            menorIndex = i;
            for(int j = i+1; j < array.length; j++){
                if(array[j] < array[menorIndex]){
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
    public static void insertionSort(int[] array){
        int temp;
        for(int i = 1; i < array.length; i++){
            int j = i;
            temp = array[i];
            while(j > 0 && temp < array[j-1]){
                array[j] = array[j-1];
                j--;
            }
            array[j] = temp;
        }
    }
}
