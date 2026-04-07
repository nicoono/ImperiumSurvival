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
public class MarcoAurelio extends Imperatore {

    MarcoAurelio() {
        super("Marco Aurelio", 115, 20, 30, 0);
        
        this.pathImmagine = "/imperiumsurvival/Marco_Aurelio.png";    
    }

    @Override
    public void usaAbilita() {
        if(turniProtezione ==0){
            this.turniProtezione = 3;
            JOptionPane.showMessageDialog(null, "Marco Aurelio entra in meditazione\n" + "statistiche bloccate e danni dimezzati per 3 turni");
        }
    }
    
}
