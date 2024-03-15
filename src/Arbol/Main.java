package Arbol;

/* Librerias */
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Scanner;

/* Clase Main */
public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        /* Declaracion de variables */
        Scanner op = new Scanner(System.in);
        int opcion;
        String expresion = null;
        /* Construccion de arbol */
        Arbol ab = new Arbol();
        
        /* Ciclo de menu */
        do {
            /* Construccion de Menu */
            System.out.println(" ");
            System.out.println("***** Menu de Arboles Binarios *****");
            System.out.println("1.- Arbol en Pre-Orden: ");
            System.out.println("2.- Arbol en In-Orden: ");
            System.out.println("3.- Arbol en Post-Orden: ");
            System.out.println("4.- Salir. ");
            System.out.print("Ingrese una opcion: ");
            opcion = op.nextInt();

            /* Switch con opciones de Menu */
            switch (opcion) {
                case 1:
                    System.out.print("Digite la expresion aritmetica: ");
                    try {
                        DataInputStream entrada = new DataInputStream(System.in);
                        expresion = entrada.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    ab.GeneracionArbol(expresion);
                    System.out.print("\nDatos en preorden: ");
                    ab.PreOrden();
                    System.out.println("\n\n** Secuencia de Arbol **\n");
                    ab.imprimirArbol();
                    break;
                case 2:
                    System.out.print("Digite la expresion aritmetica: ");
                    try {
                        DataInputStream entrada = new DataInputStream(System.in);
                        expresion = entrada.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    ab.GeneracionArbol(expresion);
                    System.out.print("\nDatos en inorden: ");
                    ab.InOrden();
                    System.out.println("\n\n** Secuencia de Arbol **\n");
                    ab.imprimirArbol();
                    break;
                case 3:
                    System.out.print("Digite la expresion aritmetica: ");
                    try {
                        DataInputStream entrada = new DataInputStream(System.in);
                        expresion = entrada.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    ab.GeneracionArbol(expresion);
                    System.out.print("\nDatos en postorden: ");
                    ab.PosOrden();
                    System.out.println("\n\n** Secuencia de Arbol **\n");
                    ab.imprimirArbol();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opcion invalida......");
                    System.out.println("Regresando.");
            }
        } while (opcion != 4);
    }
}
