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
public class pnodo {
    public pnodo der;
    public pnodo izq;
    public pnodo arriba;
    public pnodo abajo;
    public String producto;
    public String categoria;
    public String marca;
    public int x,cant;
    public int y;
    public String codigo;
    public pnodo(String codigo,int cant,String producto,String categoria,String marca,pnodo der,pnodo izq,pnodo arriba,pnodo abajo,int x,int y){
        this.producto=producto;
        this.categoria=categoria;
        this.marca=marca;
        this.der=der;
        this.izq=izq;
        this.arriba=arriba;
        this.abajo=abajo;
        this.x=x;
        this.y=y;
        this.cant=cant;
        this.codigo=codigo;
    }
}
