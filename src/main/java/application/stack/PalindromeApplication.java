package application.stack;

import data_struct.stack.StackLinkedList;

public class PalindromeApplication {

    public static boolean palindromeTest(String word){
        StackLinkedList<String> stack = new StackLinkedList<>();

        if(word == null){
            return false;
        }
        String tratedWord = word.replaceAll(" ", "");
        for(int i = 0; i < tratedWord.length(); i++){
            String caractere = tratedWord.substring(i, i+1);
            stack.push(caractere);
        }
        StringBuilder test = new StringBuilder();
        while(!stack.isEmpty()){
            test.append(stack.pop());
        }

        return tratedWord.equalsIgnoreCase(test.toString());
    }

    public static void main(String[] args){
        String string = "uaau";
        boolean resultado = palindromeTest(string);
        System.out.print(resultado);
    }

}
