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
        System.out.println("--- Prueba de enFila ---");
        Fila fila = Fila.filaVacia();
        fila.enFila(1).enFila(2).enFila(3);
        fila.mostrar(); // Esperado: 1->2->3->NULL

        System.out.println("\n--- Prueba de enFila en otra fila ---");
        Fila otraFila = Fila.filaVacia();
        otraFila.enFila(6).enFila(7).enFila(8);
        otraFila.mostrar(); // Esperado: 6->7->8->NULL

        System.out.println("\n--- Prueba de esFilaVacia ---");
        System.out.println("Es vacia: " + fila.esFilaVacia()); // Esperado: false

        System.out.println("\n--- Prueba de deFila ---");
        fila.deFila();
        fila.mostrar(); // Esperado: 2->3->NULL

        System.out.println("\n--- Prueba de frente ---");
        System.out.println("Frente: " + fila.frente()); // Esperado: 2

        System.out.println("\n--- Prueba de borrar (elimina el 3) ---");
        fila.borrar(3);
        fila.mostrar(); // Esperado: 2->NULL

        System.out.println("\n--- Prueba de cantidad ---");
        System.out.println("Cantidad: " + fila.cantidad()); // Esperado: 1

        System.out.println("\n--- Prueba de invertir ---");
        Fila otraFilaInv = invertir(otraFila);
        otraFilaInv.mostrar(); // Esperado: 8->7->6->NULL

        System.out.println("\n--- Prueba de enfilan (agrega tres 7) ---");
        Fila.enfilan(otraFilaInv, 7, 3);
        otraFilaInv.mostrar(); // Esperado: 8->7->6->7->7->7->NULL

        System.out.println("\n--- Prueba de reenfilar (mueve primer elemento al final) ---");
        Fila.reenfilar(otraFilaInv);
        otraFilaInv.mostrar(); // Esperado: 7->6->7->7->7->8->NULL

        System.out.println("\n--- Prueba de toArray ---");
        Fila filaParaArray = Fila.filaVacia().fromArray(new int[]{11, 22, 33});
        int[] arreglo = filaParaArray.toArray();
        System.out.print("Array resultante: ");
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println(); // Esperado: 11 22 33

        System.out.println("\n--- Prueba de fromArray ---");
        Fila desdeArray = Fila.filaVacia().fromArray(new int[]{10, 20, 30});
        desdeArray.mostrar(); // Esperado: 10->20->

        System.out.println("\n--- Prueba merge ---");
        Fila base = Fila.filaVacia().fromArray(new int[]{100, 200});
        base.merge(desdeArray);
        base.mostrar(); // 100->200->10->20->30->NULL

        System.out.println("\n--- Prueba copiar ---");
        Fila copia = base.copiar();
        copia.mostrar(); // 100->200->10->20->30->NULL

        System.out.println("\n--- Prueba dividir ---");
        Fila filaDividir = Fila.filaVacia().fromArray(new int[]{1, 2, 3, 4, 5});
        Fila resultadoDivision = filaDividir.dividir(3);
        System.out.print("Fila dividida (resultado): ");
        resultadoDivision.mostrar(); // 1->2->3->NULL
        System.out.print("Fila original después de dividir: ");
        filaDividir.mostrar(); // 4->5->NULL

        System.out.println("\n--- Prueba unir ---");
        Fila filaUnida = Fila.unir(resultadoDivision, filaDividir);
        filaUnida.mostrar(); // 1->2->3->4->5->NULL

        System.out.println("\n--- Prueba limpiar ---");
        filaUnida.limpiar();
        filaUnida.mostrar(); // NULL
        System.out.println("Cantidad después de limpiar: " + filaUnida.cantidad()); // 0

    }
}
