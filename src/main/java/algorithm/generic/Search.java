package algorithm.generic;

//algorítmos de busca simples

public class Search<T extends Comparable<T>> {

    //busca linear para listas não ordenadas - retorna o íncdice do elemento
    public static <T extends Comparable<T>> int unsortedLinearSearch(T[] array, T target){
        for(int i = 0; i < array.length; i++){
            if(array[i].equals(target)) return i;
        }
        return -1;
    }
    //busca linear ordenada - retorna o indice do elemento
    public static <T extends Comparable <T>> int sortedLinearSearch(T[] array, T target){
        for(int i = 0; i < array.length; i++){
            if(array[i].equals(target)) return i;
            else if(array[i].compareTo(target) > 0) return -1;
        }
        return -1;
    }

    //busca binaria - retorna o indice do elemento
    public static <T extends Comparable<T>> int binarySearch(T[] array, T target){
        int left = 0;
        int right = array.length - 1;
        while(left <= right){
            int mid_index = (left + right) / 2;
            if(array[mid_index].equals(target)) return mid_index;
            else if(array[mid_index].compareTo(target) > 0) {
                right = mid_index - 1;
            }
            else if(array[mid_index].compareTo(target) < 0){
                left = mid_index + 1;
            }
        }
        return -1;
    }

    //busca binaria para elementos duplicados - retorna o indice do elemento
    public static <T extends Comparable<T>> int duplicateBinarySearch(T[] array, T target){
        int left = 0;
        int right = array.length - 1;
        int result = -1;

        while(left <= right){
            int mid_index = (left + right) / 2;
            if(array[mid_index].equals(target)){
                result = mid_index;
                right = mid_index -1;
            }
            else if(array[mid_index].compareTo(target) > 0) {
                right = mid_index - 1;
            }
            else if(array[mid_index].compareTo(target) < 0){
                left = mid_index + 1;
            }
        }
        return result;

    }
}
