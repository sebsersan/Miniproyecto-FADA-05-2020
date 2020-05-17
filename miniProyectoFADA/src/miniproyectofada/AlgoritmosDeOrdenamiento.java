/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproyectofada;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class AlgoritmosDeOrdenamiento {
    ArrayList resultadoGlobal = new ArrayList<>();
    ArrayList resultadoGlobalAux = new ArrayList<>();
    ArrayList B = new ArrayList<>();
    ArrayList<Integer> A = new ArrayList<>();
    
    public void AlgoritmosDeOrdenamiento(){

    }
    
    
    public ArrayList QuickSortDosListas(ArrayList B,ArrayList<Integer> A,int izq,int der){
	ArrayList resultado = new ArrayList<>();
        
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

        resultado.add(B);
        resultado.add(A);

        return resultado;
    }
    
    
    void sort(int l, int m, int r) {       
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
        /* Create temp arrays */
        ArrayList<Integer> L = new ArrayList<>(); 
        ArrayList<Integer> R = new ArrayList<>(); 
        ArrayList L2 = new ArrayList<>(); 
        ArrayList R2 = new ArrayList<>();
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) {
            L.add(A.get(i+l));
            L2.add(B.get(i+l));
        }
        for (int j=0; j<n2; ++j) {
            R.add(A.get(m+1+j));
            R2.add(B.get(m+1+j));
        }
        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L.get(i) <= R.get(j)) 
            { 
                A.set(k,L.get(i));
                B.set(k,L2.get(i));
                i++; 
            } 
            else
            { 
                A.set(k,R.get(j));
                B.set(k,R2.get(j));
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            A.set(k,L.get(i));
            B.set(k,L2.get(i));
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            A.set(k,R.get(j));
            B.set(k,R2.get(j));
            j++; 
            k++; 
        }
        
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    void MergeSortDosListas(int l, int r) { 
        
        
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            MergeSortDosListas(l, m); 
            MergeSortDosListas(m+1, r); 
  
            // Merge the sorted halves 
            sort(l, m, r); 
        }
        
        
    }
    
    public ArrayList MergeDosListas(ArrayList arr1, ArrayList<Integer> arr2, int left, int right){
        B = arr1;
        A = arr2;
        MergeSortDosListas(left, right);
        
        resultadoGlobal.add(B);
        resultadoGlobal.add(A);
        
        resultadoGlobalAux = (ArrayList) resultadoGlobal.clone();
        resultadoGlobal.clear();
        
        return  resultadoGlobalAux;
    }
    
    
    void countingSort(int size, int place) {
        ArrayList<Integer> outputA = (ArrayList<Integer>) A.clone();
        ArrayList outputB = (ArrayList<Integer>) B.clone();
        int max = A.get(0);
        for (int i = 1; i < size; i++) {
          if (A.get(i) > max)
            max = A.get(i);
        }
        int[] count = new int[max + 1];

        for (int i = 0; i < max; ++i)
          count[i] = 0;

        // Calculate count of elements
        for (int i = 0; i < size; i++)
          count[(A.get(i) / place) % 10]++;

        // Calculate cummulative count
        for (int i = 1; i < 10; i++)
          count[i] += count[i - 1];

        // Place the elements in sorted order
        for (int i = size - 1; i >= 0; i--) {
          outputA.set(count[(A.get(i) / place) % 10] - 1, A.get(i));
          outputB.set(count[(A.get(i) / place) % 10] - 1, B.get(i));
          count[(A.get(i) / place) % 10]--;
        }

        for (int i = 0; i < size; i++){
          A.set(i, outputA.get(i));
          B.set(i, outputB.get(i));
        }
    }

    
    // Main function to implement radix sort
    void radixSort(int size) {
      // Get maximum element
      int maxNumber = max(A);

      // Apply counting sort to sort elements based on place value.
      for (int place = 1; maxNumber / place > 0; place *= 10)
        countingSort(size, place);
    }
    
    // Function to get the largest element from an array
    public int max(ArrayList<Integer> lista){
        int maxAux = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) > maxAux) {
                maxAux = lista.get(i);
            }
        }
        return maxAux;
    }

    
    public ArrayList RadixDosListas(ArrayList arr1, ArrayList<Integer> arr2, int size){
        B = arr1;
        A = arr2;
        radixSort(size);
        
        resultadoGlobal.add(B);
        resultadoGlobal.add(A);
        
        resultadoGlobalAux = (ArrayList) resultadoGlobal.clone();
        resultadoGlobal.clear();
        
        return  resultadoGlobalAux;
    }
}
