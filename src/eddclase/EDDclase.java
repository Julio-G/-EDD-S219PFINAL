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
public class EDDclase extends JFrame{
    JLabel lbbienvenida,lbnombre,lbcontra;
    JTextField Nsesion,Csesion;
    JButton btningresar,btnregistrar;
    public static mprod kl = new mprod();
    public static String norm;
    public static lista sd= new lista();
    public static matriz ls= new matriz();
    public static int fcont;
     public EDDclase(){
        super("EDD drive");
        //setSize(800,550);
        setBounds(550,200,350,390);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        progra();
    }
     public void progra(){
        Font fuente1= new Font("Comic Sans MS",0,16);
        Font fuente= new Font("Comic Sans MS",0,26);
        lbbienvenida=new JLabel ("INICIO DE SESION");
	lbbienvenida.setFont(fuente); 
        lbbienvenida.setBounds(35,5,300,50);
        lbnombre=new JLabel ("Nombre:");
        lbnombre.setBounds(50,85,200,50);
        lbcontra=new JLabel ("Password:");
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
                try {
                    String comp=sd.buscar(Nsesion.getText(), toHexString(getSHA(Csesion.getText())));
                    if(!comp.equals("nada")){
                        norm=comp;
                        sesion sj = new sesion();
                        sj.setVisible(true);
                        
                    }else{
                         JOptionPane.showMessageDialog(null,"Los datos no coinciden");
                    }
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(EDDclase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnregistrar = new JButton("Registrar");
	btnregistrar.setBounds(170,200,110,20);
	btnregistrar.setBackground(Color.white);
	btnregistrar.setFont(fuente1);
	btnregistrar.addActionListener(new ActionListener()
	{
            @Override
            public void actionPerformed(ActionEvent e){
                usuario bal=new usuario();
                bal.setVisible(true);
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
     
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        sd.insertar("admin",toHexString(getSHA("admin")));
       /* kl.insertar(10, "0001", 7,"jabon","higiene","avon");
        kl.insertar(6, "0002", 5,"jabon de mano","higiene","avon");*/
       /* int []so=new int[10];
        so[0]=1;
        so[1]=2;
        so[2]=3;
        for(int i=0; so[i]!=0;i++){
            System.out.println(so[i]);
        }*/
      /* matriz ds= new matriz();
       String []jus=new String[5];
       jus[0]="5";
       jus[0]="6";
       String []jus1=new String[5];
       jus1[0]="jabon";
       jus1[0]="cafe";
       String []jus2=new String[5];
       jus2[0]="001";
       jus2[0]="002";
       int []jus4=new int[5];
       jus4[0]=100;
       jus4[0]=200;
       int total=10;
       ds.insertar("juls1", "12345a",jus,jus1,jus2,jus4,10,"2/5/19","12:31");
       ds.insertar("juls2", "12345s",jus,jus1,jus2,jus4,12,"2/5/19","12:32");
       ds.insertar("juls3", "12345d",jus,jus1,jus2,jus4,13,"2/5/19","12:33");
       ds.insertar("juls1", "12345a",jus,jus1,jus2,jus4,14,"2/5/19","12:34");
       ds.graficar();*/
        EDDclase df = new EDDclase();
        df.setVisible(true);
    }
    
}
