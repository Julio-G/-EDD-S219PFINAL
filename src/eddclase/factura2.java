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
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;  
import java.nio.charset.StandardCharsets; 
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
public class factura2 extends JFrame {
     JLabel lbbienvenida,lbnombre,lbcontra;
    JTextField Nsesion,Csesion;
    JButton btningresar,btnregistrar;
    int cont=0;
    String []codigo =new String[100];
    String []nombre =new String[100];
    float []precio =new float[100];
    int []cantidad =new int[100];
    
    public factura2(){
         super("EDD drive");
        //setSize(800,550);
        setBounds(550,200,350,390);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        progra();
    }
    public void progra(){
        Font fuente1= new Font("Comic Sans MS",0,16);
        Font fuente= new Font("Comic Sans MS",0,26);
        lbbienvenida=new JLabel ("Ingreso de productos");
	lbbienvenida.setFont(fuente); 
        lbbienvenida.setBounds(45,5,300,50);
        lbnombre=new JLabel ("Cantidad:");
        lbnombre.setBounds(50,85,200,50);
        lbcontra=new JLabel ("Codigo:");
        lbcontra.setBounds(50,135,200,50);
        Nsesion= new JTextField();
        Nsesion.setBounds(120,100,150,20);
        Csesion= new JTextField();
        Csesion.setBounds(120,150,150,20);
        btningresar = new JButton("Ingresar");
	btningresar.setBounds(50,200,100,20);
	btningresar.setBackground(Color.white);
	btningresar.setFont(fuente1);
	btningresar.addActionListener(new ActionListener()
	{
            @Override
            public void actionPerformed(ActionEvent e){
               char dol=Nsesion.getText().charAt(0);
               if(Character.isLetter(dol)==false ){
                   if(EDDclase.kl.bnombre(Csesion.getText()).equals("no")==false){
                    if(EDDclase.kl.resta(Csesion.getText(),Integer.parseInt(Nsesion.getText()))==true){
                        
                        cantidad[cont]=Integer.parseInt(Nsesion.getText());
                        nombre[cont]=EDDclase.kl.bnombre(Csesion.getText());
                        codigo[cont]=Csesion.getText();
                        precio[cont]=EDDclase.kl.bprecio(Csesion.getText());
                        cont++;
                        JOptionPane.showMessageDialog(null,"Ingresado");
                        }else{
                            JOptionPane.showMessageDialog(null,"No hay suficiente producto");
                        }
                   }else{
                       JOptionPane.showMessageDialog(null,"El producto no existe");
                   }
                   
                   
               }else{
                    JOptionPane.showMessageDialog(null,"No puede ingresar letras en la cantidad");
               }
            }
        });
        btnregistrar = new JButton("Facturar");
	btnregistrar.setBounds(170,200,110,20);
	btnregistrar.setBackground(Color.white);
	btnregistrar.setFont(fuente1);
	btnregistrar.addActionListener(new ActionListener()
	{
            @Override
            public void actionPerformed(ActionEvent e){
                float total=0;
                for(int i=0;nombre[i]!=null;i++){
                    total=total+cantidad[i]*precio[i];
                }
                System.out.println(total);
                Calendar c = Calendar.getInstance();
                String dia = Integer.toString(c.get(Calendar.DATE));
                String mes = Integer.toString(c.get(Calendar.MONTH));
                String annio = Integer.toString(c.get(Calendar.YEAR));
                String año=dia+"/"+mes+"/"+annio;
                dia=c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE);
                EDDclase.ls.insertar(factura.cliente, factura.nit, cantidad, nombre, codigo, precio,total,año,dia);
                try {
            String ruta = "factura.txt";
            String contenido = "--------Datos del vendedor--------\n";
            contenido+="        Tienda del chino, S.A.\n";
            contenido+="0 calle 0-60,z.7\n";
            contenido+="--------Datos del cliente--------\n";
            contenido+="       Nombre: "+factura.cliente+"\n";
            contenido+="       NIT: "+factura.nit+"\n";
            contenido+="---Descripcion de la factura---\n";
            for(int i=0;nombre[i]!=null;i++){
                contenido+="Cant.       Descripcion      precio\n";
                contenido+="  "+cantidad[i]+"     "+nombre[i]+"     "+precio[i]+"\n";
     
            }
            contenido+="Total: "+total;
            File file = new File(ruta);
           
            file.createNewFile();
            
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
            JOptionPane.showMessageDialog(null,"Factura generada");
        } catch (IOException p) {
            p.printStackTrace();
        }
         
            }
        });
        add(lbbienvenida);
        add(Nsesion);
        add(Csesion);
        add(lbcontra);
        add(lbnombre);
        add(btnregistrar);
        add(btningresar);
        
   }
}
