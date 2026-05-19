package algorithm;

//utilizou-se arrays de inteiro para fins de exemplo

//algorítmos de ordenação/classificação  recursivos
public class RecursiveSorting {

    //quicksort
    public static void quickSort(int[] array){
        quickSort(array, 0, array.length-1);
    }
    private static void quickSort(int[] array, int esq, int dir){
        int i = esq;
        int j = dir;
        int temp;
        int pivo = (esq + dir) / 2;

        do{
            while(array[i] < pivo) i++;
            while(array[j] > pivo) j--;
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
    public static void mergeSort(int[] array, int esq, int dir){
        if(esq < dir){
            int meio = (esq + dir) / 2;

            mergeSort(array, esq, meio);
            mergeSort(array, meio+1, dir);

            merge(array, esq, meio, dir);
        }

    }
    private static void merge(int[] array, int esq, int meio, int dir){
        int i = esq;
        int j = meio+1;
        int k = 0;

        int[] vAux = new int[dir-esq+1];

        while(i <= meio && j <= dir){
            if(array[i] < array[j]){
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
            array[i] = vAux[j];
        }
    }
}
