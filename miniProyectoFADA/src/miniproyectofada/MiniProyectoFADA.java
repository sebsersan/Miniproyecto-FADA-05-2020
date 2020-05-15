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
        
        ArrayList<String> Animales = new ArrayList<>();
        ArrayList<Integer> Grandezas = new ArrayList<>();
        ArrayList<ArrayList <String>> Apertura = new ArrayList<>();
        ArrayList<String> escena = new ArrayList<>();
        ArrayList<ArrayList<ArrayList <String>>> partes = new ArrayList<>();
        ArrayList<ArrayList <String>> parte = new ArrayList<>();
        
        Animales.add("gato");
        Animales.add("libelula");
        Animales.add("ciempies");
        Animales.add("nutria");
        Animales.add("perro");
        Animales.add("tapir");
        
        Grandezas.add(3);
        Grandezas.add(2);
        Grandezas.add(1);
        Grandezas.add(6);
        Grandezas.add(4);
        Grandezas.add(5);

        
        escena.add("tapir");
        escena.add("nutria");
        escena.add("perro");
        Apertura.add((ArrayList<String>) escena.clone());
        escena.clear();
        
        escena.add("tapir");
        escena.add("perro");
        escena.add("gato");
        Apertura.add((ArrayList<String>) escena.clone());
        escena.clear();
        
        escena.add("ciempies");
        escena.add("tapir");
        escena.add("gato");
        Apertura.add((ArrayList<String>) escena.clone());
        escena.clear();
        
        escena.add("gato");
        escena.add("ciempies");
        escena.add("libelula");
        Apertura.add((ArrayList<String>) escena.clone());
        escena.clear();
        
        // ----------------------------------- PARTES
        escena.add("tapir");
        escena.add("nutria");
        escena.add("perro");
        parte.add((ArrayList<String>) escena.clone());
        escena.clear();
        
        escena.add("ciempies");
        escena.add("tapir");
        escena.add("gato");
        parte.add((ArrayList<String>) escena.clone());
        escena.clear();
        
        partes.add((ArrayList<ArrayList<String>>) parte.clone());
        
        parte.clear();
        
        escena.add("gato");
        escena.add("ciempies");
        escena.add("libelula");
        parte.add((ArrayList<String>) escena.clone());
        escena.clear();
        
        escena.add("tapir");
        escena.add("perro");
        escena.add("gato");
        parte.add((ArrayList<String>) escena.clone());
        escena.clear();
        partes.add((ArrayList<ArrayList<String>>) parte.clone());

        
        
        
        AlgoritmoIngenuo Algoritmo = new AlgoritmoIngenuo();
        Algoritmo.AlgoritmoIngenuo(6, 3, 2, Animales, Grandezas, Apertura, partes);
    }
    
}
