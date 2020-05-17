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
    int tipoOrdenamiento;
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
    ArrayList<Integer> listaApariciones = new ArrayList<>();
    AlgoritmosDeOrdenamiento ordenamiento = new AlgoritmosDeOrdenamiento();;
    
    
    public void AlgoritmoIngenuo(int n, int m, int k, ArrayList<String> listaAnimales,
            ArrayList<Integer> listaGrandezas, ArrayList<ArrayList <String>> apertura, ArrayList<ArrayList<ArrayList <String>>> partes, int tipoOrdenamiento){
        this.n=n;
        this.m=m;
        this.k=k;
        this.listaAnimales=listaAnimales;
        this.listaGrandezas=listaGrandezas;
        this.apertura=apertura;
        this.partes= partes;
        this.tipoOrdenamiento = tipoOrdenamiento;
        this.ordenamiento = ordenamiento;
        this.Algortimo();

    }
    
    public void Algortimo(){

        ArrayList<Integer>  escenaOrdenada;
        ArrayList <ArrayList <Integer>> parte = new ArrayList <>();
        ArrayList aperturaOrdenada;
        ArrayList espectaculoFinal;
        int numeroDeEscenas=0;
        int grandezaTotal=0;
        
        
        for(int i = 0; i < listaAnimales.size(); i++ ){
            listaApariciones.add(0);
        }
        
        //se ordenan los animales en cada una de las escenas de la apertura
        for(int i=0; i < (this.m-1)*k; i++){
            escenaString = (apertura.get(i));
            contarAnimal(escenaString);
            escenaOrdenada=ordenarEscena(escenaString);
            parte.add(escenaOrdenada);
        }
        
        ordenarParte(parte, (m-1)*k);
        
        parteOrdenada = (ArrayList<ArrayList<Integer>>) listaResultados.get(0);
        grandezaPorEscena = (ArrayList<Integer>) listaResultados.get(1);
        
        numeroDeEscenas+=grandezaPorEscena.size();
        grandezaTotal+=sumarGrandezas(grandezaPorEscena);
       
               
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
                        contarAnimal(escenaString);
                        escenaOrdenada = ordenarEscena(escenaString);

                        parte.add(escenaOrdenada);
                }


               ordenarParte((ArrayList<ArrayList<Integer>>) parte.clone(), k);
               
               parteOrdenada = (ArrayList<ArrayList<Integer>>) listaResultados.get(0);
               
               grandezaPorEscena = (ArrayList<Integer>) listaResultados.get(1);
               numeroDeEscenas+=grandezaPorEscena.size();
               grandezaTotal+=sumarGrandezas(grandezaPorEscena);

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
        
        //System.out.print("Animal: "+ listaAnimales+ "\n");
        //System.out.print("Apariciones: "+ listaApariciones+ "\n");
        
        
        
        
        System.out.println(ParticipacionMaxMin(listaApariciones, listaAnimales).get(0));
        System.out.println(ParticipacionMaxMin(listaApariciones, listaAnimales).get(1));
        System.out.println(EscenaMaxMin(aperturaOrdenada));
        float promedioGrandeza= (float)grandezaTotal/numeroDeEscenas;
        System.out.println("El promedio de grandeza de todo el espectaculo fue de: "+ promedioGrandeza);
        System.out.println("======================================================================");
        
            
         
        
        
      // TOPE DEL CODIGO

        
        
        
        
    }
    
    public int sumarGrandezas(ArrayList<Integer> GrandezaPorEscena){
        int resultado=0;
        
        for(int i=0;i<grandezaPorEscena.size();i++){
            resultado+=grandezaPorEscena.get(i);
        }
        
        return resultado;
    }
    
    public String EscenaMaxMin(ArrayList<ArrayList<String>> aperturaOrdenada){
        String resultado="";
        
        ArrayList<String> escenaMenor=new ArrayList();
        escenaMenor=aperturaOrdenada.get(0);
        
        int aux=aperturaOrdenada.size()-1;
        ArrayList<String> escenaMayor=new ArrayList();
        escenaMayor=aperturaOrdenada.get(aux);

        resultado="La escena de menor grandeza total fue la escena: "+ escenaMenor + "\n\n"
                + "La escena de mayor grandeza total fue la escena: "+ escenaMayor + "\n"; 
        
        
        return resultado;
    }
    
    public ArrayList<String> ParticipacionMaxMin(ArrayList<Integer> listaApariciones,ArrayList<String> listaAnimales){
        String resultadoMasRepetido="";
        String resultadoMenosRepetido="";
        ArrayList<String> respuesta=new ArrayList();
        
        ArrayList<String> animalMasRepetido=new ArrayList();
        ArrayList<String> animalMenosRepetido=new ArrayList();
        int animalDeMasApariciones=max(listaApariciones);
        int animalDeMenosApariciones=min(listaApariciones);
        
        for (int i=0; i<listaApariciones.size();i++){
            int index=listaApariciones.get(i);
            if(animalDeMasApariciones==index){
                
                String animal=listaAnimales.get(i);
                
                animalMasRepetido.add(animal);
                
            }
            if(animalDeMenosApariciones==index){

                
                String animal=listaAnimales.get(i);
                
                animalMenosRepetido.add(animal);
            }
        }
        
        //Output del animal mas repetido
        resultadoMasRepetido="El animal que participo en mas escenas fue:\n";
        for (int i=0; i<animalMasRepetido.size();i++){
            resultadoMasRepetido= resultadoMasRepetido + animalMasRepetido.get(i)+"\n";
        }
        resultadoMasRepetido=resultadoMasRepetido+ "con " + animalDeMasApariciones + " escenas";
        
        
        //Output del animal menos repetido
        resultadoMenosRepetido="El animal que participo en menos escenas fue:\n";
        for (int i=0; i<animalMenosRepetido.size();i++){
            resultadoMenosRepetido= resultadoMenosRepetido + animalMenosRepetido.get(i)+"\n";
        }
        resultadoMenosRepetido=resultadoMenosRepetido+ "con " + animalDeMenosApariciones + " escenas";
        
        respuesta.add(resultadoMasRepetido);
        respuesta.add(resultadoMenosRepetido);
        
        return respuesta;
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
    
    public int min(ArrayList<Integer> lista){
        int min = lista.get(1);
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) < min) {
                min = lista.get(i);
            }
        }
        return min;
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
        
        
        if(tipoOrdenamiento == 0){
            listaResultados = ordenamiento.QuickSortDosListas(parte, (ArrayList<Integer>) listaValoresMax.clone(), 0, cantidadEscenas-1);

        }
        if(tipoOrdenamiento == 1){
            
            listaResultados = ordenamiento.MergeDosListas(parte, (ArrayList<Integer>) listaValoresMax.clone(), 0, cantidadEscenas-1);

        }
        if(tipoOrdenamiento == 2){
            
        }
        
        
        listaValoresMax.clear();
        
        
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
        
        if(tipoOrdenamiento == 0){
            listaResultados = ordenamiento.QuickSortDosListas(espectaculoAux, listaValoresMax, 0,  m-1-1);
        }
        if(tipoOrdenamiento == 1){
            listaResultados = ordenamiento.MergeDosListas(espectaculoAux, listaValoresMax, 0,  m-1-1);
        }
        if(tipoOrdenamiento == 2){
            
        }
        
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
    
    
    
    public void contarAnimal(ArrayList<String> escena){
        
        String a1 = escena.get(0);
        String a2 = escena.get(1);
        String a3 = escena.get(2);
        int posA1 = listaAnimales.indexOf(a1);
        int posA2 = listaAnimales.indexOf(a2);
        int posA3 = listaAnimales.indexOf(a3);
        
        int aparicionesA1 = listaApariciones.get(posA1);
        int aparicionesA2 = listaApariciones.get(posA2);
        int aparicionesA3 = listaApariciones.get(posA3);


        listaApariciones.set(posA1, 1 + aparicionesA1);
        listaApariciones.set(posA2, 1 + aparicionesA2);
        listaApariciones.set(posA3, 1 + aparicionesA3);

    }

    
    
}


