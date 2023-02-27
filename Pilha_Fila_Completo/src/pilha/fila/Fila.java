
package pilha.fila;

public class Fila {
    String elementos[];
    int topo;
    public Fila(){
        elementos = new String[5]; 
        topo = -1; 
    }

    public void IncluirFila(String valor){
        if (topo == 4) {
            System.out.println("---- A FILA JÁ ESTÁ CHEIA ----"); 
        }
        topo++;
        if(elementos[topo] == null){ 
            elementos[topo] = valor; 
        }
    }

    public void ExcluirFila(){
        if (topo == -1) {
            System.out.println(" ");
            System.out.println("---- A FILA ESTÁ VAZIA ----");
        } else {
            System.out.println(" Você tirou o elemento: " + elementos[0]);
            elementos[0] = null; 
            for(int i=0;i<elementos.length-1;i++){ 
                elementos[i]=elementos[i+1];
                elementos[i+1] = null; 
            }
            topo--;
        }
        
    }

    public void ListarFila(String fila[]){
        System.out.println(" ");
        System.out.println("----- EXIBINDO FILA -----");
        System.out.println(" ");
        for (String string : fila) {
            System.out.println (string);
        }
        System.out.println(" ");
        System.out.println("--------------------------");
    }
}
