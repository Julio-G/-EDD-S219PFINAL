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
public class usuario extends JFrame{
    JLabel lbbienvenida,lbnombre,lbcontra,lbver;
    JTextField Nsesion,Csesion,Vsesion;
    JButton btningresar,btnregistrar;
    public usuario(){
         super("EDD drive");
        //setSize(800,550);
        setBounds(550,200,350,420);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        progra();
    }
    public void progra(){
        Font fuente1= new Font("Comic Sans MS",0,16);
        Font fuente= new Font("Comic Sans MS",0,26);
        lbbienvenida=new JLabel ("REGISTRO");
	lbbienvenida.setFont(fuente); 
        lbbienvenida.setBounds(90,5,300,50);
        lbnombre=new JLabel ("Nombre:");
        lbnombre.setBounds(50,85,200,50);
        lbcontra=new JLabel ("Password:");
        lbcontra.setBounds(50,135,200,50);
        Nsesion= new JTextField();
        Nsesion.setBounds(120,100,150,20);
        Csesion= new JTextField();
        Csesion.setBounds(120,150,150,20);
        lbver=new JLabel ("Admin:");
        lbver.setBounds(50,185,200,50);
        Vsesion= new JTextField();
        Vsesion.setBounds(120,200,150,20);
       
        btnregistrar = new JButton("Registrar");
	btnregistrar.setBounds(110,250,110,20);
	btnregistrar.setBackground(Color.white);
	btnregistrar.setFont(fuente1);
	btnregistrar.addActionListener(new ActionListener()
	{
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    if(Vsesion.getText().equals("admin")&&Csesion.getText().length()>=6){
                         EDDclase.sd.insertar(Nsesion.getText(), toHexString(getSHA(Csesion.getText())));
                         JOptionPane.showMessageDialog(null,"Usuario registrado");
                    }else{
                        JOptionPane.showMessageDialog(null,"Los datos no coinciden");
                    }
                       
                   
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        add(lbbienvenida);
        add(Nsesion);
        add(Csesion);
        add(lbcontra);
        add(lbnombre);
        add(btnregistrar);
        add(lbver);
        add(Vsesion);
        
   }
   public static byte[] getSHA(String input) throws NoSuchAlgorithmException 
    {  
        // Static getInstance method is called with hashing SHA  
        MessageDigest md = MessageDigest.getInstance("SHA-256");  
  
        // digest() method called  
        // to calculate message digest of an input  
        // and return array of byte 
        return md.digest(input.getBytes(StandardCharsets.UTF_8));  
    } 
    
    public static String toHexString(byte[] hash) 
    { 
        // Convert byte array into signum representation  
        BigInteger number = new BigInteger(1, hash);  
  
        // Convert message digest into hex value  
        StringBuilder hexString = new StringBuilder(number.toString(16));  
  
        // Pad with leading zeros 
        while (hexString.length() < 32)  
        {  
            hexString.insert(0, '0');  
        }  
  
        return hexString.toString();  
    } 
}
