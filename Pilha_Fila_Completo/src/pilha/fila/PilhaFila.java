package pilha.fila;

import java.util.Scanner;

// Aluno: Danilo Pereira Pessoa 
// Matrícula: 01561356  
// Engenharia da Computação - 2MD


public class PilhaFila {
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int opc = 0;

        Pilha p = new Pilha(); 
        Fila f = new Fila(); 
        
        while (opc != 7){
            System.out.println(" ");
            System.out.println("----- P I L H A -----");
            System.out.println("1 - Empilhar");
            System.out.println("2 - Desempilhar");
            System.out.println("3 - Listar Pilha");
            System.out.println(" ");
            System.out.println("----- F I L A -----");
            System.out.println("4 - Incluir Fila");
            System.out.println("5 - Remover Fila");
            System.out.println("6 - Listar Fila");
            System.out.println(" ");
            System.out.println("-------------------");
            System.out.println("7 - Sair");
            System.out.println("");
            System.out.print("Informe a opção desejada: ");
            opc = ler.nextInt();
            switch (opc) {
                case 1:
                    //EMPILHAR
                    for(int i= p.topo; i <= p.pilha.length - 1 ;i++){
                        if(p.topo==4){
                            System.out.println(" ");
                            System.out.println("---- A PILHA JÁ ESTÁ CHEIA ----");
                            break;
                        }
                        System.out.println(" ");
                        System.out.print("Digite um valor para empilhar: ");                        
                        String esc = ler.next(); 
                        p.Empilhar(esc); 
                        System.out.println(" ");
                        System.out.println("Deseja inserir mais um valor? ");
                        System.out.println(" 1- SIM ou 2 - NÃO ");
                        int continuar = ler.nextInt(); 
                        if (continuar==2){
                            break;
                        }
                    }
                    break;
                case 2:
                    // DESEMPILHAR
                    p.Desempilhar(p.pilha);
                    break;
                case 3:
                    //LISTAR PILHA
                    p.ListarPilha(p.pilha);
                    break;
                case 4:
                    //INCLUIR FILA
                    for(int i = f.topo; i <= f.elementos.length - 1 ; i++){
                        if(f.topo == 4){
                            System.out.println(" ");
                            System.out.println("---- A FILA JÁ ESTÁ CHEIA ----");
                            break;
                        } else {
                            System.out.println(" ");
                            System.out.print("Digite um valor para incluir na fila: ");
                            String esc = ler.next(); 
                            f.IncluirFila(esc); 
                            System.out.println(" ");
                            System.out.println("Deseja inserir mais um valor?"); 
                            System.out.println(" 1 - SIM ou 2 - NÃO ");

                            int continuar = ler.nextInt(); 
                            if (continuar==2){
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    //EXCLUIR FILA
                    f.ExcluirFila();
                    break;
                case 6:
                    //LISTAR FILA
                    f.ListarFila(f.elementos);
                    break;
                case 7:
                    System.out.println("Sair");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            } 
        }
        ler.close();
    }

}
