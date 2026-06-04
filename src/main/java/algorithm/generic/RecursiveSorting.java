package algorithm.generic;

//algorítmos de ordenação/classificação  recursivos
public class RecursiveSorting<T extends Comparable<T>> {

    //quicksort
    public static <T extends Comparable<T>> void quickSort(T[] array){
        quickSort(array, 0, array.length-1);
    }

    private static <T extends Comparable<T>> void quickSort(T[] array, int esq, int dir){
        int i = esq;
        int j = dir;
        T temp;
        int pivo = (esq + dir) / 2;

        do{
            while(array[i].compareTo(array[pivo]) < 0) i++;
            while(array[j].compareTo(array[pivo]) > 0) j--;
            if(i <= j){
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }while(i <= j);

        if(esq < j){
            quickSort(array, esq, j);
        }
        if(dir < i){
            quickSort(array, i, dir);
        }
    }

    //mergesort
    public static  <T extends Comparable<T>> void mergeSort(T[] array, T[] vAux, int esq, int dir){
        if(esq < dir){
            int meio = (esq + dir) / 2;

            mergeSort(array, vAux, esq, meio);
            mergeSort(array, vAux , meio+1, dir);

            merge(array, vAux, esq, meio, dir);
        }

    }
    private static  <T extends Comparable<T>> void merge(T[] array, T[] vAux,  int esq, int meio, int dir){
        int i = esq;
        int j = meio+1;
        int k = 0;

        while(i <= meio && j <= dir){
            if(array[i].compareTo(array[j]) < 0){
                vAux[k] = array[i];
                i++;
            }
            else{
                vAux[k] = array[j];
                j++;
            }
            k++;
        }
        while(i <= meio){
            vAux[k] = array[i];
            i++;
            k++;
        }
        while(j <= dir){
            vAux[k] = array[j];
            j++;
            k++;
        }

        for(i = esq, k = 0; i <= dir; i++, k++ ){
            array[i] = vAux[k];
        }
    }
}
