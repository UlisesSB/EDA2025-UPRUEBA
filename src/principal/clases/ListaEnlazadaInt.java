/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.clases;

/**
 *
 * @author Ulises
 */
public class ListaEnlazadaInt {

    /* clase Nodo anidada*/
    private class Nodo {

        /* atributos de Nodo*/
        private int dato;
        private Nodo siguiente;

        /* constructor de Nodo*/
        public Nodo(int num) {
            this.dato = num;
            this.siguiente = null;
        }

        /* get y set de Nodo*/
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

    /* atributos de ListaEnlazada*/
    private Nodo primerNodo;
    /* primer nodo de la lista*/
    private Nodo colaNodo;
    /* variable que apunta al último nodo*/
    private int cantNodo;
    /* tamaño de la lista enlazada (cantidad de nodos)*/

 /* constructor de ListaEnlazada*/
    private ListaEnlazadaInt() {
        this.primerNodo = null;
        this.colaNodo = null;
        this.cantNodo = 0;
    }

    /*Instancia y devuelve una Lista*/
    public static ListaEnlazadaInt crearLista() {
        return new ListaEnlazadaInt();
    }

    /*Comprueba si la lista está vacia*/
    boolean esVacia() {
        return this.primerNodo == null;
    }

    /*Inserta un Nodo al comienzo de la lista*/
    public ListaEnlazadaInt insertarAlInicio(int x) {
        Nodo nodoAux = new Nodo(x);

        if (this.primerNodo == null) {
            this.colaNodo = nodoAux;
        }

        nodoAux.setSiguiente(this.primerNodo);
        this.primerNodo = nodoAux;

        this.cantNodo++;
        return this;
    }

    /*Inserta un Nodo al final de la lista*/
    public ListaEnlazadaInt insertarAlFinal(int x) {
        Nodo nodoAux = new Nodo(x);

        if (this.primerNodo == null) {
            this.primerNodo = nodoAux;
            this.colaNodo = nodoAux;
        } else {
            this.colaNodo.setSiguiente(nodoAux);
            this.colaNodo = nodoAux;
        }

        this.cantNodo++;
        return this;
    }

    /*Recorre los nodos de la lista y muestra su contenido por pantalla*/
    public void mostrar() {
        if (this.primerNodo == null) {
            System.out.println("NO EXISTE NINGUN DATO");
            return;
        }

        Nodo nodoAux = this.primerNodo;

        while (nodoAux != null) {
            System.out.println(nodoAux.getDato());
            nodoAux = nodoAux.getSiguiente();

            if (nodoAux != null) {
                System.out.println(" | ");
            }
        }
    }

    /*Devuelve la cantidad de nodos de la lista*/
    public int cantidad() {
        return this.cantNodo;
    }

    /*Devuelve el primer elemento de la lista*/
    public int primerElemento() {
        if (this.primerNodo == null) {
            System.out.println("NO EXISTE NINGUN DATO");
        }
        return this.primerNodo.getDato();
    }

    /*Elimina el primer nodo de la Lista*/
    public ListaEnlazadaInt borrarPrimero() {
        if (this.primerNodo == null) {
            System.out.println("NO EXISTE NINGUN DATO");
            return this;
        }

        this.primerNodo = this.primerNodo.getSiguiente();

        if (this.primerNodo == null) {
            this.colaNodo = null;
        }

        this.cantNodo--;
        return this;
    }

    /*Elimina el ultimo nodo de la Lista*/
    public ListaEnlazadaInt borrarUltimo() {
        if (this.primerNodo == null) {
            System.out.println("NO EXISTE NINGUN DATO");
            return this;
        }

        if (this.primerNodo == this.colaNodo) {
            this.primerNodo = null;
            this.colaNodo = null;
        } else {
            Nodo nodoAux = this.primerNodo;
            while (nodoAux.getSiguiente() != this.colaNodo) {
                nodoAux = nodoAux.getSiguiente();
            }

            nodoAux.setSiguiente(null);
            this.colaNodo = nodoAux;
        }

        this.cantNodo--;
        return this;
    }
    
}
