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
import java.io.IOException;
import java.math.BigInteger;  
import java.nio.charset.StandardCharsets; 
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
public class productos extends JFrame{
    JLabel lbbienvenida,lbcat,lbpro,lbmarca,lbcodigo,lbcantidad,lbprecio;
    JTextField Nsesion,Csesion,tfcant,tfcodigo,tfmarca,tfprecio;
    JButton btningresar,btnregistrar;
    public productos(){
        super("EDD drive");
        //setSize(800,550);
        setBounds(550,200,440,440);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        progra();
    }
     public void progra(){
        Font fuente1= new Font("Comic Sans MS",0,16);
        Font fuente= new Font("Comic Sans MS",0,26);
        lbbienvenida=new JLabel ("REGISTRO");
	lbbienvenida.setFont(fuente); 
        lbbienvenida.setBounds(10,2,300,50);
        lbcat=new JLabel ("Categoria:");
        lbcat.setBounds(40,65,200,50);
        lbpro=new JLabel ("Producto:");
        lbpro.setBounds(40,115,200,50);
        lbmarca=new JLabel ("Marca:");
        lbmarca.setBounds(40,165,200,50);
        lbcodigo=new JLabel ("Codigo:");
        lbcodigo.setBounds(40,215,200,50);
        lbcantidad=new JLabel ("Cantidad:");
        lbcantidad.setBounds(40,265,200,50);
        lbprecio=new JLabel ("Precio:");
        lbprecio.setBounds(40,315,200,50);
        Nsesion= new JTextField();
        Nsesion.setBounds(110,80,150,20);
        Csesion= new JTextField();
        Csesion.setBounds(110,130,150,20);
        tfmarca= new JTextField();
        tfmarca.setBounds(110,180,150,20);
        tfcodigo= new JTextField();
        tfcodigo.setBounds(110,230,150,20);
        tfcant= new JTextField();
        tfcant.setBounds(110,280,150,20);
        tfprecio= new JTextField();
        tfprecio.setBounds(110,330,150,20);
       
        
        btnregistrar = new JButton("Registrar");
	btnregistrar.setBounds(290,80,110,20);
	btnregistrar.setBackground(Color.white);
	btnregistrar.setFont(fuente1);
	btnregistrar.addActionListener(new ActionListener()
	{
            @Override
            public void actionPerformed(ActionEvent e){
               char dol=tfcant.getText().charAt(0);
               char dol2=tfprecio.getText().charAt(0);
               if(Character.isLetter(dol)==false && Character.isLetter(dol2)==false){
                   EDDclase.kl.insertar(Float.parseFloat(tfprecio.getText()),tfcodigo.getText(),Integer.parseInt(tfcant.getText()),Csesion.getText(),Nsesion.getText(),tfmarca.getText());
                   JOptionPane.showMessageDialog(null,"producto registrado");
               }else {
                   JOptionPane.showMessageDialog(null,"No puede ingresar letras en la cantidad y precio");
               }
                  
            }
        });
        add(lbbienvenida);
        add(Nsesion);
        add(Csesion);
        add(lbpro);
        add(lbcat);
        add(btnregistrar);
        add(lbcantidad);
        add(lbmarca);
        add(lbcodigo);
        add(tfcant);
        add(tfcodigo);
        add(tfmarca);
        add(tfprecio);
        add(lbprecio);
        
   }
            
}
