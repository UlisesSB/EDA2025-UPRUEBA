/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP7.clases;

/**
 *
 * @author Ulises
 */
public class Recorridos {

    public static void preOrden(ArbolBinario ab) {
        if (!ab.esVacio()) {
            System.out.print(ab.raiz() + " ");
            preOrden(ab.izquierdo());
            preOrden(ab.derecho());
        }
    }

    public static void enOrden(ArbolBinario ab) {
        if (!ab.esVacio()) {
            System.out.print("(");
            enOrden(ab.izquierdo());
            System.out.print(ab.raiz());
            enOrden(ab.derecho());
            System.out.print(")");
        }
    }

    public static void posOrden(ArbolBinario ab) {
        if (!ab.esVacio()) {
            posOrden(ab.izquierdo());
            posOrden(ab.derecho());
            System.out.print(ab.raiz() + " ");
        }
    }
}
