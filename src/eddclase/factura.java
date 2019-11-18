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
public class factura extends JFrame {
    JLabel lbbienvenida,lbnombre,lbcontra;
    JTextField Nsesion,Csesion;
    JButton btningresar,btnregistrar;
    public static String cliente;
    public static String nit;
    public factura(){
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
        lbbienvenida=new JLabel ("Registro de cliente");
	lbbienvenida.setFont(fuente); 
        lbbienvenida.setBounds(45,5,300,50);
        lbnombre=new JLabel ("Nombre:");
        lbnombre.setBounds(50,85,200,50);
        lbcontra=new JLabel ("ID:");
        lbcontra.setBounds(50,135,200,50);
        Nsesion= new JTextField();
        Nsesion.setBounds(120,100,150,20);
        Csesion= new JTextField();
        Csesion.setBounds(120,150,150,20);
        btningresar = new JButton("Ingresar");
	btningresar.setBounds(115,200,100,20);
	btningresar.setBackground(Color.white);
	btningresar.setFont(fuente1);
	btningresar.addActionListener(new ActionListener()
	{
            @Override
            public void actionPerformed(ActionEvent e){
                cliente=Nsesion.getText();
                nit=Csesion.getText();
                factura2 bn=new factura2();
                bn.setVisible(true);
                dispose();
            }
        });
      
        add(lbbienvenida);
        add(Nsesion);
        add(Csesion);
        add(lbcontra);
        add(lbnombre);
        add(btningresar);
        
   }
}
