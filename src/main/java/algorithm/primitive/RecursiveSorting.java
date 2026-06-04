package algorithm.primitive;

//utilizou-se arrays de inteiro para fins de estudo de lógica

//algoritmos de ordenação/classificação recursivos
public class RecursiveSorting {

    //quickSort
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int esq, int dir) {
        int i = esq;
        int j = dir;
        int temp;

        int pivo = (esq + dir) / 2;

        do {
            while(array[i] < array[pivo]) i++;
            while(array[j] > array[pivo]) j--;

            if(i <= j) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        } while(i <= j);

        if(esq < j) {
            quickSort(array, esq, j);
        }
        if(dir < i) {
            quickSort(array, i, dir);
        }
    }

    //mergeSort
    public static void mergeSort(int[] array, int[] vAux, int esq, int dir) {
        if(esq < dir) {
            int meio = (esq + dir) / 2;

            mergeSort(array, vAux, esq, meio);
            mergeSort(array, vAux, meio + 1, dir);

            merge(array, vAux, esq, meio, dir);
        }
    }


    private static void merge(int[] array, int[] vAux, int esq, int meio, int dir) {
        int i = esq;
        int j = meio + 1;
        int k = 0;

        while(i <= meio && j <= dir) {
            if(array[i] < array[j]) {
                vAux[k] = array[i];
                i++;
            } else {
                vAux[k] = array[j];
                j++;
            }
            k++;
        }
        while(i <= meio) {
            vAux[k] = array[i];
            i++;
            k++;
        }
        while(j <= dir) {
            vAux[k] = array[j];
            j++;
            k++;
        }

        for(i = esq, k = 0; i <= dir; i++, k++) {
            array[i] = vAux[k];
        }
    }
}