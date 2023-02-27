
package pilha.fila;

public class Pilha {
    String pilha[];
    int topo;
    public Pilha(){ 
        
        pilha = new String[5];
        topo = -1; 
    }

    public void Empilhar(String valor) {
        topo++;
        if(topo==4){
            System.out.println("---- A PILHA JÁ ESTÁ CHEIA ----");
        }
        if (pilha[topo]==null){ 
            pilha[topo] = valor; 
        }
    }

    public void Desempilhar(String pilha[]) {
        if ( topo == -1 ) {
            System.out.println(" ");
            System.out.println("---- A PILHA ESTÁ VAZIA ----");
        } else {
            System.out.println(" ");
            System.out.println("Você desempilhou o elemento da posição: " + topo);
            pilha[topo] = null; 
            topo--; 
        }
    }

    public void ListarPilha(String pilha[]){
        System.out.println(" ");
        System.out.println("----- EXIBINDO PILHA -----");
        System.out.println(" ");
        for (String element : pilha) {
            System.out.println(element);
        }
        System.out.println(" ");
        System.out.println("--------------------------");
    }
}
