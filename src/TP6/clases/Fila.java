package TP6.clases;

/**
 * @author estudiante
 */
public class Fila {

    class Nodo {

        private Integer dato;
        private Nodo siguiente;

        /*constructor*/
        public Nodo(Integer dato) {
            this.dato = dato;
            this.siguiente = null;
        }

        /*get y set*/
        public void setSiguiente(Nodo n) {
            this.siguiente = n;
        }

        public Nodo getSiguiente() {
            return this.siguiente;
        }

        public void setDato(Integer d) {
            this.dato = d;
        }

        public int getDato() {
            return this.dato;
        }
    }

    private Nodo frente; // Primer nodo de la fila
    private Nodo ultimo; // Último nodo de la fila
    private int cantidad; // Cantidad de elementos en la fila

    public static Fila filaVacia() {
        return new Fila();
    }

    public boolean esFilaVacia() {
        return frente == null;
    }

    public Fila enFila(Integer dato) {
        if (dato == null) {
            // Si el dato es null, no se agrega nada.
            return this;
        }

        Nodo aux = new Nodo(dato);
        if (this.esFilaVacia()) {
            // Si la fila está vacía, el nuevo nodo será tanto frente como último.
            this.frente = this.ultimo = aux;
        } else {
            // Si ya hay elementos, se enlaza el nuevo nodo al final.
            this.ultimo.setSiguiente(aux);
            this.ultimo = aux;
        }
        this.cantidad++;
        return this;
    }

    public Integer frente() {
        if (this.esFilaVacia()) {
            return null;
        } else {
            return this.frente.getDato();
        }
    }

    public Fila deFila() {
        if (!this.esFilaVacia()) {
            this.frente = this.frente.getSiguiente();
            this.cantidad--;
            if (this.frente == null) {
                // Si la fila queda vacía después de eliminar, actualizamos el último.
                this.ultimo = null;
            }
        }
        return this;
    }

    public void mostrar() {
        Nodo aux = frente;
        while (aux != null) {
            System.out.print(aux.getDato() + "->");
            aux = aux.getSiguiente();
        }
        System.out.print("NULL");
        System.out.println();
    }

    public int cantidad() {
        return this.cantidad;
    }

//FUNCIONES EXTRA    
    public int[] toArray() {
        int[] rtn = new int[this.cantidad];
        int i = 0;
        Nodo aux = this.frente;
        while (aux != null) {
            rtn[i] = aux.getDato();
            i++;
            aux = aux.getSiguiente();
        }
        return rtn;
    }

    public Fila fromArray(int[] array) {
        for (int i : array) {
            this.enFila(i);
        }
        return this;
    }

    public Fila merge(Fila otra) {
        Nodo aux = otra.frente;
        while (aux != null) {
            this.enFila(aux.getDato());
            aux = aux.getSiguiente();
        }
        return this;
    }

    public Fila copiar() {
        Fila copia = Fila.filaVacia();
        Nodo aux = this.frente;
        while (aux != null) {
            copia.enFila(aux.getDato());
            aux = aux.getSiguiente();
        }
        return copia;
    }

    public void limpiar() {
        this.frente = this.ultimo = null;
        this.cantidad = 0;
    }

    public static Fila enfilan(Fila f, Integer item, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            f.enFila(item);
        }
        return f;
    }

    public static Fila reenfilar(Fila f) {
        if (!f.esFilaVacia()) {
            Integer primero = f.frente();
            f.deFila();
            f.enFila(primero);
        }
        return f;
    }

    public Fila borrar(Integer dato) {
        int cantidadOriginal = this.cantidad;
        if (this.esFilaVacia()) {
            return null;
        }

        for (int i = 0; i < cantidadOriginal; i++) {
            Integer actual = this.frente.getDato();
            this.deFila(); // Quita el elemento actual
            if (!actual.equals(dato)) {
                this.enFila(actual); // Solo re-enfila si no coincide
            }
            // Si coincide, no se vuelve a enfilar => se elimina
        }
        return this;
    }

    static public Fila invertir(Fila fila1) {
        //Auxiliar para guardar temporalmente un elemento de la fila
        Integer e1;

        e1 = fila1.frente();
        if (fila1.esFilaVacia()) {
            return fila1;
        } else {
            return invertir(fila1.deFila()).enFila(e1);
        }
    }

    public Fila dividir(int n) {
        Fila nueva = Fila.filaVacia();
        for (int i = 0; i < n && !this.esFilaVacia(); i++) {
            nueva.enFila(this.frente());
            this.deFila();
        }
        return nueva;
    }

    public static Fila unir(Fila f1, Fila f2) {
        Fila nueva = Fila.filaVacia();
        Nodo aux1 = f1.frente;
        Nodo aux2 = f2.frente;

        while (aux1 != null) {
            nueva.enFila(aux1.getDato());
            aux1 = aux1.getSiguiente();
        }
        while (aux2 != null) {
            nueva.enFila(aux2.getDato());
            aux2 = aux2.getSiguiente();
        }
        return nueva;
    }

}
