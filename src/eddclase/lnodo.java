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
public class lnodo {
    public String nombre,contraseña;
    public lnodo sig;
    public lnodo(String nombre,String contraseña,lnodo sig){
        this.nombre=nombre;
        this.contraseña=contraseña;
        this.sig=sig;
    }
}
