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
public class GiulioCesare extends Imperatore {

    public GiulioCesare() {
        // Ora il "super" trova il costruttore corrispondente in Imperatore
        super("Giulio Cesare", 100, 30, 10, 0); 
        
        this.pathImmagine = "/imperiumsurvival/Giulio_Cesare.png"; 
    }

    @Override
    public void usaAbilita() {
        JOptionPane.showMessageDialog(null,"Giulio Cesare ha varcato il Rubicone: Alea Iacta Est!\n" + "Il popolo esulta (Malcontento a 0), ma il Senato trama vendetta (Dissenso +20).");
        this.malcontento = 0;
        this.dissenso += 20;
    }
    
    
    
}
