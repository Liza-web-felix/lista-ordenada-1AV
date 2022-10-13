package listaordenada1AV;

import java.util.Random;
import java.util.Scanner;
/**
 * O Projeto foi realizado pela aluna:
 * 
 * 1 - 01132770 Liz Evelyn de Medeiros Felix
 * 
 * 
 *
 * Turma: 2NA
 * Disciplina: Estrutura de Dados
 * Professor: Jose Mario Souza
 */
public class Prova1AVEstruturaDeDados {
    public static void main(String[] args) {
        int vet[] = new int[20];
        int vetAux[] = new int[vet.length];
        Random aleatorio = new Random();
        for(int i=0; i<vet.length;i++){
            vet[i] = aleatorio.nextInt(1000);
        }
        System.out.println("### Lista Desordenada ###");
        for(int val:vet){
            System.out.print((val)+"-");
        }
        System.out.println("");
        @SuppressWarnings("resource")
		Scanner leia = new Scanner(System.in);
        int opc = 0;
        while (opc != 4){
            System.out.println("");
            System.out.println("# Vamos Ordenar? #");
            System.out.println("1 - Por Troca");
            System.out.println("2 - Por Selecao");
            System.out.println("3 - Por Insercao");
            System.out.println("4 - Sair");
            System.out.println("");
            System.out.print("Informe a opcao desejada: ");
            opc = leia.nextInt();
            switch (opc) {
                case 1:
                    vetAux = vet.clone();
                    ordenarPorTroca(vetAux);
                    break;
                case 2:
                    vetAux = vet.clone();
                    ordenarPorSelecao(vetAux);
                    break;
                case 3:
                    vetAux = vet.clone();
                    ordenarPorInsercao(vetAux);
                    break;
                case 4:
                    System.out.println("Sair");
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            } 
        }
    }

    private static void ordenarPorTroca(int vetAux[]) {
        int tro = 0; //Variavel para contar a quantidade de Trocas desse metodo
        int com = 0; //Variavel para contar a quantidade de Comparacoes desse metodo
        System.out.println("### Ordenação por Troca ###");
        //criar aqui a logica da Ordenacao por Troca
        int aux;
        for (int i = vetAux.length - 1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                com++;
                if (vetAux[j] > vetAux[j + 1]) {
                    aux = vetAux[j];
                    vetAux[j] = vetAux[j + 1];
                    vetAux[j + 1] = aux;
                    tro++;
                }
            }
        }
        listarComplexiade(tro,com);
        listarVetorOrdenado(vetAux);
    }

    private static void ordenarPorSelecao(int vetAux[]) {
        int tro = 0; //Variavel para contar a quantidade de Trocas desse metodo
        int com = 0; //Variavel para contar a quantidade de Comparações desse metodo
        System.out.println("### Ordenacao por Selecao ###");
        //criar aqui a logica da Ordenacao por Selecao
        int menor, aux;
        for(int i = 0; i < vetAux.length - 1; i++){
            menor = i;
            for(int j = i + 1; j < vetAux.length; j++){
                if (vetAux[j] < vetAux[menor]){
                    menor = j;
                }
                com++;
            }
            aux = vetAux[menor];
            vetAux[menor] = vetAux[i];
            vetAux[i] = aux;
            tro++;
        }

        listarComplexiade(tro,com);
        listarVetorOrdenado(vetAux);
    }

    private static void ordenarPorInsercao(int vetAux[]) {
        int tro = 0; //Variavel para contar a quantidade de Trocas desse metodo
        int com = 0; //Variavel para contar a quantidade de Comparacoes desse metodo
        System.out.println("### Ordenacao por Insercao ###");
        //criar aqui a logica da Ordenacao por Insercao

        int aux, j;
        for(int i = 1; i < vetAux.length; i++){
            aux = vetAux[i];
            j = i - 1;
            com++;
            while((j >= 0) && vetAux[j] > aux){
                vetAux[j+1] = vetAux[j];
                j = j - 1;
                tro++;
                com++;
            }
            vetAux[j + 1] = aux;
        }

        listarComplexiade(tro,com);
        listarVetorOrdenado(vetAux);
    }

    private static void listarVetorOrdenado(int vetAux[]) {
        System.out.println("### Lista Ordenada ###");
        for(int val:vetAux){
            System.out.print(val+"-");
        }
        System.out.println("");
    }

    private static void listarComplexiade(int tro, int com) {
        System.out.println("### Complexidade ###");
        System.out.println("Comparacao: "+com);
        System.out.println("Trocas: "+tro);
    }


}
