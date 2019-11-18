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
public class mnodo {
    
    public mnodo der;
    public mnodo izq;
    public mnodo arriba;
    public mnodo abajo;
    public String cliente;
    public String nit;
    public int []cantidad= new int[100];
    public String []producto= new String[100];
    public String []codigo= new String[100];
    public float []precio= new float[100];
    
    public String fecha;
    public String hora;
    public int x;
    public float total;
    public int y;
    public mnodo(String cliente, String nit, int[]cantidad, String[]producto, String[]codigo, float[]precio,float total,String fecha, String hora, mnodo der, mnodo izq,mnodo arriba,mnodo abajo,int x, int y){
        this.cliente=cliente;
        this.nit=nit;
        for(int i=0;cantidad[i]!=0;i++){
            this.cantidad[i]=cantidad[i];
        }
        for(int i=0;producto[i]!=null;i++){
            this.producto[i]=producto[i];
        }
        for(int i=0;codigo[i]!=null;i++){
            this.codigo[i]=codigo[i];
        }
        for(int i=0;precio[i]!=0;i++){
            this.precio[i]=precio[i];
        }
        this.total=total;
        this.fecha=fecha;
        this.hora=hora;
        this.der=der;
        this.izq=izq;
        this.arriba=arriba;
        this.abajo=abajo;
        this.x=x;
        this.y=y;
        
    }
}
