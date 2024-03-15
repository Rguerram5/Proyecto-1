
package Arbol;

/* Importamos libreria */
import java.util.Stack;

public class Arbol {
    
    private Nodo raiz;
    private String expresion;

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public Arbol() {
        raiz = null;
        expresion = null;
    }

    public Arbol(Nodo raiz) {
        this.raiz = raiz;
    }

    /* Funciones para mandar a llamar en main*/
    public Nodo agregarNodo(char carac) {
        Nodo nodo = new Nodo();
        nodo.setValor(carac);
        nodo.setHojaDer(null);
        nodo.setHojaIzq(null);
        return nodo;
    }

    /* Generador de arbol */
    public void GeneracionArbol(String cadena) {        
        cadena = "(" + cadena;
        cadena += ")";
        this.expresion = cadena;
        this.raiz = GeneracionArbol();
    }
    
    public Nodo GeneracionArbol() {
        String cadena = this.expresion;
        Stack<Nodo> NodoSt = new Stack<>();
        Stack<Character> CaracterSt = new Stack<>();
        Nodo temp, temp1, temp2;

        int[] p = new int[123];
        p['+'] = p['-'] = 1;
        p['/'] = p['*'] = 2;
        p['^'] = 3;
        p[')'] = 0;

        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == '(') {
                CaracterSt.add(cadena.charAt(i));
            }
            else if (Character.isDigit(cadena.charAt(i))) {
                temp = agregarNodo(cadena.charAt(i));
                NodoSt.add(temp);
            } else if (p[cadena.charAt(i)] > 0) {
                while (!CaracterSt.isEmpty() && CaracterSt.peek() != '(' && ((cadena.charAt(i) != '^' && p[CaracterSt.peek()] >= p[cadena.charAt(i)]) || (cadena.charAt(i) == '^' && p[CaracterSt.peek()] > p[cadena.charAt(i)]))) {
                    temp = agregarNodo(CaracterSt.peek());
                    CaracterSt.pop();
                    temp1 = NodoSt.peek();
                    NodoSt.pop();
                    temp2 = NodoSt.peek();
                    NodoSt.pop();
                    temp.setHojaIzq(temp2);
                    temp.setHojaDer(temp1);
                    NodoSt.add(temp);
                }
            CaracterSt.push(cadena.charAt(i));
            } else if (cadena.charAt(i) == ')') {
                while (!CaracterSt.isEmpty() && CaracterSt.peek() != '(') {
                    temp = agregarNodo(CaracterSt.peek());
                    CaracterSt.pop();
                    temp1 = NodoSt.peek();
                    NodoSt.pop();
                    temp2 = NodoSt.peek();
                    NodoSt.pop();
                    temp.setHojaIzq(temp2);
                    temp.setHojaDer(temp1);
                    NodoSt.add(temp);
                }
                CaracterSt.pop();
            }
        }
        temp = NodoSt.peek();
        return temp;
    }

    /* Recorrido PreOrden */
    public void PreOrden() {
        PreOrden(this.raiz);
    }

    private void PreOrden(Nodo raiz) {
        if (raiz != null) {
            System.out.print(raiz.getValor() + " ");
            PreOrden(raiz.getHojaIzq());
            PreOrden(raiz.getHojaDer());
        }
    }
    
    private void recorrerPreOrden(StringBuilder sb, Nodo node) {
        if (node != null) {
            sb.append(node.getValor());
            sb.append("\n");
            recorrerPreOrden(sb, node.getHojaIzq());
            recorrerPreOrden(sb, node.getHojaDer());
        }
    }

    /* Recorrido InOrden */
    public void InOrden() {
        InOrden(this.raiz);
    }

    private void InOrden(Nodo raiz) {
        if (raiz != null) {
            InOrden(raiz.getHojaIzq());
            System.out.print(raiz.getValor() + " ");
            InOrden(raiz.getHojaDer());
        }
    }

    /* Recorrido PosOrden */
    public void PosOrden() {
        PosOrden(this.raiz);
    }

    private void PosOrden(Nodo raiz) {
        if (raiz != null) {
            PosOrden(raiz.getHojaIzq());
            PosOrden(raiz.getHojaDer());
            System.out.print(raiz.getValor() + " ");
        }
    }

    private void recorrerPosOrden(StringBuilder sb, Nodo node) {
        if (node != null) {
            recorrerPosOrden(sb, node.getHojaIzq());
            recorrerPosOrden(sb, node.getHojaDer());
            sb.append(node.getValor());
            sb.append("\n");
        }
    }

    /* Impresion de arbol */
    public void imprimirArbol() {
        imprimirArbol(this.raiz);
    }

    private void imprimirArbol(Nodo raiz) {
        imprimirArbol(raiz, 0);
    }

    private void imprimirArbol(Nodo raiz, int espaciador) {
        int espacios = 3;    
        if (raiz == null) {return;}
        espaciador += espacios;
        imprimirArbol(raiz.getHojaDer(), espaciador);
        System.out.print("\n");
        for (int i = espacios; i < espaciador; i++) {
            System.out.print("  ");
        }
        System.out.print(raiz.getValor() + "\n");
        imprimirArbol(raiz.getHojaIzq(), espaciador);
    }
}
