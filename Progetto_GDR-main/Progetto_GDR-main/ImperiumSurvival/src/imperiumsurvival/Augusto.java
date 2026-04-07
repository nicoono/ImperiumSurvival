/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imperiumsurvival;

import javax.swing.JOptionPane;

/**
 *
 * @author onorati.nicolo
 */
public class Augusto extends Imperatore {

    Augusto() {
        super("Augusto", 130, 30, 30);
        
            this.pathImmagine = "/imperiumsurvival/Augusto.png";
    }

    

    @Override
    public void usaAbilita() {
        JOptionPane.showMessageDialog(null, "Augusto ha proclamato la Pax Romana!\n" +"L'ordine è ristabilito: Malcontento -30, Dissenso -30, Salute +15.");
        
        this.salute += 20;
        this.dissenso -= 10;
        this.malcontento -= 10;
        
        
    }
    
}
