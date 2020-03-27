/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht8_guido_padilla;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author sebas
 */
public class Controlador {
    private VectorHeap v1;
    private PriorityQueue<Paciente> v2;
    private ArrayList<Paciente> l;
    public Controlador(int n){
        
        l = importText();
        if(n == 1){
            v1 = new VectorHeap(l);
        }
        if(n == 2){
            v2 = new PriorityQueue<>();
            for (Paciente l1 : l) {
                v2.add(l1);
            }
        }
    }
    
    public String recorrer(){
        String mensaje = "";
        if(v1 == null){
            for (Paciente l1 : l) {
                Paciente temp = v2.remove();
                mensaje += temp.getName() + ", "+ temp.getPrioridad()+ "\n";
            }
        }
        else{
            for (Paciente l1 : l) {
                Paciente temp = v1.remove();
                mensaje += temp.getName() + ", "+ temp.getPrioridad() + "\n";
            }
        }
        return mensaje;
    }
    
    
    public ArrayList<Paciente> importText() {
        File inputStream = null;
        ArrayList<Paciente> lista = new ArrayList<Paciente>();
        String everything = "";
        try {
            inputStream = new File(System.getProperty("user.dir")+"\\src\\pacientes.txt");
            Scanner myReader = new Scanner(inputStream);
            while (myReader.hasNextLine()) {
              everything = myReader.nextLine();
              String[] l = everything.split(", ");
              Paciente p = new Paciente();
              p.setName(l[0] + ", " + l[1]);
              p.setPrioridad(l[2]);
              lista.add(p);
            }
            /*everything = myReader.nextLine();*/
            myReader.close();
        } catch (FileNotFoundException ex) {

        }
        return lista;
    }
}
