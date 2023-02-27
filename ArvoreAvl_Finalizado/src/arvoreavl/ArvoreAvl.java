package arvoreavl;

public class ArvoreAvl {

    protected No raiz;

    public void Inserir(int valor) {
	No node = new No(valor);
	Inserir(this.raiz, node);
    }

    public void Inserir(No comparar, No inserir) {

        if (comparar == null) {

            this.raiz = inserir;

        } else {

            if (inserir.getValor() < comparar.getValor()) {

                if (comparar.getEsquerda() == null) {
                    comparar.setEsquerda(inserir);
                    inserir.setPai(comparar);
                    verificarBalanceamento(comparar);

                } else {
                    Inserir(comparar.getEsquerda(), inserir);
                }

            } else if (inserir.getValor() > comparar.getValor()) {

                if (comparar.getDireita() == null) {
                    
                    comparar.setDireita(inserir);
                    inserir.setPai(comparar);
                    verificarBalanceamento(comparar);

                } else {                    
                    Inserir(comparar.getDireita(), inserir);                    
                }

            } else {
                System.out.println("");
                System.out.println("O nó já existe!");               
            }

        }
    }

    public void verificarBalanceamento(No atual) {
        
	fatorBalanceamento(atual);
	int balanceamento = atual.getBalanceamento();

	if (balanceamento == -2) {

            if (altura(atual.getEsquerda().getEsquerda()) >= altura(atual.getEsquerda().getDireita())) {                            
                atual = rotacaoDireita(atual);
            } else {                            
                atual = duplaRotacaoEsquerdaDireita(atual);
            }

	} else if (balanceamento == 2) {

            if (altura(atual.getDireita().getDireita()) >= altura(atual.getDireita().getEsquerda())) {
                atual = rotacaoEsquerda(atual);
            } else {
                atual = duplaRotacaoDireitaEsquerda(atual);
            }
	}

	if (atual.getPai() != null) {
            verificarBalanceamento(atual.getPai());
	} else {
            this.raiz = atual;
	}
        
    }
    
    public boolean Vazia() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public void Remover(int valor) {
        Remover(this.raiz, valor);
    }

    public void Remover(No atual, int valor) {
        
        if (atual == null) {
            return;
        } else {

            if (atual.getValor() > valor) {
                Remover(atual.getEsquerda(), valor);

            } else if (atual.getValor() < valor) {
                Remover(atual.getDireita(), valor);

            } else if (atual.getValor() == valor) {
                removerNoEncontrado(atual);
            }           
        }
    }
    public void Buscar (int valor) {
        Buscar(this.raiz, valor);
    }
    
    public void Buscar ( No atual, int valor ){
        
        System.out.println("BUSCANDO...");
    
        if ( atual != null) {

            if (atual.getValor() > valor) {
                Buscar(atual.getEsquerda(), valor);

            } else if (atual.getValor() < valor) {
                Buscar(atual.getDireita(), valor);

            } else if (atual.getValor() == valor) {
                System.out.println("");
                System.out.println("Esse nó pertence a árvore!");
            }           
        } else {
            
            System.out.println("");
            System.out.println("Esse nó não pertence a árvore!");
            
        }
        
        System.out.println("");
        System.out.println("FIM DA BUSCA");
        
    }

    public void removerNoEncontrado(No remover) {
        
        No r;

        if (remover.getEsquerda() == null || remover.getDireita() == null) {

            if (remover.getPai() == null) {
                this.raiz = null;
                remover = null;
                return;
            }
            
            r = remover;

        } else {
            
            r = sucessor(remover);
            remover.setValor(r.getValor());
            
        }

        No p;
        
        if (r.getEsquerda() != null) {
            p = r.getEsquerda();
        } else {
            p = r.getDireita();
        }

	if (p != null) {
            p.setPai(r.getPai());
	}

	if (r.getPai() == null) {
            this.raiz = p;
	} else {
            
            if (r == r.getPai().getEsquerda()) {
                r.getPai().setEsquerda(p);
            
            } else {
                r.getPai().setDireita(p);
            }
            
            verificarBalanceamento(r.getPai());
	}
        
        r = null;
        
    }

    public No rotacaoEsquerda(No inicial) {

        No direita = inicial.getDireita();
        direita.setPai(inicial.getPai());

        inicial.setDireita(direita.getEsquerda());

        if (inicial.getDireita() != null) {
            inicial.getDireita().setPai(inicial);
	}

        direita.setEsquerda(inicial);
        inicial.setPai(direita);

        if (direita.getPai() != null) {

            if (direita.getPai().getDireita() == inicial) {
                direita.getPai().setDireita(direita);

            } else if (direita.getPai().getEsquerda() == inicial) {
                direita.getPai().setEsquerda(direita);
            }
            
	}

        fatorBalanceamento(inicial);
        fatorBalanceamento(direita);

        return direita;
    }

    public No rotacaoDireita(No inicial) {

	No esquerda = inicial.getEsquerda();
	esquerda.setPai(inicial.getPai());

        inicial.setEsquerda(esquerda.getDireita());

        if (inicial.getEsquerda() != null) {
            inicial.getEsquerda().setPai(inicial);
        }

        esquerda.setDireita(inicial);
        inicial.setPai(esquerda);

	if (esquerda.getPai() != null) {

            if (esquerda.getPai().getDireita() == inicial) {
                esquerda.getPai().setDireita(esquerda);
            } else if (esquerda.getPai().getEsquerda() == inicial) {
                esquerda.getPai().setEsquerda(esquerda);
            }
            
        }

        fatorBalanceamento(inicial);
        fatorBalanceamento(esquerda);

        return esquerda;
    }

    public No duplaRotacaoEsquerdaDireita(No inicial) {
	inicial.setEsquerda(rotacaoEsquerda(inicial.getEsquerda()));
	return rotacaoDireita(inicial);
    }

    public No duplaRotacaoDireitaEsquerda(No inicial) {
	inicial.setDireita(rotacaoDireita(inicial.getDireita()));
	return rotacaoEsquerda(inicial);
    }

    public No sucessor(No q) {
        if (q.getDireita() != null) {
                
            No r = q.getDireita();
                
            while (r.getEsquerda() != null) {
                r = r.getEsquerda();
            }
                
            return r;
                
        } else {
                
            No p = q.getPai();
                
            while (p != null && q == p.getDireita()) {
                q = p;
                p = q.getPai();
            }
                
            return p;
                
	}
    }

    private int altura(No atual) {
        
        if (atual == null) {  
            return -1;
          
        }

        if (atual.getEsquerda() == null && atual.getDireita() == null) {
            return 0;
            
	} else if (atual.getEsquerda() == null) {
            return 1 + altura(atual.getDireita());
            
        } else if (atual.getDireita() == null) {
            return 1 + altura(atual.getEsquerda());
            
        } else {
            return 1 + Math.max(altura(atual.getEsquerda()), altura(atual.getDireita()));
	}
        
    }

    private void fatorBalanceamento(No no) {
	no.setBalanceamento(altura(no.getDireita()) - altura(no.getEsquerda()));
    }

    public void imprimirArvore() {
            imprimirArvore(this.raiz);
    }

    private void imprimirArvore(No node) {
        if (node.getEsquerda() != null) {
            imprimirArvore(node.getEsquerda());
        }
        if (node.getDireita() != null) {
            imprimirArvore(node.getDireita());
        }
        System.out.print(node.getValor() + " - ");
        try {
            System.out.println("NóEsquerda: " + node.getEsquerda().getValor());
            System.out.println("");
            System.out.println("NóDireita: " + node.getDireita().getValor());
            System.out.println("");
        } catch (NullPointerException e) {
            e.getStackTrace();
        }
    }
}
