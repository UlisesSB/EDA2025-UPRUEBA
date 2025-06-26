/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TP7.clases;

/**
 *
 * @author Ulises
 */
public class MAINTP7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*Probar el punto 1*/
        String[] expresionPostfija = {"a", "b", "+", "c", "d", "-", "*"};
        ArbolBinario arbol = ArbolExpresion.construirDesdePostfija(expresionPostfija);
        System.out.println("Árbol de expresión construido correctamente.");

        /*Probar el punto 2*/
        // ESABVACIO
        ArbolBinario vacio = new ArbolBinario(null, null, null);
        System.out.println("\nESABVACIO(vacio): " + vacio.esVacio());
        System.out.println("ESABVACIO(arbol): " + arbol.esVacio());

        // RAIZ
        System.out.println("RAIZ(arbol): " + arbol.raiz());

        // IZQUIERDO
        ArbolBinario izquierdo = arbol.izquierdo();
        System.out.println("RAIZ(IZQUIERDO(arbol)): " + izquierdo.raiz());

        // DERECHO
        ArbolBinario derecho = arbol.derecho();
        System.out.println("RAIZ(DERECHO(arbol)): " + derecho.raiz());

        // ARMARAB
        ArbolBinario hojaX = new ArbolBinario(null, 'x', null);
        ArbolBinario hojaY = new ArbolBinario(null, 'y', null);
        ArbolBinario sumaXY = new ArbolBinario(hojaX, '+', hojaY);
        System.out.println("RAIZ(ARMARAB(x, '+', y)): " + sumaXY.raiz());
        System.out.println("RAIZ(IZQUIERDO(ARMARAB)): " + sumaXY.izquierdo().raiz());
        System.out.println("RAIZ(DERECHO(ARMARAB)): " + sumaXY.derecho().raiz());

        // PERTENECE
        System.out.println("PERTENECE(arbol, '*'): " + arbol.pertenece('*'));
        System.out.println("PERTENECE(arbol, 'z'): " + arbol.pertenece('z'));

        /*Probar Recorridos del punto 3*/
        // PREORDEN
        System.out.print("PreOrden: ");
        Recorridos.preOrden(arbol);
        System.out.println();

        //ENORDEN
        System.out.print("EnOrden: ");
        Recorridos.enOrden(arbol);
        System.out.println();

        //POSORDEN
        System.out.print("PosOrden: ");
        Recorridos.posOrden(arbol);
        System.out.println();

        /*Probar el punto 5*/
    }
}
