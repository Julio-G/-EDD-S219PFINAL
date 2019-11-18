/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eddclase;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Julio Garcia
 */
public class mprod {
    public  pnodo inicio=null;
    public  pnodo ultimox=null;
    public  pnodo ultimoy=null;
    public  int x=1;
    public  int y=1;
    public void insertar(float precio,String codigo,int cantidad,String producto,String categoria,String marca){
         if(inicio==null){
            pnodo nuevo1= new pnodo(0,"espacio",0,"espacio",categoria,"espacio",null,null,null,null,x,0);
            pnodo nuevo2= new pnodo(precio,codigo,0,producto,categoria,marca,null,null,null,null,0,y);
            pnodo nuevo3= new pnodo(0,"inicio",0,"inicio","inicio","inicio",nuevo1,null,null,nuevo2,0,0);
            pnodo nuevo4= new pnodo(precio,codigo,cantidad,"espacio","espacio","espacio",null,nuevo2,nuevo1,null,x,y);
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
             if(buscarcat(categoria)){
                if(buscarpro(producto,marca,categoria)){
                      pnodo aux=encontrar2(producto,marca,categoria);
                      aux.der.cant=aux.der.cant+cantidad;
                }else{
                    pnodo nuevo2= new pnodo(precio,codigo,0,producto,categoria,marca,null,null,ultimoy,null,0,y);
                    pnodo nuevo3= new pnodo(precio,codigo,cantidad,"espacio","espacio","espacio",null,nuevo2,null,null,0,y);
                    y++;
                    nuevo2.der=nuevo3;
                    ultimoy.abajo=nuevo2;
                    ultimoy=nuevo2;
                    pnodo aux=encontrar(categoria);
                    nuevo3.x=aux.x;
                    while(aux.abajo!=null){
                        aux=aux.abajo;
                    }
                    nuevo3.arriba=aux;
                    aux.abajo=nuevo3;
                }
             }else{
                pnodo nuevo1= new pnodo(0,"espacio",0,"espacio",categoria,"espacio",null,ultimox,null,null,x,0);
                pnodo nuevo2= new pnodo(precio,codigo,0,producto,categoria,marca,null,null,ultimoy,null,0,y);
                pnodo nuevo3= new pnodo(precio,"espacio",cantidad,"espacio","espacio","espacio",null,nuevo2,nuevo1,null,x,y);
                x++;
                y++;
                nuevo2.der=nuevo3;
                nuevo1.abajo=nuevo3;
                ultimox.der=nuevo1;
                ultimoy.abajo=nuevo2;
                ultimox=nuevo1;
                ultimoy=nuevo2;
               
             }
        }
        
    }
    public boolean buscarcat(String categoria){
        pnodo aux=inicio.der;
        while(aux!=null){
            if(aux.categoria.equals(categoria)){
                return true;
            }
            aux=aux.der;
        }
        return false;
    }
    public pnodo encontrar(String categoria){
        pnodo aux=inicio.der;
        while(aux!=null){
            if(aux.categoria.equals(categoria)){
                return aux;
            }
            aux=aux.der;
        }
        return null;
    }
    public boolean buscarpro(String producto, String marca, String categoria){
        pnodo aux=inicio.abajo;
        while(aux!=null){
            if(aux.categoria.equals(categoria)&&aux.producto.equals(producto)&&aux.marca.equals(marca)){
                return true;
            }
            aux=aux.abajo;
        }
        return false;
    }
    public pnodo encontrar2(String producto, String marca, String categoria){
        pnodo aux=inicio.abajo;
        while(aux!=null){
            if(aux.categoria.equals(categoria)&&aux.producto.equals(producto)&&aux.marca.equals(marca)){
                return aux;
            }
            aux=aux.abajo;
        }
        return null;
    }
    public String bnombre(String codigo){
        pnodo aux=inicio.abajo;
        while(aux!=null){
            if(aux.codigo.equals(codigo)){
                return aux.producto;
            }
             aux=aux.abajo;
        }
        return "no";
    }
    public float bprecio(String codigo){
        pnodo aux=inicio.abajo;
        while(aux!=null){
            if(aux.codigo.equals(codigo)){
                return aux.precio;
            }
            aux=aux.abajo;
        }
        return 0;
    }
    public boolean resta(String codigo,int cant){
        pnodo aux=inicio.abajo;
        while(aux!=null){
            if(aux.codigo.equals(codigo)){
                int bol=aux.der.cant;
                bol=bol-cant;
                
                if(bol<0){
                    return false;
                }else{
                    aux.der.cant=aux.der.cant-cant;
                    return true;
                }
            }
            aux=aux.abajo;
        }
        return false;
    }
    public void in(){
        pnodo aux;
        String contenido="----------------------Inventario----------------------\n";
        if(inicio!=null){
            aux=inicio.der;
            while(aux!=null){
                contenido+="**"+aux.categoria+": \n";
                contenido+="Cant.    Descripcion    codigo   precio\n";
                pnodo aux2=aux.abajo;
                while(aux2!=null){
                    contenido+="  "+aux2.cant+"     "+aux2.izq.producto+"    "+aux2.izq.codigo+"    "+aux2.precio+"\n";
                    aux2=aux2.abajo;
                }
                
                aux=aux.der;
            }
             try {
            String ruta = "inventario.txt";
           
          
            File file = new File(ruta);
           
            file.createNewFile();
            
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
            JOptionPane.showMessageDialog(null,"inventario generado");
            abrirarchivo("inventario.txt");
        } catch (IOException p) {
            p.printStackTrace();
        }
        }
    }
    public void graficar(){
        int contx=0;
        int conty=0;
        pnodo aux1= null;
        pnodo aux2= null;
        String contenido="";
        contenido="digraph G {\n";
        contenido += "node[shape=record, style=filled];\n";
        contenido+= "graph[pencolor=transparent]\n";
        contenido += "edge[color=black];\n";
        if(inicio!=null){
            aux1=inicio.der;
            if(aux1!=null){
                contenido+= "MATRIZ[label=\"Inicio\",pos=\"0,0!\"];\n";
                contx++;
                contenido+= "MATRIZ ->ndC"+aux1.x+aux1.y+";\n";
                
                contenido += "ndC" + aux1.x+aux1.y + " [label = \""+aux1.categoria+"\",fillcolor = orangered, pos=\""+(aux1.x*1.5)+",0!\"];\n";
                
                contx++;
                while(aux1.der!=null){
                    
                    contenido += "ndC" + aux1.x+aux1.y + "->" + "ndC" +aux1.der.x+aux1.der.y+"[dir=both];\n";
                    contenido += "ndC" + aux1.der.x+aux1.der.y+ " [label = \"" + aux1.der.categoria +"\",fillcolor = orangered, pos=\""+(aux1.der.x*1.5)+",0!\"];\n";
                    contx++;
                    aux1 = aux1.der;
                }
                 
            }
            contenido += "\n";
            aux2=inicio.abajo;
            if(aux2!=null){
                
                conty++;
                contenido+= "MATRIZ ->ndF"+aux2.x+aux2.y+";\n";
                
                contenido += "ndF" + aux2.x+aux2.y + " [label = \"Nombre: "+aux2.producto+"\\n Marca: "+aux2.marca+"\\n Codigo: "+aux2.codigo+"\",fillcolor = orangered, pos=\""+0+",-"+aux2.y+"!\"];\n";
                
                conty++;
                while(aux2.abajo!=null){
                    
                    contenido += "ndF" + aux2.x+aux2.y+ "->" + "ndF" +aux2.abajo.x+aux2.abajo.y+"[dir=both];\n";
                    contenido += "ndF" + aux2.abajo.x+aux2.abajo.y + " [label = \"Nombre: " + aux2.abajo.producto+"\\n Marca: "+aux2.abajo.marca+"\\n Codigo: "+aux2.abajo.codigo+"\",fillcolor = orangered, pos=\""+0+",-"+aux2.abajo.y+"!\"];\n";
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
                        
                        contenido += "nd" +aux1.der.x+aux1.der.y + "[label = \"" +aux1.der.cant+ "\",fillcolor=gold, pos=\""+(aux1.der.x*1.5)+",-"+aux1.der.y+"!\" ];\n";
                 
                        contx++;
                        aux1=aux1.der;
                        while(aux1.der!=null){
                            contenido += "nd" + aux1.x+aux1.y + " -> nd" + aux1.der.x+aux1.der.y + "[dir=both];\n";
                            contenido += "nd" +aux1.der.x+aux1.der.y+ "[label = \"" +aux1.der.cant+ "\",fillcolor=gold,  pos=\""+(aux1.der.x*1.5)+",-"+aux1.der.y+"!\"];\n";
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
			contenido += "nd" +aux2.abajo.x+aux2.abajo.y+ "[label = \"" +aux2.abajo.cant+ "\",fillcolor=gold, pos=\""+(aux2.abajo.x*1.5)+",-"+aux2.abajo.y+"!\" ];\n";
                        conty++;
                        aux2=aux2.abajo;
                        while(aux2.abajo!=null){
                            contenido += "nd" + aux2.x+aux2.y+ " -> nd" +aux2.abajo.x+aux2.abajo.y+ "[dir=both];\n";
                            contenido += "nd" +aux2.abajo.x+aux2.abajo.y+ "[label = \"" +aux2.abajo.cant+ "\",fillcolor=gold,  pos=\""+(aux2.abajo.x*1.5)+",-"+aux2.abajo.y+"!\"];\n";
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
            			fw = new FileWriter("matriz.txt");
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
                    String fileInputPath = "matriz.txt";
                    System.out.println("d");
                    String fileOutputPath = "matriz.png";
      
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
                abrirarchivo("matriz.png");
            
            
        
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
