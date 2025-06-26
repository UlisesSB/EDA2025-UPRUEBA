/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP7.clases;

/**
 *
 * @author Ulises
 */
public class ArbolExpresion {

    public static ArbolBinario construirDesdePostfija(String[] expresionPostfija) {
        PilaArbol pila = new PilaArbol();

        for (String token : expresionPostfija) {
            if (esOperando(token)) {
                ArbolBinario hoja = new ArbolBinario(null, token.charAt(0), null);
                pila.push(hoja);
            } else if (esOperador(token)) {
                ArbolBinario derecho = pila.pop();
                ArbolBinario izquierdo = pila.pop();
                ArbolBinario subarbol = new ArbolBinario(izquierdo, token.charAt(0), derecho);
                pila.push(subarbol);
            }

        }
        return pila.pop();
    }

    private static boolean esOperando(String token) {
        return token.matches("[a-zA-Z0-9]");
    }

    private static boolean esOperador(String token) {
        return "+-*/".contains(token);
    }
}
