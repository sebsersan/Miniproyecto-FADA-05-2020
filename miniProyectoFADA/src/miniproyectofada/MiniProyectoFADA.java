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
        String[] animales={"gato","perro"};
        System.out.println(animales[0]+ animales[1]);
        int [] grandeza={2,2};
        ArrayList<String[]> apertura=new ArrayList();
        String[] dupla={"hola", "jeje"};
        System.out.println(dupla[0]+ dupla[1]);
        apertura.add(dupla);
        System.out.println(apertura.get(0)[0]);
        String [] partes={"jojo"};
        //AlgoritmoIngenuo hola=AlgoritmoIngenuo(6,3,2,animales, grandeza, apertura ,partes);
    }
    
}
