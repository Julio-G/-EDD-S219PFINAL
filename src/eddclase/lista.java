/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eddclase;

/**
 *
 * @author Julio Garcia
 */
public class lista {
    public lnodo inicio=null;
    
    public void insertar(String nombre, String contraseña){
        if(inicio==null){
            lnodo nuevo = new lnodo(nombre,contraseña,null);
            inicio=nuevo;
        }else{
            lnodo nuevo = new lnodo(nombre,contraseña,inicio);
            inicio=nuevo;
        }
    }
    public String buscar(String nombre,String contraseña){
        lnodo aux=inicio;
        
        while(aux!=null){
            if(aux.nombre.equals(nombre)&&aux.contraseña.equals(contraseña)){
                return aux.nombre;
            }
            aux=aux.sig;
        }
        return "nada";
    }
}
