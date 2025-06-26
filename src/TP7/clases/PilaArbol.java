/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP7.clases;

import java.util.Stack;

/**
 *
 * @author Ulises
 */
public class PilaArbol {
    private Stack<ArbolBinario> pila;

    public PilaArbol() {
        pila = new Stack<>();
    }
    public void push(ArbolBinario arbol) {
        pila.push(arbol);
    }
    public ArbolBinario pop() {
        return pila.pop();
    }
    public boolean estaVacia() {
        return pila.isEmpty();
    }
}
