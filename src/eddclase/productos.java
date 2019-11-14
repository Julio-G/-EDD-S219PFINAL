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
    JLabel lbbienvenida,lbcat,lbpro,lbmarca,lbcodigo,lbcantidad;
    JTextField Nsesion,Csesion;
    JButton btningresar,btnregistrar;
    public productos(){
        super("EDD drive");
        //setSize(800,550);
        setBounds(550,200,440,340);
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
        lbcat.setBounds(40,85,200,50);
        lbpro=new JLabel ("Producto:");
        lbpro.setBounds(40,135,200,50);
        Nsesion= new JTextField();
        Nsesion.setBounds(110,100,150,20);
        Csesion= new JTextField();
        Csesion.setBounds(110,150,150,20);
        
        btnregistrar = new JButton("Registrar");
	btnregistrar.setBounds(290,100,110,20);
	btnregistrar.setBackground(Color.white);
	btnregistrar.setFont(fuente1);
	btnregistrar.addActionListener(new ActionListener()
	{
            @Override
            public void actionPerformed(ActionEvent e){
               
            }
        });
        add(lbbienvenida);
        add(Nsesion);
        add(Csesion);
        add(lbpro);
        add(lbcat);
        add(btnregistrar);
        
   }
            
}
