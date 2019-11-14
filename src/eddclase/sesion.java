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
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class sesion extends JFrame{
    JLabel lbbienvenida,lbnombre,lbver;
    JButton btnregistrar,btnvender,btnreporte;
    public sesion(){
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
        lbbienvenida=new JLabel ("Opciones");
	lbbienvenida.setFont(fuente); 
        lbbienvenida.setBounds(105,50,300,50);
        lbnombre=new JLabel ("Usuario: "+EDDclase.norm);
        lbnombre.setFont(fuente1); 
        lbnombre.setBounds(10,1,200,50);
      
     
       
        btnregistrar = new JButton("Registrar");
	btnregistrar.setBounds(110,110,110,20);
	btnregistrar.setBackground(Color.white);
	btnregistrar.setFont(fuente1);
	btnregistrar.addActionListener(new ActionListener()
	{
            @Override
            public void actionPerformed(ActionEvent e){
                productos fh = new productos();
                fh.setVisible(true);
            }
        });
        btnreporte = new JButton("Reportes");
	btnreporte.setBounds(110,190,110,20);
	btnreporte.setBackground(Color.white);
	btnreporte.setFont(fuente1);
	btnreporte.addActionListener(new ActionListener()
	{
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
        });
        
        btnvender = new JButton("Vender");
	btnvender.setBounds(110,150,110,20);
	btnvender.setBackground(Color.white);
	btnvender.setFont(fuente1);
	btnvender.addActionListener(new ActionListener()
	{
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
        });
        
        add(lbbienvenida);
        add(lbnombre);
        add(btnregistrar);
        add(btnvender);
        add(btnreporte);
        
   }
}
