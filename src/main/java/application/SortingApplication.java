package application;
import algorithm.Sorting;

public class SortingApplication {

    private static class Atleta{
        private String nome;
        private double altura;
        private double peso;

        //Constructor
        Atleta(String nome, double altura, double peso){
            this.nome = nome;
            this.altura = altura;
            this.peso = peso;
        }

        //Getters
        public double getAltura() {
            return altura;
        }

        public String getNome() {
            return nome;
        }

        public double getPeso() {
            return peso;
        }

        //Setters
        public void setPeso(double peso) {
            this.peso = peso;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setAltura(double altura) {
            this.altura = altura;
        }
    }

    public static void main(String[] args){

        Atleta[] atletas = {
                new Atleta("João", 1.75, 70.0),
                new Atleta("Maria", 1.68, 60.5),
                new Atleta("Carlos", 1.82, 85.0),
                new Atleta("Ana", 1.60, 55.0),
                new Atleta("Pedro", 1.90, 92.3),
                new Atleta("Lucas", 1.78, 74.8),
                new Atleta("Fernanda", 1.70, 63.2),
                new Atleta("Juliana", 1.65, 58.4),
                new Atleta("Rafael", 1.85, 88.7),
                new Atleta("Beatriz", 1.72, 61.9)
        };

        Atleta temp;
        int size = atletas.length;
        boolean change;
        do{
            change = false;
            for(int i = 0; i < size-1; i++){
                if(atletas[i].getAltura() > atletas[i+1].getAltura()){
                    temp = atletas[i];
                    atletas[i] = atletas[i+1];
                    atletas[i+1] = temp;
                    change = true;
                }
            }
            size--;
        }while(change && size > 1);

        for(int i = 0; i < atletas.length; i++){
            System.out.println(atletas[i].getNome());
        }
    }
}
