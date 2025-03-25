/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.clases;

/**
 *
 * @author ulisesSB
 */
public class ListaEnlazada {

    private Nodo nodo1;	// primer nodo de la lista
    private Nodo colaNodo;		// variable que apunta al último nodo
    private int cantidad;	// tamaño de la lista enlazada (cantidad de nodos)

    private ListaEnlazada() {
        this.nodo1 = null;
        this.colaNodo = null;
        this.cantidad = 0;
    }

    ;
        
    static ListaEnlazada crearLista() {
//Instancia y devuelve una lista vacía
        return new ListaEnlazada();
    }

    boolean esVacia() {
//Comprueba si la lista está vacía
        return nodo1 == null;
    }

    ListaEnlazada insertarAlInicio(int x) {
//Inserta un nodo al comienzo de la lista
        Nodo aux = new Nodo(x);

        if (this.nodo1 == null) {
            this.colaNodo = aux;
        }

        aux.setSiguiente(this.nodo1);
        this.nodo1 = aux;
        this.cantidad++;
        return this;
    }

    ListaEnlazada insertarAlFinal(int x
    ) //Inserta un nodo al final de la lista


    void mostrar() //Recorre los nodos de la Lista y muestra su contenido por pantalla


    int cantidad() //Devuelve la cantidad de nodos de la lista.


    int primerElemento() //Devuelve el primer elemento de la lista.


    ListaEnlazada borrarPrimero()
//Elimina el primer nodo de la lista
    ListaEnlazada borrarUltimo()
//Elimina el último nodo de la lista
    boolean pertenece(int buscado) //Determina si un elemento pertenece a la lista

    ListaEnlazada borrarConValor(int buscado

    )
//Elimina todos los nodos que contengan el valor igual a x
    int valorEnPosicion(int posicion) //Devuelve el contenido del nodo en la posición posicion

    ListaEnlazada modificarValorEnPosicion(int valor, int posicion

    )
//Modificar el contenido del nodo de la posición posicion
    ListaEnlazada insertarEnPosicion(int valor, int posicion) //Inserta un nodo en la posición posición con valor valor


    private class Nodo {

        private int dato;
        private Nodo siguiente;

        public Nodo(int x) {
            this.dato = x;
            this.siguiente = null;
        }

        public int getDato() {
            return dato;
        }

        public void setDato(int dato) {
            this.dato = dato;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
    }
