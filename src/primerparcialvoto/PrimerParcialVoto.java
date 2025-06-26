/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package primerparcialvoto;
/**
 *
 * @author estudiante
 */
public class PrimerParcialVoto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    BOTONATRAS boton1= new BOTONATRAS();
    BOTONATRAS boton2= new BOTONATRAS();
    BOTONATRAS boton3= new BOTONATRAS();
    boton1= boton1.VACIO();
    boton2= boton2.VACIO();
    boton3= boton3.VACIO();
    
    String url1= "a";
    String url2= "b";
    String url3= "c";
    String url4= "d";
    String url5= "e";
    
    boton1.REGISTRAR(boton1, url1);
    boton1.REGISTRAR(boton1, url2);
    boton1.REGISTRAR(boton1, url3);
    
    System.out.print(boton1.ESVACIO(boton1));   
    System.out.print(boton2.ESVACIO(boton2));
    
    boton1.MOSTRAR(boton1);
    boton1.VOLVER(boton1);
    boton1.MOSTRAR(boton1);
    
    boton1.LIMPIAR(boton1);
    boton1.MOSTRAR(boton1);

    }
    
    
    
    
    
    
    
public BOTONATRAS UNION(BOTONATRAS boton1,BOTONATRAS boton2){
        BOTONATRAS union= boton1;
            if (boton1.ESVACIO(boton1)&& boton2.ESVACIO(boton2)){
            return union;
        }
        else{
            if (boton1.ESVACIO(boton1))
                return boton2;
            else{
                 if (boton2.ESVACIO(boton2)){
                     return union;
                 }
                 else{
                     while (!boton2.ESVACIO(boton2)){
                         union.REGISTRAR(union, boton2.actual.URL);
                         boton2.VOLVER(boton2);
                     }
                     return union;
                 }
            }   
        }
    }

}
    
