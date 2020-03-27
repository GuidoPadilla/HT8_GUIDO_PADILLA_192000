/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht8_guido_padilla;

/**
 *
 * @author sebas
 */
public class Paciente implements Comparable<Paciente>{
    private String name;
    private String prioridad;

    public void setName(String n){
        name = n;
    }
    
    public void setPrioridad(String p){
        prioridad = p;
    }
    
    public String getPrioridad(){
        return prioridad;
    }
    
    public String getName(){
        return name;
    }

    @Override
    public int compareTo(Paciente o) {
        if(prioridad.compareTo(o.prioridad) >  0)
            return 1;
        else
            return -1;
    }

    
}
