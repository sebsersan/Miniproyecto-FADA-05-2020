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
public class MiniProyectoFADA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<String> Animales = new ArrayList<String>();
        ArrayList<Integer> Grandezas = new ArrayList<Integer>();
        ArrayList<ArrayList <String>> Apertura = new ArrayList<ArrayList <String>>();
        ArrayList<String> escena = new ArrayList<String>();
        ArrayList<String> escenaAux = new ArrayList<String>();
        
        Animales.add("tapir");
        Animales.add("nutria");
        Animales.add("perro");
        Animales.add("gato");
        Animales.add("tiburon");
        Animales.add("pez");
        
        Grandezas.add(1);
        Grandezas.add(2);
        Grandezas.add(3);
        Grandezas.add(4);
        Grandezas.add(5);
        Grandezas.add(6);

        
        escena.add("pez");
        escena.add("tapir");
        escena.add("tiburon");
        Apertura.add((ArrayList<String>) escena.clone());
        escena.clear();
        
        escena.add("perro");
        escena.add("nutria");
        escena.add("gato");
        Apertura.add((ArrayList<String>) escena.clone());
        escena.clear();
        
        escena.add("tiburon");
        escena.add("nutria");
        escena.add("pez");
        Apertura.add((ArrayList<String>) escena.clone());
        escena.clear();
        
        escena.add("tapir");
        escena.add("perro");
        escena.add("pez");
        Apertura.add((ArrayList<String>) escena.clone());
        escena.clear();

        
        AlgoritmoIngenuo Algoritmo = new AlgoritmoIngenuo();
        Algoritmo.AlgoritmoIngenuo(6, 3, 2, Animales, Grandezas, Apertura);
    }
    
}
