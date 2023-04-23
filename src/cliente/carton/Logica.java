/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.carton;

import cliente.Cliente;
import static cliente.Cliente.BOLAA;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class Logica implements ActionListener{
    
    public Logica(){
        posicion = new boolean[5][5];
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                posicion[i][j]=false;
            }
        }
    }

    public Logica(int[][] carton) {
        this.carton = carton;
        posicion = new boolean[5][5];
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                posicion[i][j]=false;
            }
        }
        posicion[2][2]=true;
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("accion"+((JButton)e.getSource()).getText());
        if(!Cliente.BOLAA.equalsIgnoreCase(((JButton)e.getSource()).getText())) return;
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(carton[j][i] == Integer.parseInt(((JButton)e.getSource()).getText())){
                    System.out.print("* ");
                    posicion[j][i]=true;
                    //boton oprimido boton inhabilitado
                    ((JButton)e.getSource()).setEnabled(false);
                }
                else{
                    System.out.print(""+carton[j][i]+" ");
                }
            }
            System.out.println("");
        }  
        this.ganaorr();
    }
    
    public boolean ganaorr (){
        boolean r=true;
    
        //ganadores en vertival u hotizontal
        for(int i=0; i<5; i++){
            if(posicion[0][i] == true &&
               posicion[1][i] == true &&
               posicion[2][i] == true &&
               posicion[3][i] == true &&
               posicion[4][i] == true ){
              conexion();
               JOptionPane.showMessageDialog(null, "winn");
             
            }else if(posicion[i][0] == true &&
                posicion[i][1] == true &&
                posicion[i][2] == true &&
                posicion[i][3] == true &&
                posicion[i][4] == true ){
              conexion();
              JOptionPane.showMessageDialog(null, "winn");
              
            }
        }          
        //diagonal principal
        if(posicion[0][0] == true &&
           posicion[1][1] == true &&
           posicion[2][2] == true &&
           posicion[3][3] == true &&
           posicion[4][4] == true ){
              
              conexion();
              JOptionPane.showMessageDialog(null, "winn");
        }else if(posicion[0][4] == true &&
               posicion[1][3] == true &&
               posicion[2][2] == true &&
               posicion[3][1] == true &&
               posicion[4][0] == true ){
            conexion();
            JOptionPane.showMessageDialog(null, "winn");
            
        }else if(posicion[0][0] == true &&
               posicion[0][4] == true &&
               posicion[4][0] == true &&
               posicion[4][4] == true){
        conexion();
         JOptionPane.showMessageDialog(null, "winn");
       }

        return r;
    }
    
    private void conexion(){
        try {
            Socket skCliente = new Socket( Cliente.HOST , 5001 );
            OutputStream aux = skCliente.getOutputStream();
            DataOutputStream flujo = new DataOutputStream( aux );
            flujo.writeUTF("-"+Cliente.usuario);
            skCliente.close();  
        } catch (IOException ex) {
           System.out.println("Hilo cliente error "+ex.getMessage());      
        }        
    }
    
    private boolean posicion[][];
    private int carton[][];
}
