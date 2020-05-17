/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproyectofada;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Jesús
 */
public class TextFile {
    
    String rutaArchivo="C:\\Users\\User\\Desktop\\Miniproyecto-FADA-05-2020\\miniProyectoFADA\\src\\entrada.txt";
    
    FileInputStream fRutaArchivo;

    FileWriter fwRutaArchivo=null;

    BufferedWriter bwRutaArchivo;

    DataInputStream frRutaArchivo=null;

    BufferedReader brRutaArchivo;


   public TextFile(){
       
     try{
       fRutaArchivo=new FileInputStream(rutaArchivo);

       fwRutaArchivo=new FileWriter(rutaArchivo,true);
       

       bwRutaArchivo=new BufferedWriter(fwRutaArchivo);

       frRutaArchivo=new DataInputStream(fRutaArchivo);
       
       brRutaArchivo=new BufferedReader(new InputStreamReader(frRutaArchivo));
       
     }catch(IOException e){
       e.printStackTrace();
       System.out.println("error"+e.getMessage());
     }
   }

public boolean yaExiste(String archivo,String objeto){
         boolean respuesta=false;
        String linea;
        
        try{
            if(archivo.equals("fRutaArchivo")){
                fRutaArchivo.getChannel().position(0);
                brRutaArchivo= new BufferedReader(new InputStreamReader(fRutaArchivo));
                while((linea=brRutaArchivo.readLine())!= null){
                    if((objeto.equals(linea))){
                        respuesta=true;
                        linea="";
                    }
                }
                
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error"+e.getMessage());
        }
        return respuesta;
     }

public void guardar(String resultado){
        try{
            
                bwRutaArchivo.write(resultado);
                bwRutaArchivo.newLine(); 
        
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error"+e.getMessage());
        }
    }

public ArrayList<ArrayList<String>> cargarDatos(){
    String linea;
    ArrayList<String> datosEntrada=new ArrayList();
    ArrayList<ArrayList<String>> inputsDelPrograma=new ArrayList();
    String bus[]=new String[5];
    String aux[]=new String[3];
    String descuento[]=new String[1];
    String recarga[]=new String[1];
    String usuario[]=new String[5];
    int i=0;
    try{
        linea=brRutaArchivo.readLine();
        while((linea=brRutaArchivo.readLine())!= null){
            if(linea.equals("// input")){   
                inputsDelPrograma.add((ArrayList<String>)datosEntrada.clone());
                datosEntrada.clear(); 
                
            }else{
                aux=linea.replace(" ", "").split("=");
                datosEntrada.add(aux[1].replace(";", ""));
                //System.out.println(datosEntrada);
            }
            
        }
    }catch(IOException e){
            e.printStackTrace();
            System.out.println("error"+e.getMessage());
        }
    
    return inputsDelPrograma;
}


}
