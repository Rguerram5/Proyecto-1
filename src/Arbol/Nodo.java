
package Arbol;

public class Nodo {
    private char valor;
    private Nodo hojaIzq,hojaDer, nodoPadre;
    
    public Nodo(char valor) {
        this.valor = valor;
        this.hojaIzq = null;
        this.hojaDer = null;
    }

    public Nodo() {        
        this.hojaIzq = null;
        this.hojaDer = null;
    } 
    
    /* Setters de Clase Nodo */
    public void setValor(char valor) {
        this.valor = valor;
    }

    public void setHojaIzq(Nodo hojaIzq) {
        this.hojaIzq = hojaIzq;
    }
    
    public void setHojaDer(Nodo hojaDer) {
        this.hojaDer = hojaDer;
    }
    
    public void setNodoPadre(Nodo nodoPadre) {
        this.nodoPadre = nodoPadre;
    }
    
    /* Getters de Clase Nodo */
    public Nodo getHojaIzq() {
        return hojaIzq;
    }
    
    public char getValor() {
        return valor;
    }
 
    public Nodo getHojaDer() {
        return hojaDer;
    }  

    public Nodo getNodoPadre() {
        return nodoPadre;
    }
    
}
