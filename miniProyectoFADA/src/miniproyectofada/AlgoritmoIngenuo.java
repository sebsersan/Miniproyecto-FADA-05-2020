/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproyectofada;

import java.util.ArrayList;

/**
 *
 * @author Jesús
 */
public class AlgoritmoIngenuo {
    int n;
    int m;
    int k;
    String[] listaAnimales;
    int[] listaGrandezas;
    int[] apariciones;
    ArrayList<String[]> apertura;
    ArrayList<ArrayList> partes;
    
    public void AlgoritmoIngenuo(int n, int m, int k, String[] listaAnimales,int[] listaGrandezas,ArrayList apertura,ArrayList partes){
        this.n=n;
        this.m=m;
        this.k=k;
        this.listaAnimales=listaAnimales;
        this.listaGrandezas=listaGrandezas;
        this.apertura=apertura;
        this.partes=partes;
    }
    
    public void OrdenarEscenas(){
        ArrayList listaApariciones;
        ArrayList espectaculoOrdenado;
        ArrayList escenaOrdenada;
        ArrayList parteOrdenada;
        ArrayList parte=new ArrayList();
        ArrayList aperturaOrdenada;
        
        //se ordenan los animales en cada una de las escenas de la apertura
        for(int i=0; i < (this.m-1)*k; i++){
            String[] escena=this.apertura.get(i);
            this.contarAnimal(escena);
            escenaOrdenada=ordenarEscena(escena);
            parte.set(i, escenaOrdenada);
        }
        int[] aux;
            
        aux=ordenarParte();
        
        aperturaOrdenada=ponerNombres();
        
        
    }
    
    public void contarAnimal(String[] escena){
        
    }
    
    public ArrayList ordenarEscena(String[] escena){
        ArrayList a=new ArrayList();
        a.add(1);
        return a;
    }
    
    public int[] ordenarParte(){
        int[] resultado={1};
        
        return resultado;
    }
    
    public ArrayList ponerNombres(){
        ArrayList resultado=new ArrayList();
        
        return resultado;
    }
}
