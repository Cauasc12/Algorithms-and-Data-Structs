package application;

import data_struct.StackLinkedList;



public class NumberConverter {

    public static String decimalToBinary(int decimal){
        if(decimal == 0){
            return "0";
        }
        StackLinkedList<Integer> remainderStack = new StackLinkedList<>();

        while(decimal > 0){
            int reminder = decimal % 2;
            remainderStack.push(reminder);
            decimal = decimal/2;
        }

        String binary = "";

        while(!remainderStack.isEmpty()){
            binary = binary + remainderStack.pop();
        }
        return binary;
    }

    public static String decimalToOctary(int decimal){
        if(decimal == 0){
            return "0";
        }
        StackLinkedList<Integer> remainderStack = new StackLinkedList<>();

        while(decimal > 0){
            int reminder = decimal % 8;
            remainderStack.push(reminder);
            decimal = decimal/2;
        }

        String octary = "";

        while(!remainderStack.isEmpty()){
            octary = octary + remainderStack.pop();
        }
        return octary;
    }

    public static void main(String[] args){
        int teste = 45;

        System.out.println(decimalToBinary(45));
        System.out.println(decimalToOctary(45));

    }
}
