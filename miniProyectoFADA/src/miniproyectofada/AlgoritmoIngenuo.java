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
    ArrayList listaAnimales;
    ArrayList listaGrandezas;
    ArrayList<ArrayList> apertura;
    ArrayList<ArrayList> partes;
    
    public void AlgoritmoIngenuo(int n, int m, int k, ArrayList listaAnimales,ArrayList listaGrandezas,ArrayList apertura,ArrayList partes){
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
        ArrayList escenasOrdenadas;
        ArrayList animalesOrdenados;
        ArrayList parteOrdenada;
        ArrayList parte;
        
        //se ordenan los animales en cada una de las escenas de la apertura
        for(int i=0; i < (this.m-1)*k; i++){
            ArrayList escena=this.apertura;
            
        }
    }
}
