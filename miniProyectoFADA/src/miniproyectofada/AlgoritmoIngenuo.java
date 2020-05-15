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
    ArrayList<String> listaAnimales;
    ArrayList<Integer> listaGrandezas;
    ArrayList<Integer> apariciones;
    ArrayList<ArrayList <String>> apertura;
    ArrayList<ArrayList<ArrayList <String>>> partes;
    ArrayList<Integer> grandezaEscena = new ArrayList<>();
    
    public void AlgoritmoIngenuo(int n, int m, int k, ArrayList<String> listaAnimales,
            ArrayList<Integer> listaGrandezas, ArrayList<ArrayList <String>> apertura){
        this.n=n;
        this.m=m;
        this.k=k;
        this.listaAnimales=listaAnimales;
        this.listaGrandezas=listaGrandezas;
        this.apertura=apertura;
        
        this.Algortimo();
        
    }
    
    public void Algortimo(){
        ArrayList<Integer> listaApariciones;

        ArrayList<Integer>  escenaOrdenada;

        ArrayList <ArrayList <Integer>> parte = new ArrayList <>();
        ArrayList aperturaOrdenada;
        ArrayList<Integer> escenaParte;
        ArrayList<String> escena = new ArrayList <>();
        
        ArrayList soluciones;
        
        //se ordenan los animales en cada una de las escenas de la apertura
        for(int i=0; i < (this.m-1)*k; i++){
            escena = (apertura.get(i));
            //this.contarAnimal(escena);
            escenaOrdenada=ordenarEscena(escena);
            parte.add(escenaOrdenada);
        }
        
        System.out.print(parte);
        //ordenarParte(parte, this.k);
        
        //aperturaOrdenada=ponerNombres();
        
    }
    
    public ArrayList<Integer> ordenarEscena(ArrayList<String> escena){
        ArrayList<Integer> listaResultante = new ArrayList<>();
        
        String a1 = escena.get(0);
        String a2 = escena.get(1);
        String a3 = escena.get(2);
        int posA1 = listaAnimales.indexOf(a1);
        int posA2 = listaAnimales.indexOf(a2);
        int posA3 = listaAnimales.indexOf(a3);
        

        grandezaEscena.add(listaGrandezas.get(posA1));
        grandezaEscena.add(listaGrandezas.get(posA2));
        grandezaEscena.add(listaGrandezas.get(posA3));
        
        int max1 = max(grandezaEscena);       
        grandezaEscena.remove((Integer) max1);
        int max2 = max(grandezaEscena); 
        grandezaEscena.remove((Integer) max2);
        int last= grandezaEscena.get(0);
        grandezaEscena.clear();
        
        listaResultante.add(last);
        listaResultante.add(max2);
        listaResultante.add(max1);
        
        return listaResultante;
    }
    
    public int max(ArrayList<Integer> lista){
        int maxAux = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) > maxAux) {
                maxAux = lista.get(i);
            }
        }
        return maxAux;
    }
    
    
}
