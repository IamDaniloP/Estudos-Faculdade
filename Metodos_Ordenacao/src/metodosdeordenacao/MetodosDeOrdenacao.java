package metodosdeordenacao;
import java.util.Random;
import java.util.Scanner;
/**
 * O Projeto foi realizado pela equipe:
 * 1 - Danilo Pereira Pessoa - 01561356;
 * 2 - Júlia Rebeca Vieira Félix Mesnard Correia - 01554077;
 * 3 - Júlio César Amorim de Souza - 01024947;
 * Turma: 2MD
 * Disciplina: Estrutura de Dados
 * Professor: José Mário Souza
 */
public class MetodosDeOrdenacao {
    public static void main(String[] args) {
        int vet[] = new int[1000];
        int vetAux[] = new int[vet.length];
        Random aleatorio = new Random();
        for(int i=0; i<vet.length;i++){
            vet[i] = aleatorio.nextInt(10000);
        }
        System.out.println("|-----------------------|");
        System.out.println("|   Lista Desordenada   |");
        System.out.println("|-----------------------|");
        System.out.println("");
        for(int val:vet){
            System.out.print(val+"-");
        }
        System.out.println("");
        Scanner leia = new Scanner(System.in); 
        int opc = 0;
        while (opc != 4){
            System.out.println("");
            System.out.println("|--------------------|");
            System.out.println("|   Vamos Ordenar?   |");
            System.out.println("|--------------------|");
            System.out.println("");
            System.out.println("1 - Por Troca");
            System.out.println("2 - Por Seleção");
            System.out.println("3 - Por Inserção");
            System.out.println("4 - Sair");
            System.out.println("");
            System.out.print("Informe a opção desejada: ");
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
                    System.out.println("Opção inválida!");
                    break;
            } 
        }
    }
    //BUBBLE SORT
    private static void ordenarPorTroca(int vetAux[]) {
        int tro = 0;                                         // Variável para contar a quantidade de Trocas desse método
        int com = 0;                                         // Variável para contar a quantidade de Comparações desse método
                                                             // c significa a casa que ele está
        System.out.println("|-------------------------|");
        System.out.println("|   Ordenação por Troca   |");
        System.out.println("|-------------------------|");
        System.out.println("");
        //criar aqui a lógica da Ordenação por Troca
        int aux;
        for(int i = 0; i <= vetAux.length - 1; i++){         // a variável i = 0
                                                             // o laço continua até que i seja menor ou igual ao tamanho do vetor - 1
                                                             // a cada vez que o laço for executado, i vai somar mais 1, ou seja i++
            for(int c = i + 1; c <= vetAux.length - 1; c++){ // c é igual a i + 1
                                                             // o laço continua até que c seja menor ou igual ao tamanho do vetor - 1.
                                                             // a cada vez que o laço for executado, c vai somar mais 1, ou seja c++
                if (vetAux[i] > vetAux[c]){                  // se a posição do índice (i) for maior que a posição do (c)                
                    aux = vetAux[c];                         // aux vai pegar o valor encontrado na posição c do vetAux para que fique salvo
                    vetAux[c] = vetAux[i];                   // a posição do (c) no vetAux vai passar a ser o valor encontrado no vetAux (i)
                    vetAux[i] = aux;                         // o valor que foi salvo antes de executar a troca, agora é inserido no seu local correto, posição i.
                    tro++;                                   // ao final da troca, some troca + 1, para dizer que ocorreu uma troca
                }
                com++;                                       // cada vez que esse laço for executado, ele estará fazendo uma comparação com os valores do vetor.
            }
        }
        listarVetorOrdenado(vetAux);
        listarComplexiade(tro,com);
    }
    //SELECTION SORT 
    private static void ordenarPorSelecao(int vetAux[]) {
        int tro = 0;                                         // Variável para contar a quantidade de Trocas desse método
        int com = 0;                                         // Variável para contar a quantidade de Comparações desse método
        System.out.println("|---------------------------|");
        System.out.println("|   Ordenação por Seleção   |");
        System.out.println("|---------------------------|");
        System.out.println("");
        //criar aqui a lógica da Ordenação por Seleção     
        int menor, aux;                                      // criada as variáveis menor e aux do tipo inteiro
        for (int i=0; i <=  vetAux.length - 1;i++){          // a variável i = 0
                                                             // o laço continua até que i seja menor ou igual ao tamanho do vetor - 1
                                                             // a cada vez que o laço for executado, i vai somar mais 1, ou seja i++
            menor = i;                                       // o valor de menor é igual ao valor de i
            for (int c = i+1; c <= vetAux.length - 1; c++){  // a variável c recebe i + 1 de início, sendo assim, ela sempre começará na casa seguinte a i
                                                             // o laço continua até que c seja menor ou igual ao tamanho do vetor - 1 
                                                             // a cada vez que o laço for executado, c vai somar mais 1, ou seja c++
                com++;                                       // comparação + 1, para contabilizar o número de comparações
                if (vetAux[c] < vetAux[menor]){              // se o valor do vetor que estiver em (c) for menor do que o valor do vetor que esta em (menor)
                    menor=c;                                 // faça (menor = c), assim, o c pode continuar fazendo as comparações e o menor valor encontrado fica armazenado na variável menor
                }
            }
            // início da troca dos vetores caso encontre um vetor menor.
            if ( menor != i) {                               // se menor for diferente de i, faça
            aux = vetAux[menor];                             // aux vai pegar o valor encontrado na posição menor do vetAux para que fique salvo. 
            vetAux[menor] = vetAux[i];                       // a posição do menor no vetAux vai passar a ser o valor encontrado no vetAux (i).
            vetAux[i] = aux;                                 // o valor que foi salvo antes de executar a troca, agora é inserido no seu local correto, na posição i. 
            tro++;                                           // troca + 1, para contabilizar o número de trocas.
            }                
        }
    listarVetorOrdenado(vetAux);
    listarComplexiade(tro,com);
    }
    //INSERTION SORT
    private static void ordenarPorInsercao(int vetAux[]) {
        int tro = 0;                                         // Variável para contar a quantidade de Trocas desse método
        int com = 0;                                         // Variável para contar a quantidade de Comparações desse método
        System.out.println("|----------------------------|");
        System.out.println("|   Ordenação por Inserção   |");
        System.out.println("|----------------------------|");
        System.out.println("");
        //criar aqui a lógica da Ordenação por Inserção
        int aux, c;           
        for (int i = 1; i < vetAux.length; i++) {            // o índice inicia em um, já que não a com quem comparar o vetor 0.
            aux = vetAux[i];                                 // o aux irá receber o valor que está na posição i
            c = i - 1;                                       // c irá iniciar na posição i - 1
            com++;                                           // cada vez que esse laço for executado, irá somar com++
            while (c >= 0 && vetAux[c] > aux) {              // enquanto c maior ou igual a 0 e a posição do c for menor que o valor do aux, faça
                vetAux[c + 1] = vetAux[c];                   // ele irá somar um a posição c e irá pegar o valor dessa nova posição
                c--;                                         // depois disso, fará c-- para voltar a casa que o c estava antes e continuar a comparação
                if ( c < 0 ) {                               // para que o vetor não compare com ´psições após o 0, no caso foi feito essa condição
                continue;                                    // caso a condição seja verdadeira ele ira voltar ao início do laço
                }
                com++;                                       // caso não seja, ele irá somar uma comparação
            }
            if (vetAux[ c + 1] != aux) {                     // se o vetor for diferente do auxiliar
                vetAux[c + 1] = aux;                         // aqui é onde a troca é efetuada
            tro++;                                           // aqui ele conta a troca
            }
        }
        listarVetorOrdenado(vetAux);
        listarComplexiade(tro,com);
    }
    private static void listarVetorOrdenado(int vetAux[]) {
        System.out.println("|--------------------|");
        System.out.println("|   Lista Ordenada   |");
        System.out.println("|--------------------|");
        for(int val:vetAux){
            System.out.print(val+"-");
        }
        System.out.println("");
        System.out.println("|----------------------|");
        System.out.println("|   Fim da Ordenação   |");
        System.out.println("|----------------------|");
        System.out.println("");
    }

    private static void listarComplexiade(int tro, int com) {
        System.out.println("|------------------|");
        System.out.println("|   Complexidade   |");
        System.out.println("|------------------|");
        System.out.println("");
        System.out.println("Comparações: "+com);
        System.out.println("Trocas: "+tro);
        System.out.println("");
        System.out.println("|---------|");
        System.out.println("|   Fim   |");
        System.out.println("|---------|");
    }
    
}