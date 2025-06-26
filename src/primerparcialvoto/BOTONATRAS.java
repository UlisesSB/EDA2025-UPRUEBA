/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcialvoto;

/**
 *
 * @author estudiante
 */
public class BOTONATRAS {
    public Nodo actual;
    public int cantidad;
    
    public class Nodo{
        Nodo anterior;
        String URL;
        public Nodo NodoVacio(){
            this.anterior=null;
            this.URL=null;
            return this;
        }        
    }
    
    
    
    public BOTONATRAS VACIO(){
        BOTONATRAS boton;
        boton = new BOTONATRAS();
        boton.actual=boton.actual.NodoVacio();
        boton.cantidad=0;
        return boton;
    }
    
    public BOTONATRAS REGISTRAR(BOTONATRAS boton, String url){
        Nodo nuevo= new Nodo();
        nuevo.anterior=this.actual;
        this.actual=nuevo;
        this.actual.URL=url;
        this.cantidad=this.cantidad+1;
        return this;
    }
    
    public Boolean ESVACIO(BOTONATRAS boton){
        return this.actual == null;
    }
    public BOTONATRAS LIMPIAR(BOTONATRAS boton){
        boton = VACIO();
        return boton;
    }
    public BOTONATRAS VOLVER(BOTONATRAS boton){
        this.actual= this.actual.anterior;
        this.cantidad=this.cantidad-1;
        return this; 
    }
    
    public String ANTERIOR(BOTONATRAS boton){
        return this.actual.anterior.URL;
    }
    
    public Boolean ESTA(BOTONATRAS boton,String url){
        if (ESVACIO(this)){
            return false;
        }
        else{
            if (url.equals(this.actual.URL)){
                return true;
            }
            else
            return ESTA(VOLVER(boton),url);
        }
    }
    
    public BOTONATRAS ELIMINAR(BOTONATRAS boton,String url){
        if (ESVACIO(this)){
            return this;
        }
        else{
            if (url.equals(this.actual.URL))
                return ELIMINAR(VOLVER(this),url);
            else{
                return REGISTRAR(ELIMINAR(VOLVER(this),url),this.actual.URL);
            }   
        }
    }
    
    public int CANTIDAD(BOTONATRAS boton){
        return this.cantidad;
    }
    
    public void MOSTRAR(BOTONATRAS boton){
        if (ESVACIO(this)){
            return ;
        }
        else{
            System.out.print(boton.actual.URL);
            MOSTRAR(VOLVER(boton));
        }

    }
}
