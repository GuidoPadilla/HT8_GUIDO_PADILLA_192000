/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht8_guido_padilla;

import java.util.Scanner;

/**
 *
 * @author sebas
 */
public class HT8_GUIDO_PADILLA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Controlador controlador;
        String type = "";
        
        while(!type.equals("3")){
            System.out.print("Ingrese el numero el tipo de Heap que quiere para analizar su arhivo de txt  en source llamado pacientes.txt o ponga 3 si desea salir: \n1.'VectorHeap'\n2.'PriorityQueue'\n3. Salir\n");
            type = scanner.nextLine();
            if(type.equals("1") || type.equals("2")){
                controlador = new Controlador(Integer.valueOf(type));
                System.out.println(controlador.recorrer());
            }
            
        }
        
    }
    
}
