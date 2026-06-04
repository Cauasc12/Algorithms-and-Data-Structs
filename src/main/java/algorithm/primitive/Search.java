package algorithm.primitive;

//utilizou-se arrays de inteiro para fins de estudo de lógica

public class Search {

    //busca linear para listas não ordenadas - retorna o íncdice do elemento
    public static int unsortedLinearSearch(int[] array, int target) {
        for(int i = 0; i < array.length; i++) {
            // Compara os valores primitivos diretamente com ==
            if(array[i] == target) return i;
        }
        return -1;
    }

    //busca linear ordenada - retorna o indice do elemento
    public static int sortedLinearSearch(int[] array, int target) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] == target) {
                return i;
            } else if(array[i] > target) {
                return -1;
            }
        }
        return -1;
    }

    //busca binaria - retorna o indice do elemento
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while(left <= right) {
            int mid_index = (left + right) / 2;

            if(array[mid_index] == target) {
                return mid_index;
            } else if(array[mid_index] > target) {
                right = mid_index - 1;
            } else if(array[mid_index] < target) {
                left = mid_index + 1;
            }
        }
        return -1;
    }

    //busca binaria para elementos duplicados - retorna o indice do elemento
    public static int duplicateBinarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int result = -1;

        while(left <= right) {
            int mid_index = (left + right) / 2;

            if(array[mid_index] == target) {
                result = mid_index;
                right = mid_index - 1;
            } else if(array[mid_index] > target) {
                right = mid_index - 1;
            } else if(array[mid_index] < target) {
                left = mid_index + 1;
            }
        }
        return result;
    }
}