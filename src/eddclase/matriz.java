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

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class matriz {
    public  mnodo inicio=null;
    public  mnodo ultimox=null;
    public  mnodo ultimoy=null;
    public  int x=1;
    public  int y=1;
    public void insertar(String cliente, String nit, int[]cantidad, String[]producto, String[]codigo, float[]precio,float total,String fecha, String hora){
        if(inicio==null){
            mnodo nuevo1= new mnodo(cliente,nit,cantidad,producto,codigo,precio,total,fecha,hora,null,null,null,null,x,0);
            mnodo nuevo2= new mnodo(cliente,nit,cantidad,producto,codigo,precio,total,fecha,hora,null,null,null,null,0,y);
            mnodo nuevo3= new mnodo(cliente,nit,cantidad,producto,codigo,precio,total,fecha,hora,nuevo1,null,null,nuevo2,0,0);
            mnodo nuevo4= new mnodo(cliente,nit,cantidad,producto,codigo,precio,total,fecha,hora,null,nuevo2,nuevo1,null,x,y);
            nuevo1.abajo=nuevo4;
            nuevo2.der=nuevo4;
            nuevo1.izq=nuevo3;
            nuevo2.arriba=nuevo3;
            ultimox=nuevo1;
            ultimoy=nuevo2;
            inicio=nuevo3;
            x++;
            y++;
        }else{
            if(encontrar(nit)==true){
                
            
            mnodo nuevo1= new mnodo(cliente,nit,cantidad,producto,codigo,precio,total,fecha,hora,null,ultimox,null,null,x,0);
            mnodo nuevo3= new mnodo(cliente,nit,cantidad,producto,codigo,precio,total,fecha,hora,null,null,nuevo1,null,x,0);
            x++;
            y++;
            nuevo1.abajo=nuevo3;
            ultimox.der=nuevo1;
            ultimox=nuevo1;
            
            mnodo aux1=encontrar2(nit);
            nuevo3.y=aux1.y;
            while (aux1.der!=null){
                aux1=aux1.der;
            }
            nuevo3.izq=aux1;
            aux1.der=nuevo3;
            }else{
            mnodo nuevo1= new mnodo(cliente,nit,cantidad,producto,codigo,precio,total,fecha,hora,null,ultimox,null,null,x,0);
            mnodo nuevo2= new mnodo(cliente,nit,cantidad,producto,codigo,precio,total,fecha,hora,null,null,ultimoy,null,0,y);
            mnodo nuevo3= new mnodo(cliente,nit,cantidad,producto,codigo,precio,total,fecha,hora,null,null,nuevo1,null,x,0);
            x++;
            y++;
            nuevo1.abajo=nuevo3;
            ultimox.der=nuevo1;
            ultimoy.abajo=nuevo2;
            ultimox=nuevo1;
            ultimoy=nuevo2;
            
            mnodo aux1=encontrar2(nit);
            nuevo3.y=aux1.y;
            while (aux1.der!=null){
                aux1=aux1.der;
            }
            nuevo3.izq=aux1;
            aux1.der=nuevo3;
            }
        }
        
    }
    public mnodo encontrar2(String nit){
        mnodo aux=inicio.abajo;
        
        while(aux!=null){
            if(aux.nit.equals(nit)){
                return aux;
            }
            aux=aux.abajo;
        }
        return null;
    }
    public boolean encontrar(String nit){
        mnodo aux=inicio.abajo;
        
        while(aux!=null){
            if(aux.nit.equals(nit)){
                return true;
            }
            aux=aux.abajo;
        }
        return false;
    }
     public void graficar(){
        int contx=0;
        int conty=0;
        mnodo aux1= null;
        mnodo aux2= null;
        String contenido="";
        contenido="digraph G {\n";
        contenido += "node[shape=record, style=filled];\n";
        contenido+= "graph[pencolor=transparent]\n";
        contenido += "edge[color=black];\n";
        if(inicio!=null){
            aux1=inicio.der;
            if(aux1!=null){
                contenido+= "MATRIZ[label=\"Matriz\",pos=\"0,0!\"];\n";
                contx++;
                contenido+= "MATRIZ ->ndC"+aux1.x+aux1.y+";\n";
                
                contenido += "ndC" + aux1.x+aux1.y + " [label = \""+aux1.hora+"\",fillcolor = orangered, pos=\""+(aux1.x*1.5)+",0!\"];\n";
                
                contx++;
                while(aux1.der!=null){
                    
                    contenido += "ndC" + aux1.x+aux1.y + "->" + "ndC" +aux1.der.x+aux1.der.y+"[dir=both];\n";
                    contenido += "ndC" + aux1.der.x+aux1.der.y + " [label = \"" + aux1.der.hora +"\",fillcolor = orangered, pos=\""+(aux1.der.x*1.5)+",0!\"];\n";
                    contx++;
                    aux1 = aux1.der;
                }
                 
            }
            contenido += "\n";
            aux2=inicio.abajo;
            if(aux2!=null){
                
                conty++;
                contenido+= "MATRIZ ->ndF"+aux2.x+aux2.y+";\n";
                
                contenido += "ndF" + aux2.x+aux2.y + " [label = \""+aux2.cliente+"\",fillcolor = orangered, pos=\""+0+",-"+aux2.y+"!\"];\n";
                
                conty++;
                while(aux2.abajo!=null){
                    
                    contenido += "ndF" + aux2.x+aux2.y  + "->" + "ndF" +aux2.abajo.x+aux2.abajo.y+"[dir=both];\n";
                    contenido += "ndF" + aux2.abajo.x+aux2.abajo.y + " [label = \"" + aux2.abajo.cliente +"\",fillcolor = orangered, pos=\""+0+",-"+aux2.abajo.y+"!\"];\n";
                    conty++;
                    aux2 = aux2.abajo;
                }
                 
            }
            conty=1;
            contx=1;
            contenido += "\n";
            aux2 = inicio.abajo;
            if(aux2!=null){
                while(aux2!=null){
                    aux1=aux2;
                    if(aux1.der!=null){
                        contenido += "ndF" +aux1.x+aux1.y + "-> nd" +aux1.der.x+aux1.der.y+ "[dir=both];\n";
                        
                        contenido += "nd" +aux1.der.x+aux1.der.y+ "[label = \"" +aux1.der.total + "\",fillcolor=gold, pos=\""+(aux1.der.x*1.5)+",-"+aux1.der.y+"!\" ];\n";
                        
                        contx++;
                        aux1=aux1.der;
                        while(aux1.der!=null){
                            contenido += "nd" + aux1.x+aux1.y +"-> nd" +aux1.der.x+aux1.der.y+ "[dir=both];\n";
                            contenido += "nd" +aux1.der.x+aux1.der.y+ "[label = \"" +aux1.der.total+ "\",fillcolor=gold,  pos=\""+(aux1.der.x*1.5)+",-"+aux1.der.y+"!\"];\n";
                            contx++;
                            aux1 = aux1.der;
                        }
                    }
                    aux2=aux2.abajo;
                    
                    conty++;
                    contx=conty;
                }
                
            }
            conty=1;
            contx=1;
            aux1=inicio.der;
            if(aux1!=null){
                while(aux1!=null){
                    aux2=aux1;
                    if(aux2.abajo!=null){
                        contenido += "ndC" +aux2.x+aux2.y + "-> nd" +aux2.abajo.x+aux2.abajo.y+ "[dir=both];\n";
			//contenido += "nd" +aux2.abajo.carpeta +"F"+aux2.abajo.padre + "[label = \"" +aux2.abajo.padre+"\\"+aux2.abajo.carpeta + "\",fillcolor=gold, pos=\""+contx+",-"+conty+"!\" ];\n";
                        conty++;
                        aux2=aux2.abajo;
                        while(aux2.abajo!=null){
                            contenido += "nd" + aux2.x+aux2.y +"-> nd" + aux2.abajo.x+aux2.abajo.y+ "[dir=both];\n";
                        //    contenido += "nd" +aux2.abajo.carpeta +"F"+aux2.abajo.padre + "[label = \"" +aux2.abajo.padre+"\\"+aux2.abajo.carpeta+ "\",fillcolor=gold,  pos=\""+contx+",-"+conty+"!\"];\n";
                            conty++;
                            aux2 = aux2.abajo;
                        }
                    }
                    aux1=aux1.der;
                    
                    contx++;
                    conty=contx-1;
                }
            }
            contenido+="\n }";
            
            FileWriter fw = null;
    				PrintWriter pw = null;
        			try{
            			fw = new FileWriter("matriz2.txt");
            			pw = new PrintWriter(fw);

                                
                                pw.println(contenido);
                                    	
                                
            			pw.close();
            			fw.close();
            
            			
        			} catch(IOException v){
            			
        			} finally {
                
        			}
    contenido="";
    try {
      
                    String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\neato.exe";
                     System.out.println("d");
                    String fileInputPath = "C:\\Users\\Julio Garcia\\Documents\\NetBeansProjects\\EDDclase\\matriz2.txt";
                    System.out.println("d");
                    String fileOutputPath = "C:\\Users\\Julio Garcia\\Documents\\NetBeansProjects\\EDDclase\\matriz2.png";
      
                    String tParam = "-Tpng";
                    String tOParam = "-o";
        
                    String[] cmd = new String[5];
                    cmd[0] = dotPath;
                    cmd[1] = tParam;
                    cmd[2] = fileInputPath;
                    cmd[3] = tOParam;
                    cmd[4] = fileOutputPath;
                  
                    Runtime rt = Runtime.getRuntime();
      
                    rt.exec( cmd );
      
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                }
                abrirarchivo("matriz2.png");
            
        
        }
    }
    public void abrirarchivo(String archivo){

     try {

            File objetofile = new File (archivo);
            Desktop.getDesktop().open(objetofile);

     }catch (IOException ex) {

            System.out.println(ex);

     }
    }
}
