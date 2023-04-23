/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.carton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author ACER
 */
public class Carton extends JFrame{
    public  Carton(){
        super();
        nombre = "Bingo de la bondad - carton #";
        ancho = 300;
        alto = 500;
        this.setTitle(nombre);
        this.setBounds(700, 100, ancho, alto);
        this.setBackground(Color.WHITE);
        this.setResizable(false);
        rotulo = new JPanel();
        GridLayout g = new GridLayout(1,5,0,0);
        rotulo.setLayout(g);
        JTextField rotulado[] = new JTextField[5];
        rotulado[0] = new JTextField(" B");
        rotulado[1] = new JTextField(" I");
        rotulado[2] = new JTextField(" N");
        rotulado[3] = new JTextField(" G");
        rotulado[4] = new JTextField(" O");
        for(int x=0; x<rotulado.length; x++){
            rotulado[x].setForeground(Color.BLUE);
            rotulado[x].setFont(new Font("SanSerif",Font.BOLD+Font.CENTER_BASELINE, 40));
            rotulado[x].setBackground(Color.WHITE);
            rotulado[x].setEditable(false);         
            rotulo.add(rotulado[x], x);
            
        }
        objcc = new ContenidoCarton();
        super.setLayout(new BorderLayout());
        
        super.add(objcc, BorderLayout.CENTER);
        super.add(rotulo, BorderLayout.NORTH);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        
    }
    
    
    private final JPanel rotulo;
    private final String nombre;
    private final int ancho, alto;
    private final ContenidoCarton objcc;
}
