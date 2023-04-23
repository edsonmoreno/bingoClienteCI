/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

import cliente.carton.Carton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

/**
 *
 * @author ACER
 */
public class Cliente extends JFrame implements Runnable{

    public Cliente(){
        super();
        ancho = 640;
        alto = 480;
        pantalla = new Pantalla();
        usuario = "User Default";
        registroUser = new RUser();
        setTitle("Bingo Mi Juego favorito");
        super.setBounds(20, 20, ancho, alto);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(null);
        super.add(pantalla);
        super.add(this.registroUser);
        ultimos = new ArrayList<>();
        t = new Thread(this);
        super.setVisible(true);

    }
    
    private final int ancho, alto;
    public static String usuario;
    private final Pantalla pantalla;
    private RUser registroUser;
    private ArrayList<String> ultimos;
    public static final String HOST  = "localhost";
    public static final int PUERTO=5000;
    public static String BOLAA;
    private JTextArea visor;
    private Thread t;
    private int aux=0;

    @Override
    public void run() {
        while(true){
        try {
            Socket skCliente = new Socket( HOST , PUERTO );
            InputStream aux = skCliente.getInputStream();
            DataInputStream flujo = new DataInputStream( aux );
            this.aux++;
            visor.setText("");
            String bolita = flujo.readUTF();
            BOLAA = bolita;
            visor.append(""+bolita);
            skCliente.close();
            
        } catch (IOException ex) {
           System.out.println("Hilo cliente error "+aux);      
        }
        }
    }
    
    private class Pantalla extends JPanel implements ActionListener{

        public Pantalla() {
            super();
            Font f = new Font ("Arial", Font.CENTER_BASELINE+Font.BOLD, 50);
            super.setLayout(null);
            super.setBackground(Color.WHITE);
            super.setBounds(0, 0, 400, 480);
            this.agregarBotones();
            visor = new JTextArea("*");
            visor.setFont(f);
            visor.setForeground(Color.ORANGE);
            visor.setEditable(false);
            visor.setBounds(200, 150, 80, 80);
            super.add(visor, BorderLayout.CENTER);
        }
        
    
        private void  agregarBotones(){
            this.camb_nombre = new JButton("Configura tu usuario");
            this.iniciar = new JButton("PLAY");
            this.salir = new JButton("salir");
            super.add(camb_nombre);
            super.add(iniciar);
            super.add(salir);
            
            this.iniciar.setBounds(20, 400, 70, 40);
            this.salir.setBounds(100, 400, 70, 40);
            this.camb_nombre.setBounds(180, 400, 150, 40);
            
            this.salir.addActionListener(this);
            this.iniciar.addActionListener(this);
            this.camb_nombre.addActionListener(this);
        }
        
        private  Carton carton;
        private JButton camb_nombre;
        private JButton iniciar;
        private JButton salir;    

        @Override
        public void actionPerformed(ActionEvent e) {
           
           if(e.getSource().equals((Object)iniciar)){
               carton = new Carton();
              t.start();
             //  t.run();
           }else  if(e.getSource().equals((Object)salir)){
               JOptionPane.showMessageDialog(this, "Gracias por jugar");
               System.exit(0);
    
           }else  if(e.getSource().equals((Object)camb_nombre)){
               usuario = JOptionPane.showInputDialog(this, "Indique su nombre de usuario");
               registroUser.updateUI();
           }
        }
        
    }
    private class RUser extends JPanel{

        public RUser() {
            super();   
            super.setBackground(Color.BLUE);
            super.setBounds(400, 0, 240, 480);
        }
        
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.setColor(Color.WHITE);
            g.drawString("Usuario: "+usuario, 10, 20);
            g.drawString("Ultimas fichas\n: ", 10, 35);
            for(int w=0; w>ultimos.size(); w++){
                g.drawString(" "+ultimos.get(w)+",", 10, 35);
            }
        }
    }
}
