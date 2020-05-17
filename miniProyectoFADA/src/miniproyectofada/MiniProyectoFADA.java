/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproyectofada;


import java.util.ArrayList;
import java.util.Scanner;

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
        ArrayList<ArrayList<ArrayList<String>>> todasLasPartes=new ArrayList();
        int tipoDeOrdenamiento = 2;
                // 0    -> quickSort
                // 1    -> mergeSort
                // 2    -> radixSort

        TextFile nuevo= new TextFile();
        ArrayList<ArrayList<String>> inputs=nuevo.cargarDatos();
        
        ArrayList<ArrayList<String>> partesString=new ArrayList();
        
        System.out.println ("Empezamos el programa");
        System.out.println ("1. Ordenamiento QuickSort (O(n^2))\n"
                          + "2. Ordenamiento MergeSort (O(n*Log n))\n"
                          + "3. Ordenamiento RadixSort(O(n))");
        
        System.out.println ("Por favor seleccione el método de ordenamiento a usar(Escriba 1, 2 o 3) y presione Enter:");

        String entradaTeclado = "";
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner

        entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner

        tipoDeOrdenamiento=Integer.parseInt(entradaTeclado)-1;
        
        //For de los Input
        for(int i=0; i<inputs.size();i++){
            ArrayList<String> input=inputs.get(i);
            int n=Integer.parseInt(input.get(0));
            int m=Integer.parseInt(input.get(1));
            int k=Integer.parseInt(input.get(2));
            ArrayList<String> apertura=new ArrayList();
            ArrayList<ArrayList <String>> partesAux=new ArrayList(); 
            //System.out.println(input.get(5));
            
            //For de animales y grandezas
                String[] aux;
                ArrayList listas=new ArrayList();
                aux=input.get(3).replace("{", "").replace("}", "").split(",");
                for(int h=0;h<aux.length;h++){
                    listas.add(aux[h]);
                }
                //System.out.println(listas);
                //System.out.println(listas);
                Animales=(ArrayList<String>) listas.clone();
                listas.clear();
                
                aux=input.get(4).replace("{", "").replace("}", "").split(",");
                for(int h=0;h<aux.length;h++){
                    listas.add(Integer.parseInt(aux[h]));
                }
                //System.out.println(listas);
                Grandezas=(ArrayList<Integer>) listas.clone();
                listas.clear();
                //System.out.println(listas);
                
            
            
            
            //For de la apertura y las partes
            for(int j=5;j<input.size();j++){
                ArrayList<String> sublistas=new ArrayList();
                ArrayList<ArrayList<String>> lista=new ArrayList();
                
                
                partesAux=new ArrayList();
                aux=input.get(j).replace("{", "").replace("}", "").split(",");
                for(int h=0;h<aux.length;h++){
                    if((h+1)%3==0){
                        sublistas.add(aux[h]);
                        
                        lista.add((ArrayList<String>)sublistas.clone());
                        //System.out.println(lista);
                        sublistas.clear();
                    }else{
                        
                        sublistas.add(aux[h]);
                        
                    }
                    
                            
                }
                todasLasPartes.add((ArrayList<ArrayList<String>>) lista.clone());
                lista.clear();
                //System.out.println(todasLasPartes);
                
                
                
            }
            //System.out.println(partesString);
            Apertura=todasLasPartes.get(0);
            todasLasPartes.remove(Apertura);
            partes=(ArrayList<ArrayList<ArrayList<String>>>) todasLasPartes.clone();
                todasLasPartes.clear();
                //System.out.println(partes);
                
                AlgoritmoIngenuo Algoritmo = new AlgoritmoIngenuo();
                long startTime =  System.currentTimeMillis();
                Algoritmo.AlgoritmoIngenuo(n, m, k, Animales, Grandezas, Apertura, partes, tipoDeOrdenamiento);
                long endTime =  System.currentTimeMillis();
                
                System.out.println(("tiempo de ejecución: " + (endTime-startTime) + " milisegundo(s)"));
            
        }
        
        
        //AlgoritmoIngenuo Algoritmo = new AlgoritmoIngenuo();
        //Algoritmo.AlgoritmoIngenuo(6, 3, 2, Animales, Grandezas, Apertura, partes);
    }
}
