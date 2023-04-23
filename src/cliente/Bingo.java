package cliente;

import cliente.carton.Carton;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author ACER
 */
public class Bingo {
    
    /**
     * @param args the command line arguments
     */
    
    
    public Bingo() {
        this.newClient = new  Cliente();
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Bingo b = new Bingo();
    }
    
    
    private Cliente newClient;
}
