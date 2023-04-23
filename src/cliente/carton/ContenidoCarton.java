/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.carton;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author ACER
 */
public class ContenidoCarton extends JPanel{
    public ContenidoCarton(){
        super();
        f= new Font("Arial",Font.CENTER_BASELINE, 20);
        this.milayout = new GridLayout(5,5,0,0);
        this.setFont(f);
        super.setLayout(milayout);
        super.setBackground (Color.BLACK);
        this.numeros = new JButton[25];
        contenido = new int[5][5];
        estado = new boolean[5][5];
        this.generarContenido();
        logica=new Logica(contenido);       
        for(int x=0; x<this.C_HORIZONTALES; x++){
            for(int y=0; y<this.C_VERTICLAES; y++){
                this.numeros[(x*5)+y] = new JButton(""+contenido[y][x]);
                this.numeros[(x*5)+y] .setFont(f);
                this.numeros[(x*5)+y] .addActionListener(logica);
                this.add(this.numeros[(x*5)+y]);
                if(x==y && (x+y)==4){ 
                    this.numeros[(x*5)+y] .setText("*");
                    this.numeros[(x*5)+y] .setEnabled(false);
                }
                System.out.print(" "+contenido[y][x]);
            }
            System.out.println("");
        }
   
    }
     private void  generarContenido(){
         int n;
         for(int x=0; x<5; x++){
             for(int y=0; y<5; y++){
                 switch (y) {
                     case 0:
                         do {
                             n=(int) (Math.random() * 14 + 1);    
                         }while(this.validarRepetidos( contenido[0], n));
                         contenido[y][x]= n;
                         break;
                     case 1:
                          do {
                             n=(int)Math.round(Math.random()*14 +16);  
                         }while(this.validarRepetidos( contenido[1], n));
                         contenido[y][x]= n;                        
                         break;
                     case 2:
                          do {
                             n=(int) Math.round(Math.random()*14 +31);
                         }while(this.validarRepetidos( contenido[2], n));
                         contenido[y][x]= n;                           
                         break;
                     case 3:
                          do {
                             n=(int) Math.round(Math.random()*14 +46);
                         }while(this.validarRepetidos( contenido[3], n));
                         contenido[y][x]= n;   
                         break;
                     case 4:
                           do {
                             n=(int) Math.round(Math.random()*14 +61);
                         }while(this.validarRepetidos( contenido[4], n));
                         contenido[y][x]= n;  
                         break;
                     default:
                         break;
                 }
                 
            }
         }
     }
     
     private boolean validarRepetidos(int[]v, int n){
        for(int i=0; i<5; i++){
            if(v[i] == n)return true;
        }
         return false;
     }
    
    private int[][] contenido;
    private boolean[][] estado;
    private final GridLayout milayout;
    private final Font f;
    private final JButton numeros[];
    private Logica logica;
    
    private final int C_VERTICLAES = 5;
    private final int C_HORIZONTALES = 5;

}
