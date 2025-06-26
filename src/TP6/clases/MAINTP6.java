/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6.clases;

import static TP6.clases.Fila.invertir;

/**
 *
 * @author
 */
public class MAINTP6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fila fila = Fila.filaVacia();
        Fila otraFila = Fila.filaVacia();
        Fila otraFilaInv = Fila.filaVacia();

        fila.enFila(1).enFila(2).enFila(3);
        fila.mostrar(); // 1->2->3->NULL
        otraFila.enFila(6).enFila(7).enFila(8);
        otraFila.mostrar(); // 6->7->8->NULL

        System.out.println("Es vacia: " + fila.esFilaVacia()); // false

        fila.deFila();
        fila.mostrar(); // 2->3->NULL

        System.out.println("Frente: " + fila.frente()); // 2

        fila.borrar(3);
        fila.mostrar(); // 2->NULL

        System.out.println("Cantidad: " + fila.cantidad()); // 1

        otraFilaInv = invertir(otraFila);
        otraFilaInv.mostrar();
        
        Fila.enfilan(otraFilaInv, 7, 3); // agrega 7->7->7
        otraFilaInv.mostrar();           // 6->7->8->7->7->7->NULL

        Fila.reenfilar(otraFilaInv);     // mueve el primer 7 al final
        otraFilaInv.mostrar();           // 7->6->7->8->7->7->NULL
    }
}
