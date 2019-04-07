// Programação Feita por Fabiano Filho e Rodrigo Melo

package atividade_pesquisa;

import java.util.LinkedList;

public class Separate_Hash_Table {

    private LinkedList[] theList;

    private static final int DEFAULT_TABLE_SIZE = 100;

    

    public Separate_Hash_Table() {
        this(DEFAULT_TABLE_SIZE);
    }

    public Separate_Hash_Table(int size) {
        theList = new LinkedList[nextPrime(size)]; // Força o tamanho a ser primo
        for (int i = 0; i < theList.length; i++) {
            theList[i] = new LinkedList();
        }
    }

    public void makeEmpty() {
        for (int i = 0; i < theList.length; i++) {
            theList[i].clear();
        }
    }

    @SuppressWarnings("empty-statement")
    private static int nextPrime(int n) {
        if (n % 2 == 0) {
            n++;
        }
        for (; !isPrime(n); n += 2)
                ;
        return n;
    }

    private static boolean isPrime(int n) {
        if (n == 2 || n == 3) {
            return true;
        }
        if (n == 1 || n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void insert(Hashable x) {
        LinkedList whichList = theList[x.hash(theList.length)];
        if (whichList.indexOf(x) == -1) 
        {
            whichList.add(0, x);
        }
    }
    
    public void printColision(){
        int cont_colisoes=0; // Contador de colisões
        int pos_vazias=0; // Posições vazias na lista 
        int tam_lista=0; // Tamanho da lista
        for (int j = 0; j < theList.length; j++) {
            tam_lista = theList[j].size();
            if(tam_lista>=2){
                System.out.println("Houveram " + theList[j].size() + " colisões de alunos na posição " + j );
                cont_colisoes+=tam_lista;
            }
            else if (tam_lista==0){
                
                pos_vazias++;
            }

        }
        System.out.println("\nObtivemos um total de " + cont_colisoes + " colisões e " + pos_vazias + " posições vazias");
    }

    public void remove(Hashable x) {
        theList[x.hash(theList.length)].pop();
    }


    public Hashable find(Hashable x){
        int index=theList[x.hash(theList.length)].indexOf(x); //procurar o indice do obj na lista
        if (index>0)
            return (Hashable)(theList[x.hash(theList.length)].get(index));
        return null;
    }
}
