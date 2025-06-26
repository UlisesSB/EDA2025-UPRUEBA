/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP7.clases;

/**
 *
 * @author Ulises
 */
public class ArbolBinario {
 
    private Character valor;
    private ArbolBinario izq;
    private ArbolBinario der;

    public ArbolBinario() {
        this.valor = null;
        this.izq = null;
        this.der = null;
    }
    public ArbolBinario(ArbolBinario izq, Character valor, ArbolBinario der) {
    this.valor = valor;
    this.izq = izq;
    this.der = der;
}


    // Constructor ABVACIO
    public static ArbolBinario ABVACIO() {
        return new ArbolBinario();
    }

    // Constructor ARMARAB
    public static ArbolBinario ARMARAB(ArbolBinario subIzquierdo, Character valorRaiz, ArbolBinario subDerecho) {
        ArbolBinario nuevo = new ArbolBinario();
        if (valorRaiz == null) {
        return null;
        }
        if (subIzquierdo != null) {
            nuevo.izq = subIzquierdo;
        }
        if (subDerecho != null) {
            nuevo.der = subDerecho;
        }
        return nuevo;
    }


    // ESABVACIO
    public boolean esVacio() {
        return this.valor == null;
    }

    // RAIZ
    public Character raiz() {
        if (esVacio()) {
            throw new IllegalStateException("El árbol es vacío");
        }
        return this.valor;
    }

    // IZQUIERDO
    public ArbolBinario izquierdo() {
        if (esVacio()) {
            return new ArbolBinario();
        }
        return izq;
    }

    // DERECHO
    public ArbolBinario derecho() {
        if (esVacio()) {
            return new ArbolBinario();
        }
        return der;
    }

    // PERTENECE
    public boolean pertenece(Character item) {
        if (esVacio()) {
            return false;
        }
        if (valor.equals(item)) {
            return true;
        }
        return izq.pertenece(item) || der.pertenece(item);
    }
}
