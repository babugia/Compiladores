package src.COMPILADOR;

import javax.swing.JOptionPane;

public class Pilha {
    private Object obj[]; //vetor dinamico
    private int topo;    //variavel para ver o topo da pilha
    private int MAX;     //maximo da pilha, no caso coloquei um valor 30
    
    public Pilha() {
        this.topo = -1;    //topo começa com -1
        this.MAX = 30;     //maximo valor da pilha, no caso 30
        this.obj = new Object[MAX];
    }
    public boolean isEmpty() {
        return (topo == -1);    //caso a pilha esteja vazia
    }
    public boolean isFull() {
        return (topo == MAX-1); //caso a pilha esteja cheia
    }
    public void push(Object x) { //metodo para empilhar valores
        if(!isFull()) {
            topo++;
            obj[topo] = x;
        }
        else {
            System.out.println("PILHA CHEIA"); //caso a pilha esteja cheia
        }
    }
    public void print() {
        if(!isEmpty()) {
            String resp="";
            for(int i=0; i<=topo; i++) {
                resp += obj[i].toString() + ", ";
            }
            System.out.println(resp); //printa o que tem na pilha
        }
        else {
            System.out.println("PILHA VAZIA");
        }
    }
    public Object pop() {   //desempilha os valores
        if(!isEmpty()) {
            return obj[topo--];
        }
        else {
            return null;
        }
    }
    public Object top() { //valor que ficará no topo da pilha
        if(!isEmpty()) {
            return obj[topo];
        }
        else {
            return null;
        }
    }
}
