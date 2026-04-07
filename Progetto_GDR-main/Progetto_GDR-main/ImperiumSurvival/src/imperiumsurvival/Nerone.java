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
public class Nerone extends Imperatore {

    Nerone() {
        super("Nerone", 100, 10, 30);
        
        this.pathImmagine = "/imperiumsurvival/Nerone.png";
    }

    @Override
    public void usaAbilita() {
        JOptionPane.showMessageDialog(null, "Nerone ha dato fuoco a Roma!\n" +"Il Dissenso è AZZERATO, ma l'incendio ti è costato 30 Salute.");
        
        this.dissenso=0;
        this.salute -= 30;
    }
    
}
