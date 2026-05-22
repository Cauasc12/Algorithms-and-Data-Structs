public class teste {

    public void exchangeSort(int[] array){
        int temp;
        for(int i = 0; i <= array.length-1; i++){
            for(int j = i+1; j < array.length; j++){
                if(array[i] > array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public void bubbleSort(int[] array){
        int temp;
        int size = array.length;
        boolean change = true;
        while(change && size > 1){
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
        }
    }

    public void selectionSort(int[] array){
        int index_menor, temp;
        for(int i = 0; i < array.length-1; i++){
            index_menor = i;
            for(int j = i+1; j < array.length; j++){
                if(array[j] < array[index_menor]){
                    index_menor = j;
                }
            }
            if(i != index_menor){
                temp = array[i];
                array[i] = array[index_menor];
                array[index_menor] = temp;
            }
        }
    }

    public void insertingSort(int[] array){
        int temp;
        for(int i = 0; i < array.length; i++){
            int j = i;
            temp = array[i];
            while(j > 0 && (temp < array[j-1])){
                array[j] = array[j-1];
                j--;
            }
            array[j] = temp;
        }
    }

    public void quickSort(int[] array, int esq, int dir){
        int i = esq;
        int j = dir;
        int pivo = (esq - dir) / 2;
        int temp;
        while(i <= j){
            while(array[i] < pivo) i++;
            while(array[j] > pivo) j--;
            if(i <= j){
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if(esq < j){
            quickSort(array, esq, j);
        }
        if(dir > i){
            quickSort(array, i, dir);
        }
    }

    public void mergeSort(int[] array, int[] temp, int esq, int dir){
        if(esq < dir){
            int meio = (esq + dir) / 2;
            mergeSort(array, temp, esq, meio);
            mergeSort(array, temp, meio+1, dir);
            merge(array, temp, esq, meio+1, dir);
        }
    }

    public void merge(int[] array, int[] temp, int esq, int meio, int dir){
        int i = esq;
        int j = meio-1;
        int k = 0;

        while(esq <= j && meio <= dir){
            if(array[esq] < array[meio]){
                temp[k] = array[esq];
                k++;
                esq++;
            }
            else{
                temp[k] = array[meio];
                k++;
                meio++;
            }
        }
        while(esq <= j){
            temp[k] = array[esq];
            k++;
            esq++;
        }
        while(meio <= dir){
            temp[k] = array[meio];
            k++;
            meio++;
        }
        for(int x = 0; x < dir; x++){
            array[x] = temp[x];
        }
    }
}
