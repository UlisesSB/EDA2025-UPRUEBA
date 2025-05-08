/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.clases;

/**
 *
 * @author Ulises
 */
public class Pila<T> {
    private Nodo<T> cima;

    public Pila() {
        cima = null;
    }

    public boolean esVacia() {
        return cima == null;
    }

    public void push(T item) {
        Nodo<T> nuevo = new Nodo<>(item);
        nuevo.siguiente = cima;
        cima = nuevo;
    }

    public void pop() {
        if (!esVacia()) {
            cima = cima.siguiente;
        } else {
            System.out.println("La pila está vacía. No se puede hacer pop.");
        }
    }

    public T top() {
        if (!esVacia()) {
            return cima.dato;
        } else {
            System.out.println("La pila está vacía. No hay top.");
            return null;
        }
    }

    public T fondo() {
        if (esVacia()) {
            System.out.println("La pila está vacía. No hay fondo.");
            return null;
        }
        Nodo<T> actual = cima;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

    public void mostrar() {
        Nodo<T> actual = cima;
        System.out.print("Pila: [ ");
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println("]");
    }
}

