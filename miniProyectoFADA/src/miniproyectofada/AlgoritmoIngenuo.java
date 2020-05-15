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
    ArrayList<ArrayList <Integer>> parteOrdenada = new ArrayList<>();
    ArrayList<String> escenaString = new ArrayList <>();
    ArrayList<Integer> escenaInteger = new ArrayList <>();
    ArrayList<ArrayList <Integer>> parteInteger = new ArrayList <>();
    ArrayList listaResultados = new ArrayList<>();
    ArrayList<Integer> grandezaPorEscena = new ArrayList<>();
    ArrayList<ArrayList <Integer>> grandezaPorParte = new ArrayList<>();
    ArrayList<ArrayList<ArrayList <Integer>>> espectaculo = new ArrayList<>();
    ArrayList<ArrayList<ArrayList <Integer>>> espectaculoOrdenado = new ArrayList<>();
    
    public void AlgoritmoIngenuo(int n, int m, int k, ArrayList<String> listaAnimales,
            ArrayList<Integer> listaGrandezas, ArrayList<ArrayList <String>> apertura, ArrayList<ArrayList<ArrayList <String>>> partes){
        this.n=n;
        this.m=m;
        this.k=k;
        this.listaAnimales=listaAnimales;
        this.listaGrandezas=listaGrandezas;
        this.apertura=apertura;
        this.partes= partes;
        this.Algortimo();
        
    }
    
    public void Algortimo(){
        ArrayList<Integer> listaApariciones;

        ArrayList<Integer>  escenaOrdenada;

        ArrayList <ArrayList <Integer>> parte = new ArrayList <>();
        ArrayList aperturaOrdenada;
        ArrayList espectaculoFinal;

        
        
        ArrayList soluciones;
        
        //se ordenan los animales en cada una de las escenas de la apertura
        for(int i=0; i < (this.m-1)*k; i++){
            escenaString = (apertura.get(i));
            //this.contarAnimal(escena);
            escenaOrdenada=ordenarEscena(escenaString);
            parte.add(escenaOrdenada);
        }
        
        ordenarParte(parte, (m-1)*k);
        
        parteOrdenada = (ArrayList<ArrayList<Integer>>) listaResultados.get(0);
        grandezaPorEscena = (ArrayList<Integer>) listaResultados.get(1);
       
        
        aperturaOrdenada= ponerNombresParte(parteOrdenada, (m-1)*k);
        System.out.print("Apertura ordenada: "+aperturaOrdenada+"\n");
        
        listaResultados.clear();
        parte.clear();
        //aperturaOrdenada=ponerNombres();
        
        // Ordenar escenas individuales de las partes
        for (int i=0; i < m-1; i++){
                ArrayList<ArrayList<String>> parteAux = partes.get(i);

                for(int j = 0; j < k; j++){
                        escenaString = parteAux.get(j);
                        //contarAnimal(escena[], listaAnimales, &listaApariciones[])
                        escenaOrdenada = ordenarEscena(escenaString);

                        parte.add(escenaOrdenada);
                }


               ordenarParte((ArrayList<ArrayList<Integer>>) parte.clone(), k);
               
               parteOrdenada = (ArrayList<ArrayList<Integer>>) listaResultados.get(0);
               grandezaPorEscena = (ArrayList<Integer>) listaResultados.get(1);

               espectaculo.add(parteOrdenada);
               // espectáculo = { {{1,2,3} {2,3,4} {2,4,5} {7,8,9}} , 
               // { {2,1,3} {4,1,2} {5,2,1} {9,6,7} }   }

               grandezaPorParte.add(grandezaPorEscena);
               // grandezaPorParte = { {6, 9, 11, 24} , {5, 7, 8, 22} }
                                   // { 32 , 45 }
               parte.clear();
               listaResultados.clear();
        }


        espectaculoOrdenado = ordenarEspectaculo(espectaculo, grandezaPorParte);
        
        espectaculoFinal = ponerNombresEspectaculo(espectaculoOrdenado);
        
        
        
        for(int i = 0; i < espectaculoFinal.size(); i++ ){
            
            int numParte= i +1;
            System.out.print("Parte "+numParte+" : "+espectaculoFinal.get(i)+"\n");
        }
       
        
        
        
        
        
        // Al imprimir el resultado de cada parte sería por cada posición del espectaculoOrdenado  -> ejemplo: espectaculoOrdenado[0] es la primera parte ordenada.

        //espectaculoFinal[] = ponerNombreEspectaculo(espectaculoOrdenado, listaAnimales, listaGrandezas); 


        
        
        
        
        
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
    
    
    public void ordenarParte(ArrayList<ArrayList <Integer>> parte, int cantidadEscenas){
        ArrayList<Integer> listaValoresMax = new ArrayList<>();
        
        
        for(int i = 0; i < cantidadEscenas; i++){
            escenaInteger = parte.get(i);
            int a1 = escenaInteger.get(0);
            int a2 = escenaInteger.get(1);
            int a3 = escenaInteger.get(2);
            int aTotal= a1+a2+a3;
            listaValoresMax.add(aTotal);
        }
        
        QuickSortDosListas(parte, (ArrayList<Integer>) listaValoresMax.clone(), 0, cantidadEscenas-1);
        
        listaValoresMax.clear();
        
        
    }
    
    public void QuickSortDosListas(ArrayList B,ArrayList<Integer> A,int izq,int der){
	
        int pivote=A.get(izq);   // tomamos primer elemento como pivote
        
        int i=izq;               // i realiza la búsqueda de izquierda a derecha
        int j=der;              // j realiza la búsqueda de derecha a izquierda
        int aux;
        ArrayList <Integer> aux2;
        ArrayList <Integer> pivote2 = (ArrayList <Integer>) B.get(izq);
        
        while(i<j){                      // mientras no se crucen las búsquedas
           while(A.get(i)<=pivote && i<j) i++;    // busca elemento mayor que pivote
           while(A.get(j)>pivote) j--;             // busca elemento menor que pivote
           if (i<j) {                                  // si no se han cruzado                      
               aux= A.get(i);                        // los intercambia
               A.set(i, A.get(j));
               
                aux2 = (ArrayList<Integer>) B.get(i);
                B.set(i,B.get(j));

               A.set(j, aux);
               
                B.set(j, aux2);
           }
         }
         A.set(izq,A.get(j)); // se coloca el pivote en su lugar de forma que tendremos
         B.set(izq,B.get(j));
         A.set(j,pivote); // los menores a su izquierda y los mayores a su derecha
         B.set(j,pivote2);
         if(izq<j-1)
            QuickSortDosListas(B, A,izq,j-1); // ordenamos subarray izquierdo
         if(j+1 <der)
            QuickSortDosListas(B, A,j+1,der); // ordenamos subarray derecho

        listaResultados.add(B);
        listaResultados.add(A);
}
    
    
    public ArrayList<ArrayList<ArrayList <Integer>>> ordenarEspectaculo(ArrayList<ArrayList<ArrayList <Integer>>> espectaculoAux,
            ArrayList<ArrayList <Integer>> grandezaAux){
        
        int valorMax = 0;
	ArrayList <Integer> listaValoresMax= new ArrayList();
	for(int i = 0; i < m-1; i++){
            
		grandezaPorEscena = grandezaPorParte.get(i);		
                for(int j = 0; j < k; j++){
                     int a = grandezaPorEscena.get(j);
                     valorMax = valorMax + a; 
                 }
                
		listaValoresMax.add(valorMax);
                valorMax = 0;
		
        }
        listaResultados.clear();
        QuickSortDosListas(espectaculoAux, listaValoresMax, 0,  m-1-1);
        espectaculoOrdenado = (ArrayList<ArrayList<ArrayList<Integer>>>) listaResultados.get(0); 

	return espectaculoOrdenado;

        
    }
    
    
    
    
    public ArrayList ponerNombresParte(ArrayList<ArrayList <Integer>> parteOrdenada, int cantidadEscenas){
        ArrayList<ArrayList<String>> listaSolucion = new ArrayList<>();
        ArrayList<String> listaSubSolucion = new ArrayList<>();
        
        for(int i = 0; i < cantidadEscenas;  i++){
            escenaInteger = parteOrdenada.get(i);
            int a1 = escenaInteger.get(0);
            int a2 = escenaInteger.get(1);
            int a3 = escenaInteger.get(2);
                    
            int posA1 = listaGrandezas.indexOf(a1);
            int posA2 = listaGrandezas.indexOf(a2);
            int posA3 = listaGrandezas.indexOf(a3);
            
            String nombreAnimal1 = listaAnimales.get(posA1);
            String nombreAnimal2 = listaAnimales.get(posA2);
            String nombreAnimal3 = listaAnimales.get(posA3);
            listaSubSolucion.add(nombreAnimal1);
            listaSubSolucion.add(nombreAnimal2);
            listaSubSolucion.add(nombreAnimal3);

            
            listaSolucion.add((ArrayList<String>) listaSubSolucion.clone());
            listaSubSolucion.clear();
        }
        
        
        
        
        
        return listaSolucion;
    }
    
    
    
    public ArrayList ponerNombresEspectaculo(ArrayList<ArrayList<ArrayList <Integer>>> espectaculoAux){
        ArrayList<ArrayList<ArrayList<String>>> listaSolucion = new ArrayList<>();
        ArrayList<ArrayList<String>> parteNombrada = new ArrayList<>();
        
        for(int i = 0; i < m-1; i++){
            parteInteger = espectaculoAux.get(i);
            parteNombrada = ponerNombresParte(parteInteger, k);
            
            listaSolucion.add(parteNombrada);
            
        }

        
        return listaSolucion;
    }

    
    
}


