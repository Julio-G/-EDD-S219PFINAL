/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eddclase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class reportes extends JFrame{
    JLabel lbbienvenida,lbnombre,lbver;
    JButton btnregistrar,btnvender,btnreporte;
    public reportes(){
        super("EDD drive");
        //setSize(800,550);
        setBounds(550,200,350,380);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        progra();
    }
    public void progra(){
        Font fuente1= new Font("Comic Sans MS",0,16);
        Font fuente= new Font("Comic Sans MS",0,26);
        lbbienvenida=new JLabel ("REPORTES");
	lbbienvenida.setFont(fuente); 
        lbbienvenida.setBounds(105,50,300,50);
      
     
       
        btnregistrar = new JButton("Matriz productos");
	btnregistrar.setBounds(80,110,180,20);
	btnregistrar.setBackground(Color.white);
	btnregistrar.setFont(fuente1);
	btnregistrar.addActionListener(new ActionListener()
	{
            @Override
            public void actionPerformed(ActionEvent e){
                EDDclase.kl.graficar();
            }
        });
        
        btnvender = new JButton("Matriz facturas");
	btnvender.setBounds(90,150,160,20);
	btnvender.setBackground(Color.white);
	btnvender.setFont(fuente1);
	btnvender.addActionListener(new ActionListener()
	{
            @Override
            public void actionPerformed(ActionEvent e){
                EDDclase.ls.graficar();
            }
        });
        
        btnreporte = new JButton("Inventario");
	btnreporte.setBounds(90,190,160,20);
	btnreporte.setBackground(Color.white);
	btnreporte.setFont(fuente1);
	btnreporte.addActionListener(new ActionListener()
	{
            @Override
            public void actionPerformed(ActionEvent e){
                EDDclase.kl.in();
            }
        });
        
        add(lbbienvenida);
        add(btnregistrar);
        add(btnvender);
        add(btnreporte);
        
        
   }    
}
