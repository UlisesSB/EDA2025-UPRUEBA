/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP1.clases;

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

    /*Determina si un elemento pertenece a la lista*/
    public boolean pertenece(int buscado) {
        Nodo actual = this.primerNodo;
        while (actual != null) {
            if (actual.getDato() == buscado) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    /* Elimina todos los nodos que contengan el valor igual a x */
    public ListaEnlazadaInt borrarConValor(int buscado) {
        while (this.primerNodo != null && this.primerNodo.getDato() == buscado) {
            this.primerNodo = this.primerNodo.getSiguiente();
            this.cantNodo--;
        }

        if (this.primerNodo == null) {
            this.colaNodo = null;
            return this;
        }

        Nodo actual = this.primerNodo;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getDato() == buscado) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                this.cantNodo--;
            } else {
                actual = actual.getSiguiente();
            }
        }

        // Actualizar colaNodo si es necesario
        this.colaNodo = this.primerNodo;
        while (this.colaNodo != null && this.colaNodo.getSiguiente() != null) {
            this.colaNodo = this.colaNodo.getSiguiente();
        }

        return this;
    }

    /*Devuelve el contenido del nodo en la posición posicion*/
    public int valorEnPosicion(int posicion) {
        if (posicion < 0 || posicion >= this.cantNodo) {
            throw new IndexOutOfBoundsException("Posición inválida.");
        }

        Nodo actual = this.primerNodo;
        for (int i = 0; i < posicion; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getDato();
    }

    /*Modificar el contenido del nodo de la posición posicion*/
    public ListaEnlazadaInt modificarValorEnPosicion(int valor, int posicion) {
        if (posicion < 0 || posicion >= this.cantNodo) {
            throw new IndexOutOfBoundsException("Posición inválida.");
        }

        Nodo actual = this.primerNodo;
        for (int i = 0; i < posicion; i++) {
            actual = actual.getSiguiente();
        }

        actual.setDato(valor);
        return this;
    }

    /*Inserta un nodo en la posición posición con valor valor*/
    public ListaEnlazadaInt insertarEnPosicion(int valor, int posicion) {
        if (posicion < 0 || posicion > this.cantNodo) {
            throw new IndexOutOfBoundsException("Posición inválida.");
        }

        if (posicion == 0) {
            return insertarAlInicio(valor);
        } else if (posicion == this.cantNodo) {
            return insertarAlFinal(valor);
        } else {
            Nodo nuevoNodo = new Nodo(valor);
            Nodo actual = this.primerNodo;

            for (int i = 0; i < posicion - 1; i++) {
                actual = actual.getSiguiente();
            }

            nuevoNodo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevoNodo);
            this.cantNodo++;

            return this;
        }
    }
}
