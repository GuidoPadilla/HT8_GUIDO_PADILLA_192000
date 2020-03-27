/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht8_guido_padilla;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author sebas EXTRAIDO DE JAVASTRUCTURES2 pg 320-327 Duane A. Bailey, William College September 2007 el 3/27/2020
 */
public class VectorHeap {
    protected Vector<Paciente> data;
    
    public VectorHeap()
    {
        data = new Vector<Paciente>();
    }
    
    public VectorHeap(ArrayList<Paciente> v){
        int i;
        data = new Vector<Paciente>(v.size());
        for(i = 0; i < v.size(); i++)
            add(v.get(i));
    }

    
    private int parent(int i)
    {
        return (i-1)/2;
    }
    
    private int left(int i)
    {
        return 2*i+1;
    }
    private int right(int i)
    {
        return 2*(i+1);
    }
    
    protected void percolateUp(int leaf){
        int parent = parent(leaf);
        Paciente priority = data.get(leaf);
        while(leaf > 0 && (priority.getPrioridad().compareTo(data.get(parent).getPrioridad()) < 0)){
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf, priority);
    }
    
    public void add(Paciente value)
    {
        data.add(value);
        percolateUp(data.size()-1);
    }

    protected void pushDownRoot(int root){
        int heapSize = data.size();
        Paciente value = data.get(root);
        while(root < heapSize){
            int childpos = left(root);
            if(childpos < heapSize)
            {
                if((right(root) < heapSize) && ((data.get(childpos+1)).getPrioridad().compareTo(data.get(childpos).getPrioridad()) < 0))
                    childpos++;
                if((data.get(childpos)).compareTo(value) < 0){
                    data.set(root, data.get(childpos));
                    root = childpos;
                }
                else{
                    data.set(root, value);
                    return;
                }
            }
            else{
                data.set(root, value);
                return;
            }
        }
    }
    /*
    Retira el primer elemento del heap y corre los elementos sin eliminar el orden
    */
    public Paciente remove()
    {
        Paciente minVal = data.firstElement();
        data.set(0, data.get(data.size()-1));
        data.setSize(data.size()-1);
        if(data.size() > 1) pushDownRoot(0);
        return minVal;
    }
}
